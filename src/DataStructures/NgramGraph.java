/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

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
    public float getProb(String second, String first){
        //TODO: fix null pointer exception
        float prob = 0;
        prob = (float)(vertices.get(second).edges.get(first).count/vertices.get(second).getCount());
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
            vertices.get(t).addEdge(pre);
            vertices.get(t).addCount();
        }else{
            vertices.put(t, new Vertex(t));
            vertices.get(t).addEdge(pre);
        }
    }
    
    private void build(){
        
        for(int i = 0; i < tokens.size(); i++){
            if(i >= n -1){
                addVertex(tokens.get(i - 1), tokens.get(i));
            }else{
                addVertex(null, tokens.get(i));
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
