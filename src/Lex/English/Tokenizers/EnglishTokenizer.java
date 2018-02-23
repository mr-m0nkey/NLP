/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

import Lex.Tokenizer.Token;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class EnglishTokenizer extends EnglishT{
    
    private final String text;
    List<Token> tokens = new ArrayList();


    public EnglishTokenizer(String text){
        this.text = text;
    }
    
    public EnglishTokenizer(File f){
        String tempText = "";
        //get text from file and put it in this.text
        this.text = tempText;
    }
    
    @Override
    public List<Token> getTokens() {
        String tempText;
        final String EOS = "<E-O-S> <B-O-S>";
        tempText = this.text
                .replaceAll("'m", " am")
                .replaceAll("won't", "will not")
                .replaceAll("can't", "can not")
                .replaceAll("shan't", "shall not")
                .replaceAll("n't", " not")
                .replaceAll("'ll", " will")
                .replaceAll("'d", " would")
                .replace("!", " <E-O-S>")
                .replace("\n", " ")
                .replace("/?", " <E-O-S>");
        
        //TODO: Find <E-O-S>
        
        String[] a  = tempText.split(" ");
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > 0){
                tokens.add(new Token(a[i]));
            }
        }
        List<Token> temp = Collections.synchronizedList(new LinkedList<Token>());
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
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > 0 && !a[i].equals(null)){
                tokens.add(new Token(a[i]));
            }
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
