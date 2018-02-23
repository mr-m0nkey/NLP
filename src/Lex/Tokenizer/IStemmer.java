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
public interface IStemmer {

    /**
     *
     * @param word
     * @return
     */
    public String stem(String word);
}
