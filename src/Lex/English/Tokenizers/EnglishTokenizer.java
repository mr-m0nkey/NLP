/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

import Lex.Tokenizer.Token;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class EnglishTokenizer extends EnglishT{
    
    private final String text;
    ArrayList<Token> tokens = new ArrayList();


    public EnglishTokenizer(String text){
        this.text = text;
    }
    
    public EnglishTokenizer(File f){
        String tempText = "";
        //get text from file and put it in this.text
        this.text = tempText;
    }
    
    @Override
    public ArrayList<Token> getTokens() {
        String tempText;
        tempText = this.text
                .replaceAll("'m", " am")
                .replaceAll("won't", "will not")
                .replaceAll("can't", "can not")
                .replaceAll("shan't", "shall not")
                .replaceAll("n't", " not");
        String[] a  = tempText.split(" ");
        for (String a1 : a) {
            tokens.add(new Token(a1));
        }
        ArrayList<Token> temp = new ArrayList<>();
        temp.addAll(tokens);
        return temp;
    }
    
    
    @Override
    public ArrayList<Token> getTokens(Map<String, String> map) {
        String tempText = this.text;
        for(String s : map.keySet()){
            tempText = tempText.replace(s, map.get(s));
        }
        
        String[] a  = tempText.split(" ");
        for (String a1 : a) {
            tokens.add(new Token(a1));
        }
        ArrayList<Token> temp = new ArrayList<>();
        temp.addAll(tokens);
        return temp;
    }

    @Override
    public String getCorpus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    //private methods
    private String textFromFile(File f){
        String tempText = "";
        
        return tempText;
    }
    
}
