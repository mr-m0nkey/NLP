package Lex.Tokenizer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    public ArrayList<List<String>> getTokens(String text);
    
    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<List<String>> getTokens(File file) throws FileNotFoundException;
    
    /**
     *
     * @param text
     * @param map
     * @return
     */
    public ArrayList<List<String>> getTokens(String text, Map<String, String> map);

    /**
     *
     * @param file
     * @param map
     * @return
     * @throws FileNotFoundException
     */
    public ArrayList<List<String>> getTokens(File file, Map<String, String> map) throws FileNotFoundException;


    
    
}
