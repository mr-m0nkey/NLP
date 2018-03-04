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
class Vertex {
    
    private String token;
    private int count = 1;
    
    Vertex(String t){
        this.token = t;
    }
    
    Map<String, Edge> edges = new HashMap();
    
    public void addEdge(Vertex v){
        if(edges.containsKey(v.token)){
            edges.get(v.token).increaseWeight();
        }else{
            edges.put(v.token, new Edge(this, v));
        }
    }
    
    public void addCount(){
        count++;
    }
    
    public int getCount(){
        return count;
    }
    
    @Override
    public String toString(){
        return "Word: " + this.token;             
    }
    
}
