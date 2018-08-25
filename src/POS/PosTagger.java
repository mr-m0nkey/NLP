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
                        double transition = transitionProb.getProb(list, true);
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
                                double transition = transitionProb.getProb(list, true);
                                double data = transition;
                                data += viterbiMatrix[x - 1][i].max;
                                entry.addProb(data, i);
                            }
                        }
                        
                        getSequence(sentence, viterbiMatrix, entry, x);
                        break;
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
                                double transition = transitionProb.getProb(list, true);
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
       
    }

    private int wordIsTagCount(String word, String tag){
        try{
            return emmisionTable.get(word).get(tag);
        }catch(NullPointerException ex){
            return 0;
        }
    }
    
    private int wordOccuredCount(String word){
        int n = 0;
        Iterator<String> iterator = emmisionTable.get(word).keySet().iterator();
        while(iterator.hasNext()){
            String tag = iterator.next();
            n += emmisionTable.get(word).get(tag);
        }
        return n;
    }
    
    private void getSequence(List<String> sentence, ViterbiEntry[][] viterbiMatrix, ViterbiEntry entry, int x){
        
        while(true){
            if(entry.maxY == -1){
                break;
            }else{
                System.out.println(pos.get(entry.maxY));
                x -= 1;
                entry = viterbiMatrix[x][entry.maxY];
            }
            
        }
    }
    
    
    private class ViterbiEntry{
        
        private double max = -10000;
        private int maxY;
        public ArrayList<Data> data = new ArrayList();
        ViterbiEntry(){
            
        }
        
        public void addProb(double dat, int y){
            data.add(new Data(dat, y));
            for(Data d : data){
                if(d.data > max){
                    max = d.data;
                    d.y = y;
                    maxY = y;
                }
            }
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
