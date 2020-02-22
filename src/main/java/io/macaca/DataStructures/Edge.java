/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.macaca.DataStructures;

import java.io.Serializable;

/**
 * Represents a graph edge
 * @author mayowa
 */
public class Edge implements Serializable{
    
    final private Vertex u;
    final private Vertex v;
    int count = 1;
    float prob;
    
    Edge(Vertex u, Vertex v){
        this.u = u;
        this.v = v;
    }
    
    void increaseWeight(){
        count++;
    }
    
    /**
     * Returns the weight of the edge as an integer
     * @return The weight of the edge
     */
    public int getWeight(){
        return count;
    }
    
}