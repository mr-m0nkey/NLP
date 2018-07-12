package Lex.Tokenizer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
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
public interface ITokenizer {
    
    /**
     *
     * @param text
     * @return
     */
    public List<String> getTokens(String text);
    
    /**
     *
     * @param file
     * @return
     * @throws java.io.FileNotFoundException
     */
    public List<String> getTokens(File file) throws FileNotFoundException;
    
    public List<String> getTokens(String text, Map<String, String> map);

    public List<String> getTokens(File file, Map<String, String> map) throws FileNotFoundException;


    
    
}
