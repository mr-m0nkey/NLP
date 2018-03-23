/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class Vertex {
    
    private String token;
    private int count = 1;
    
    /**
     *
     * @param t
     */
    public Vertex(String t){
        this.token = t;
        if(t.equals("<UNK>")){
            this.count = 0;
        }
    }
    
    /**
     *
     */
    public Map<String, Edge> edges = new HashMap();
    
    /**
     *
     * @param s
     */
    public void addEdge(String s){
        if(edges.containsKey(s)){
            edges.get(s).increaseWeight();
        }else{
            edges.put(s, new Edge(this, new Vertex(s)));
        }
    }
    
    /**
     *
     */
    public void addCount(){
        count++;
    }
    
    /**
     *
     * @return
     */
    public int getCount(){
        return count;
    }
    
    @Override
    public String toString(){
        return "Word: " + this.token;             
    }
    
}
