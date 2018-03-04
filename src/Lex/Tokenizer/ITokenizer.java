package Lex.Tokenizer;


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
    
    public List<String> getTokens();
    public List<String> getTokens(Map<String, String> map);
    
    public String getCorpus();
    
    
}
