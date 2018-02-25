/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.Japanese.Tokenizers;

import Lex.Tokenizer.Token;
import Lex.Tokenizer.ITokenizer;
import java.util.ArrayList;
import java.util.Map;

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
    public abstract  ArrayList<Token> getTokens();

    /**
     *
     * @param map
     * @return
     */
    @Override
    public abstract ArrayList<Token> getTokens(Map<String, String> map);

    /**
     *
     * @return
     */
    @Override
    public abstract String getCorpus();
}