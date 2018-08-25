/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageModels;

import java.util.List;

/**
 *
 * @author mayowa
 */
public interface INgram {
    
    /**
     *
     * @return
     */
    public int getSize();
    
    /**
     *
     * @param text
     * @param train
     * @return
     */
    public double getProb(List<String> text, boolean train);
    
}
