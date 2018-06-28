/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageModels;

import DataStructures.Vertex;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 *
 * @author mayowa
 */
public class NgramProb implements INgram {
    
    private Map<String, Vertex> vertices = new HashMap();
    final private int n;
    private List<String> tokens;
    private final String unk = "<UNK>";
    
    /**
     *
     * @param n
     * @param t
     * @throws IllegalArgumentException
     */
    public NgramProb(int n, List<String> t) throws IllegalArgumentException{
        if(n < 2){
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.tokens = t;
        this.build();
        //vertices.put(unk, new Vertex(unk));
    }
    
    //public methods

    /**
     *
     * @param text
     * @return
     */
        public float getProb(List<String> text){
        float prob = 1;
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
            prob += prob(first, second);
        }
        return prob;
    } 
    
    /**
     *
     * @param text
     * @param n
     * @return
     */
    public String getNext(List<String> text, int n){
        String t = " ";
        for(int i = text.size() - (this.n - 1); i < text.size(); i++){
            if(i == text.size() - 1){
                t += text.get(i);
            }else{
                t += text.get(i) + " ";
            }
        }
        
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
            counter++;
        }
        //System.out.println("Token: " + t);
        //System.out.println("Highest" + highest);
        //System.out.println(vertices.get(unk).edges.size());
        return highest;
    }
    
    
    //private methods
    private void addVertex(String first, String second){
        
        vertices.get(first).addEdge(second);
        
    }
    
    private float prob(String first, String second){
        //TODO: fix null pointer exception
        
        float num = 1;
        float den = vertices.size();
        
        try{
            num += (float)vertices.get(first).edges.get(second).getWeight();
        }catch(NullPointerException ex){
            //System.out.println("SECOND" + second + "SECOND");
        }
        
        try{
            den += (float)vertices.get(first).getCount();
           
        }catch(NullPointerException ex){
              //          System.out.println("FIRST" + first + "FIRST");

        }
        //System.out.println("Num: " + num + " Den: " + den);
        /*
        if(!vertices.containsKey(first)){
            //first = unk;
            vertices.get(unk).addCount();
            
            //return 0;
        }
        
        
        if(vertices.get(first).edges.keySet().contains(second)){
            
        }else{
            if(first.equals(unk)){
                //vertices.get(first).addEdge(second);
            }else{
                //second = unk;
                //vertices.get(first).addEdge(unk);
            }
            
        }*/
        
        
        
        
        
        
        return num;
        //return  (num/den);
    }
    
    private void build(){
        
        
        for(int i = n - 1; i < tokens.size(); i++){
            String second = tokens.get(i).toLowerCase();
            second = second.trim();
            String first = " ";
            
            for(int j = i - (n - 1); j < i; j++){//j = 0
                //if j >= i - (n - 1)
                if(j == i - 1){
                    first += tokens.get(j);
                }else{
                    first += tokens.get(j) + " ";
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
        try{
                    
//vertices.keySet().stream().forEach((t1) -> {
            System.out.println(vertices.size());
     
  //      });
        }catch(Exception e){
            System.out.println("none");
        }
    }
    
    
    //overriden methods
    /*@Override
    public String toString(){
        String output = new String();
        //TODO: Implement
        
        
        return output;
    }*/
}
