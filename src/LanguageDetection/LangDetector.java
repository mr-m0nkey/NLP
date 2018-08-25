/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageDetection;

import LanguageModels.INgram;
import LanguageModels.NgramProb;
import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.ITokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class LangDetector {
    
    private Map<String, INgram> languageModels = new HashMap();
    ITokenizer tokenizer;

    public LangDetector(){
        tokenizer = new EnglishTokenizer();
    }
    
    public void addLanguage(String name, ArrayList<List<String>> text){
        languageModels.put(name, new NgramProb(2, text));
    }
    
    
    public String getLaguage(String text){
        int total = 0;
        for(String lang : languageModels.keySet()){
            total += languageModels.get(lang).getSize();
        }
        String language = "";
        double biggerProb = -10000;
        List<String> characters = tokenizer.getTokens(text, null).get(0);
        for(String lang : languageModels.keySet()){
            //System.out.println(lang + " " + (languageModels.get(lang).getProb(characters, false) + Math.log((double)languageModels.get(lang).getSize()/total)));
            double prob = languageModels.get(lang).getProb(characters, false) + Math.log((double)languageModels.get(lang).getSize()/total);
            if(prob > biggerProb){
                language = lang;
                biggerProb = prob;
            }
        }
        return language;
    }
    
    
    
}
