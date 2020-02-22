/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.macaca.POS;

import io.macaca.LanguageModels.NgramProb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Part of speech tagger using the Viterbi algorithm
 * @author mayowa
 */
public class PosTagger implements PosTagging, Serializable{
    
    //transition probabilities
    private NgramProb transitionProb;
    
    
    private Map<String, Map<String, Integer>> emmisionTable;
    private List<String> pos = new ArrayList();

    /**
     * Initializes the tagger
     * @param sentences Training data. Tokens must be of the form <b>word::tag</b> except start and stop tokens
     */
    public PosTagger(ArrayList<List<String>> sentences){
        emmisionTable = new HashMap();
        train(sentences);
    }

    
    private void train(ArrayList<List<String>> sentences){
        ArrayList<List<String>> posSequence = new ArrayList();
        sentences.forEach((List<String> sentence) -> { 
            List<String> tagSequence = new ArrayList();
            sentence.forEach((String token) -> {
            if(!token.contains("::")){
                tagSequence.add(token);
                if(!pos.contains(token)){
                   pos.add(token);
                }
            }else{
                String[] arr = token.split("::");
                String word = arr[0];
                String tag = arr[1];
                tagSequence.add(tag);
                if(!pos.contains(tag)){
                   pos.add(tag);
                }
                if(emmisionTable.containsKey(word)){
                    if(emmisionTable.get(word).containsKey(tag)){
                       emmisionTable.get(word).put(tag, emmisionTable.get(word).get(tag) + 1);
                    }else{
                        emmisionTable.get(word).put(tag, 1);
                    }
                }else{
                    Map<String, Integer> map = new HashMap();
                    map.put(tag, 1);
                    emmisionTable.put(word, map);
                }
            }
        });
            posSequence.add(tagSequence);
        });
        transitionProb = new NgramProb(2, posSequence);
        
    }
    
    /**
     * Determines the parts of speech of each token in the array
     * @param sentence A sequence of tokens
     * @return A sequence of part of speech tags
     */
    public List<WordTag> tag(List<String> sentence){
        List<String> tags = new ArrayList();
        ViterbiEntry[][] viterbiMatrix = new ViterbiEntry[sentence.size()][pos.size()];
        
        //filling in the first word's data
        String word;
        for(int x = 0; x <= sentence.size(); x++){
            
            for(int y = 0; y < pos.size(); y++){
                if(!pos.get(y).equals("<s>") && !pos.get(y).equals("</s>")){
                    if(x == 0){
                        word = sentence.get(x);
                        int wordistag = wordIsTagCount(word, pos.get(y)) + 1;
                        int wordoccured = wordOccuredCount(word) + emmisionTable.size();
                        double emmision = Math.log((double)wordistag/wordoccured);
                        List<String> list = new ArrayList();
                        list.add("<s>");
                        list.add(pos.get(y));
                        double transition = transitionProb.getProb(list);
                        double data = transition + emmision;
                        ViterbiEntry entry = new ViterbiEntry();
                        entry.addProb(data, -1);
                        viterbiMatrix[x][y] = entry;

                    }else if(x == sentence.size()){
                        ViterbiEntry entry = new ViterbiEntry();
                        for(int i = 0; i < pos.size(); i++){
                            if(!pos.get(i).equals("<s>") && !pos.get(i).equals("</s>")){
                                List<String> list = new ArrayList();
                                list.add(pos.get(i));
                                list.add("</s>");
                                double transition = transitionProb.getProb(list);
                                double data = transition;
                                data += viterbiMatrix[x - 1][i].max;
                                entry.addProb(data, i);
                            }
                        }
                        
                        return getSequence(sentence, viterbiMatrix, entry, x);
                    }else{
                        word = sentence.get(x);
                        int wordistag = wordIsTagCount(word, pos.get(y)) + 1;
                        int wordoccured = wordOccuredCount(word) + emmisionTable.size();
                        double emmision = Math.log((double)wordistag/wordoccured);
                        ViterbiEntry entry = new ViterbiEntry();
                        for(int i = 0; i < pos.size(); i++){
                            if(!pos.get(i).equals("<s>") && !pos.get(i).equals("</s>")){
                                List<String> list = new ArrayList();
                                list.add(pos.get(i));
                                list.add(pos.get(y));
                                double transition = transitionProb.getProb(list);
                                double data = transition + emmision;
                                data += viterbiMatrix[x - 1][i].max;
                                entry.addProb(data, i);

                            }
                            
                        }
                        viterbiMatrix[x][y] = entry;
                    }
                    
                }
            }
            
        }
       return null;
    }

    private int wordIsTagCount(String word, String tag){
        try{
            return emmisionTable.get(word).get(tag);
        }catch(NullPointerException ex){
            return 0;
        }
    }
    
    private int wordOccuredCount(String word){
        int n = emmisionTable.size();
        try{
            Iterator<String> iterator = emmisionTable.get(word).keySet().iterator();
            while(iterator.hasNext()){
                String tag = iterator.next();
                n += emmisionTable.get(word).get(tag);
            }
        }catch(NullPointerException ex){
            
        }
        
        return n;
    }
    
    private List<WordTag> getSequence(List<String> sentence, ViterbiEntry[][] viterbiMatrix, ViterbiEntry entry, int x){
        List<String> sequence = new ArrayList();
        Stack<String> stack = new Stack();
        while(true){
            if(entry.maxY == -1){
                break;
            }else{
                stack.push(pos.get(entry.maxY));
                x -= 1;
                entry = viterbiMatrix[x][entry.maxY];
            }
        }
        while(!stack.isEmpty()){
            sequence.add(stack.pop());
        }
        List<WordTag> wordTagList = new ArrayList<>();
        for(int i = 0; i < sentence.size(); i++) {
            wordTagList.add(new WordTag(sentence.get(i), sequence.get(i)));
        }
        return wordTagList;
    }
    
    
    private class ViterbiEntry{
        
        private double max = -10000;
        private int maxY;
        public ArrayList<Data> data = new ArrayList();
        ViterbiEntry(){
            
        }
        
        public void addProb(double dat, int y){
            data.add(new Data(dat, y));
            data.stream().filter((d) -> (d.data > max)).map((d) -> {
                max = d.data;
                return d;
            }).map((d) -> {
                d.y = y;
                return d;
            }).forEach((_item) -> {
                maxY = y;
            });
        }
        
  
    }
    
    private class Data{
        public double data;
        public int x;
        public int y;
        Data(double data, int y){
            this.data = data;
            this.y = y;
        }
    }
    
    
     
    
}
