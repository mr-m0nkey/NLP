/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageModels;

import DataStructures.Vertex;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * Ngram language model
 * @author mayowa
 */
public class NgramProb implements ILanguageModel , Serializable{
    
    
    private Map<String, Vertex> vertices = new HashMap();
    final private int n;
    private final String unk = "<UNK>";
    
    /**
     *
     * @param n The value of n
     * @param t An arraylist of training text
     * @throws IllegalArgumentException
     */
    public NgramProb(int n, ArrayList<List<String>> t) throws IllegalArgumentException{
        if(n < 2){
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.train(t);
        vertices.put(unk, new Vertex(unk));
    }
    

    /**
     * Returns the joint probability of a sequence of tokens
     * @param text A sequence of tokens
     * @return The logarithmic joint probability of the text
     */
    @Override
        public double getProb(List<String> text){
        double prob = 0;
        for(int i = n - 1; i < text.size(); i++){
            String second = text.get(i);
            String first = "";
            for(int j = i - (n - 1); j < i; j++){
                if(j == i - 1){
                    first += text.get(j);
                }else{
                    first += text.get(j) + " ";
                }
                
            }
            first = first.trim();
            second = second.trim();
            
            //System.out.println("First: " + first + " Second: " + second + " Prob: " + prob(first, second));
            //System.out.println(vertices.get(first).edges.size());
            prob += Math.log(prob(first, second));
        }
        return prob;
    } 
    
    /**
     * Determines the mostly likely word to occur after a sequence of n words
     * @param text A sequence of tokens
     * @return The most likely word to occur
     */
    public String getNext(List<String> text){
        String t = " ";
        for(int i = text.size() - (this.n - 1); i < text.size(); i++){
            if(i == text.size() - 1){
                t += text.get(i);
            }else{
                t += text.get(i) + " ";
            }
        }
        t = t.trim();
        
        if(!vertices.containsKey(t)){
            t = unk;
        }
        int counter = 0;
        String highest = " ";
        for(String edge : vertices.get(t).edges.keySet()){
            
            if(counter == 0){
                highest = edge;
            }
            if(vertices.get(t).edges.get(edge).getWeight() > vertices.get(t).edges.get(highest).getWeight()){
                highest = edge;
            }
            //System.out.println(highest);
            counter++;
        }
        //System.out.println("Token: " + t);
        //System.out.println("Highest" + highest);
        //System.out.println(vertices.get(unk).edges.size());
        return highest;
    }
    
    
    private void addVertex(String first, String second){
        
        vertices.get(first).addEdge(second);
        
    }
    
    private double prob(String first, String second){
        //TODO: fix null pointer exception
        
        double num = 1;
        double den = vertices.size();
        
        try{
            num += (double)vertices.get(first).edges.get(second).getWeight();
        }catch(NullPointerException ex){
            //ngram doesn't occur (smooth)
        }
        
        try{
            den += (double)vertices.get(first).getCount();
           
        }catch(NullPointerException ex){
            //handle unknown word
        }
       
        return  (num/den);
    }
    
    private void train(ArrayList<List<String>> listOfSentences){
        
        for(int l = 0; l < listOfSentences.size(); l++){
            List<String> sentence = listOfSentences.get(l);
            for(int i = n - 1; i < sentence.size(); i++){
                String second = sentence.get(i).toLowerCase();
                second = second.trim();
                String first = " ";

                for(int j = i - (n - 1); j < i; j++){//j = 0
                    //if j >= i - (n - 1)
                    if(j == i - 1){
                        first += sentence.get(j);
                    }else{
                        first += sentence.get(j) + " ";
                    }

                }
                first = first.trim();
                if(i >= n -1){

                    if(vertices.containsKey(first)){
                        vertices.get(first).addCount();
                    }else{
                        vertices.put(first, new Vertex(first));

                    }

                }else{

                }

                addVertex(first, second);
            
            }
        }
        
        try{
                    
//vertices.keySet().stream().forEach((t1) -> {
            //System.out.println(vertices.size());
     
  //      });
        }catch(Exception e){
            System.out.println("none");
        }
    }
    
    /**
     * Runs a test on the n-gram, this helps handle out of vocabulry words, unknown tokens, helps with smoothing, etc.
     * @param listOfSentences test data
     */
    public void test(ArrayList<List<String>> listOfSentences){
        for(int l = 0; l < listOfSentences.size(); l++){
            List<String> sentence = listOfSentences.get(l);
            for(int i = n - 1; i < sentence.size(); i++){
                String second = sentence.get(i).toLowerCase();
                second = second.trim();
                String first = " ";

                for(int j = i - (n - 1); j < i; j++){//j = 0
                    //if j >= i - (n - 1)
                    if(j == i - 1){
                        first += sentence.get(j);
                    }else{
                        first += sentence.get(j) + " ";
                    }

                }
                first = first.trim();
                if(i >= n -1){

                    if(vertices.containsKey(first)){
                        vertices.get(first).addCount();
                    }else{
                        first = unk;

                    }

                }else{

                }

                addVertex(first, second);
            
            }
        }
        //System.out.println(vertices.keySet());
    }
    
    /**
     * Returns the number of tokens in the model
     * @return token size
     */
    @Override
    public int getSize(){
        return this.vertices.size();
    }
}
