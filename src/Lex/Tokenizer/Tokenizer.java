package Lex.Tokenizer;


import java.util.ArrayList;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayowa
 */
public interface Tokenizer {
    
    public ArrayList<Token> getTokens();
    public ArrayList<Token> getTokens(Map<String, String> map);
    
    public String getCorpus();
    
    
}
