/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageModels;

import java.util.List;

/**
 * Interface all language model classes implement
 * @author mayowa
 */
public interface ILanguageModel {
    
    /**
     * Returns the number of tokens in the model
     * @return token size
     */
    public int getSize();
    
    /**
     * Returns the joint probability of a sequence of tokens
     * @param text A sequence of tokens
     * @return The logarithmic joint probability of the text
     */
    public double getProb(List<String> text);
    
}
