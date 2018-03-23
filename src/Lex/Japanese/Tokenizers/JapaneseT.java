/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.Japanese.Tokenizers;

import Lex.Tokenizer.ITokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author mayowa
 */
public abstract class JapaneseT implements ITokenizer{
    
    /**
     *
     * @return
     */
    @Override
    public abstract  List<String> getTokens(String text);
    
    
    @Override
    public abstract  List<String> getTokens(File file) throws FileNotFoundException;

}