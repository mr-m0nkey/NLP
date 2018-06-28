/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.Tokenizer;

/**
 *
 * @author mayowa
 */
public class Token {
    
    /**
     *
     */
    private final String word_form;
    
    /**
     *
     * @param word
     */
    public Token(String word){
        word_form = word;
    }
    
    @Override
    public String toString(){
        return this.word_form;
    }
    
}
