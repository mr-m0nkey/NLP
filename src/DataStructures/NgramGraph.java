/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Lex.English.Tokenizers.EnglishTokenizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class NgramGraph {
    
    //private ArrayList<Vertex> vertices = new ArrayList();
    Map<String, Vertex> vertices = new HashMap();
    final private int n;
    private List<String> tokens;
    
    public NgramGraph(int n, List<String> t) throws IllegalArgumentException{
        if(n < 2){
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.tokens = t;
        this.build();
    }
    
    //public methods
    public float getProb(String sentence){
        float prob = 0;
        EnglishTokenizer a = new EnglishTokenizer(sentence);
        List<String> t = a.getTokens();
        for(int i = n - 1; i < t.size(); i++){
            String second = t.get(i);
            String first = "";
            for(int j = i - (n - 1); j < i; j++){
                if(j == i - 1){
                    first += t.get(j);
                }else{
                    first += t.get(j) + " ";
                }
                
            }
            
            System.out.println("First:" + first + " Second:" + second + " Prob:" + prob(second, first));
        }
        return prob;
    } 
    
    
    //private methods
    private void addVertex(String bt, String t){
       
        Vertex pre = null;
        if(vertices.containsKey(bt)){
            pre = vertices.get(bt);
        }else{
            pre = new Vertex(bt);
        }
        
        if(vertices.containsKey(t)){
            if(bt != null){
                vertices.get(t).addEdge(pre);
            }
            
            vertices.get(t).addCount();
        }else{
            vertices.put(t, new Vertex(t));
            if(bt != null){
                vertices.get(t).addEdge(pre);
            }
        }
    }
    
    private float prob(String second, String first){
        //TODO: fix null pointer exception
        
        float num;
        float den;
        
        try{
            num = (float)vertices.get(second).edges.get(first).getWeight();
        }catch(NullPointerException ex){
            num = 1;
        }
        
        try{
            den = (float)vertices.get(first).getCount();
        }catch(NullPointerException ex){
            vertices.put(first, new Vertex(first));
            den = (float)vertices.get(first).getCount();
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
                addVertex(first, second);
                if(vertices.containsKey(first)){
                    vertices.get(first).addCount();
                }else{
                    vertices.put(first, new Vertex(first));
                }
                
            }else{
                addVertex(null, second);
            }
            
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
