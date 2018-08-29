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
     * @param text Text to tokenize
     * @param map This map is used to pass in substrings that should be substituted. 
     * If the keys are found as substrings in the input file, they are replaced with their values before tokenization takes place. 
     * For example, <b>they'll</b> can be substituted to <b>they will</b>.<br>
     * If null is passed, it performs character tokenization.
     * @return
     */
    public ArrayList<List<String>> getTokens(String text, Map<String, String> map);

    /**
     *
     * @param file A file of text to be tokenized
     * @param map This map is used to pass in substrings that should be substituted. 
     * If the keys are found as substrings in the input file, they are replaced with their values before tokenization takes place. 
     * For example, <b>they'll</b> can be substituted to <b>they will</b>.<br>
     * If null is passed, it performs character tokenization.
     * @return Text tokens. Each element of the arraylist contains a group of tokens (this may represent sentences, etc. Each list then contains it's extracted tokens) 
     * @throws FileNotFoundException
     */
    public ArrayList<List<String>> getTokens(File file, Map<String, String> map) throws FileNotFoundException;


    
    
}
