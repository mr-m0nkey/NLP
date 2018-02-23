/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Stemmers;

import Lex.Tokenizer.IStemmer;

/**
 *
 * @author mayowa
 */
public class PortersStemmer implements IStemmer{
    
    //singleton class
    private PortersStemmer(){
        
    }
    
    @Override
    public String stem(String word){
        String stem = "";
        return stem;
    }
    
}
