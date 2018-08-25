/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import LanguageModels.NgramProb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class PosTagger {
    
    //transition probabilities
    private NgramProb transitionProb;
    
    
    private Map<String, Map<String, Integer>> emmisionTable;
    private List<String> pos = new ArrayList();

    /**
     *
     * @param sentences
     */
    public PosTagger(ArrayList<List<String>> sentences){
        emmisionTable = new HashMap();
        train(sentences);
    }

    /**
     *
     * @param sentences
     */
    public void train(ArrayList<List<String>> sentences){
        ArrayList<List<String>> posSequence = new ArrayList();
        sentences.forEach((List<String> sentence) -> { 
            List<String> tagSequence = new ArrayList();
            sentence.forEach((String token) -> {
            if(token.equals("<s>") || token.equals("</s>")){
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
     *
     * @param sentence
     */
    public void tag(List<String> sentence){
        List<String> tags = new ArrayList();
        ViterbiEntry[][] viterbiMatrix = new ViterbiEntry[sentence.size()][pos.size() + 1];
        
        for(int x = 0; x < sentence.size(); x++){
            viterbiMatrix[x][pos.size() - 2] = new ViterbiEntry(-10000, -1, -1);
        }
        
        //filling in the first word's data
        String firstWord = sentence.get(0);
        for(int y = 0; y < pos.size() - 1; y++){
            if(!pos.get(y).equals("<s>") && !pos.get(y).equals("</s>")){
                int wordistag = wordIsTag(firstWord, pos.get(y));
                int wordoccured = wordOccured(firstWord);
                List<String> list = new ArrayList();
                list.add("<s>");
                list.add(pos.get(y));
                double transition = transitionProb.getProb(list, true);
                double data = transition * (wordistag/wordoccured);
                viterbiMatrix[0][y] = new ViterbiEntry(data, -1, -1);
                if(data > viterbiMatrix[0][pos.size() - 2].getData()){
                    viterbiMatrix[0][pos.size() - 2] = new ViterbiEntry(data, 0, y);
                }
                System.out.println(firstWord + " " + pos.get(y) + " " + data + " " + y);
            }
        }
        
        //filling in the rest of the data
    }

    private int wordIsTag(String word, String tag){
        try{
            return emmisionTable.get(word).get(tag);
        }catch(NullPointerException ex){
            return 0;
        }
    }
    
    private int wordOccured(String word){
        int n = 0;
        Iterator<String> iterator = emmisionTable.get(word).keySet().iterator();
        while(iterator.hasNext()){
            String tag = iterator.next();
            n += emmisionTable.get(word).get(tag);
        }
        return n;
    }
    
    
    private class ViterbiEntry{
        
        private double data;
        private int parentX;
        private int parentY;
        ViterbiEntry(double data, int parentX, int parentY){
            this.data = data;
            this.parentX = parentX;
            this.parentY = parentY;
        }
        
        public double getData(){
            return data;
        }
        
        public int getX(){
            return parentX;
        }
        
        public double getY(){
            return parentY;
        }
    }
   
    
     
    
}
