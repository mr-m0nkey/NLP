/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LanguageDetection;

import LanguageModels.ILanguageModel;
import LanguageModels.NgramProb;
import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.ITokenizer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for language detection
 * @author mayowa
 */
public class LangDetector implements LanguageDetection, Serializable{
    //TODO: use internal tokenizers
    
    private Map<String, ILanguageModel> languageModels = new HashMap();
    ITokenizer tokenizer;

    /**
     * Default constructor
     */
    public LangDetector(){
        tokenizer = new EnglishTokenizer();
    }
    
    /**
     * Adds a language to the list of detectable languages
     * @param name The name of the language
     * @param text An arraylist of sentences in the language, this can be gotten by passing the language data through a tokenizer
     */
    public void addLanguage(String name, ArrayList<List<String>> text){
        languageModels.put(name, new NgramProb(2, text));
    }
    
    
    
    
    /**
     * Determines the language of an input text
     * @param text text in unknown language
     * @return language of input text
     */
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
            double prob = languageModels.get(lang).getProb(characters) + Math.log((double)languageModels.get(lang).getSize()/total);
            if(prob > biggerProb){
                language = lang;
                biggerProb = prob;
            }
        }
        return language;
    }
    
    
    
}
