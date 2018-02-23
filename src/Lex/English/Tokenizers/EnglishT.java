/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

import Lex.Tokenizer.Token;
import Lex.Tokenizer.ITokenizer;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public abstract class EnglishT implements ITokenizer{

    /**
     *
     * @return
     */
    @Override
    public abstract  List<Token> getTokens();

    /**
     *
     * @param map
     * @return
     */
    @Override
    public abstract List<Token> getTokens(Map<String, String> map);

    /**
     *
     * @return
     */
    @Override
    public abstract String getCorpus();
    
}
