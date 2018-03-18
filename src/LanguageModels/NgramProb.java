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
public class NgramProb {
    
    Map<String, Vertex> vertices = new HashMap();
    final private int n;
    private List<String> tokens;
    private final String unk = "<UNK>";
    
    public NgramProb(int n, List<String> t) throws IllegalArgumentException{
        if(n < 2){
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.tokens = t;
        this.build();
        vertices.put(unk, new Vertex(unk));
    }
    
    //public methods
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
            
            
            System.out.println("First: " + first + " Second: " + second + " Prob: " + prob(first, second));
            prob *= prob(first, second);
        }

        return prob;
    } 
    
    
    public String getNext(List<String> text, int n){
        String t = "";
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
        String highest = "";
        for(String edge : vertices.get(t).edges.keySet()){
            
            if(counter == 0){
                highest = edge;
            }
            if(vertices.get(t).edges.get(edge).getWeight() > vertices.get(t).edges.get(highest).getWeight()){
                highest = edge;
            }
            counter++;
        }
        
        return highest;
    }
    
    
    //private methods
    private void addVertex(String first, String second){
        
        vertices.get(first).addEdge(second);
        
    }
    
    private float prob(String first, String second){
        //TODO: fix null pointer exception
        
        float num;
        float den;
        
        if(!vertices.containsKey(first)){
            first = unk;
            vertices.get(unk).addCount();
        }
        
        den = (float)vertices.get(first).getCount();
        
        try{
            num = (float)vertices.get(first).edges.get(second).getWeight();
        }catch(NullPointerException ex){
            second = unk;
            vertices.get(first).addEdge(unk);
            num = (float)vertices.get(first).edges.get(second).getWeight();
        }
        
        
        
        
        
        
        return num/den;
    }
    
    private void build(){
        
        
        for(int i = n - 1; i < tokens.size(); i++){
            String second = tokens.get(i);
            String first = "";
            for(int j = i - (n - 1); j < i; j++){
                if(j == i - 1){
                    first += tokens.get(j);
                }else{
                    first += tokens.get(j) + " ";
                }
                
            }
            if(i >= n -1){
                
                if(vertices.containsKey(first)){
                    vertices.get(first).addCount();
                }else{
                    vertices.put(first, new Vertex(second));
                    
                }
                
            }else{
                
            }
           
            addVertex(first, second);
            
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
