/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Lex.Tokenizer.Token;
import java.util.ArrayList;

/**
 *
 * @author mayowa
 */
class Vertex {
    
    Token token;
    
    Vertex(Token t){
        this.token = t;
    }
    
    private ArrayList<Edge> edges = new ArrayList();
    
    public void addEdge(Vertex v){
        edges.add(new Edge(this, v));
    }
    
}
