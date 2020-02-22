/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.macaca.DataStructures;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a graph vertex
 * @author mayowa
 */
public class Vertex implements Serializable{
    
    private String token;
    private int count = 1;
    
    /**
     * Creates a vertex object
     * @param t The token to be stored in the vertex
     */
    public Vertex(String t){
        this.token = t;
        if(t.equals("<UNK>")){
            this.count = 0;
        }
    }
    
    /**
     *The edges linked to the vertex
     */
    public Map<String, Edge> edges = new HashMap();
    
    /**
     * Connects the vertex to another vertex. If the other vertex doesn't exist, a new vertex is creates 
     * @param s The string stored in the vertex at the other end of the edge
     */
    public void addEdge(String s){
        if(edges.containsKey(s)){
            edges.get(s).increaseWeight();
        }else{
            edges.put(s, new Edge(this, new Vertex(s)));
        }
    }
    
    /**
     * Increases the value of the vertex by 1
     */
    public void addCount(){
        count++;
    }
    
    /**
     * Returns the value of the vertex
     * @return The value of the vertex
     */
    public int getCount(){
        return count;
    }
    
    @Override
    public String toString(){
        return "Word: " + this.token;             
    }
    
}
