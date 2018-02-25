/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Lex.Tokenizer.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayowa
 */
public class NgramGraph {
    
    private ArrayList<Vertex> vertices = new ArrayList();
    final private int n;
    private List<Token> tokens;
    
    public NgramGraph(int n, List<Token> t) throws IllegalArgumentException{
        if(n < 2){
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.tokens = t;
        this.build();
    }
    
    //public methods
    public float getProb(Token first, Token second){
        float prob = 0;
        
        return prob;
    }
    
    
    //private methods
    private boolean AddVertex(Token t){
        if(vertices.contains(t)){
            
            return true;
        }else{
            Vertex v = new Vertex(t); 
            vertices.stream().forEach((vertex) -> {
                vertex.addEdge(v);
            });
            vertices.add(v);
            return false;
        }
    }
    
    private void build(){
        
    }
    
    
    //overriden methods
    @Override
    public String toString(){
        String output = new String();
        //TODO: Implement
        
        
        return output;
    }
}
