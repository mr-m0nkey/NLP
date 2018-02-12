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
    
    public final String word_form;
    public final String lemma;
    
    public Token(String word){
        word_form = word;
        lemma = TokenHelper.getLemma(word);
    }
    
}
