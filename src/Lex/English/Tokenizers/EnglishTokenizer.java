/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

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
    List<String> tokens = new ArrayList();


    public EnglishTokenizer(String text){
        this.text = text;
    }
    
    public EnglishTokenizer(File f){
        String tempText = "";
        //get text from file and put it in this.text
        this.text = tempText;
    }
    
    @Override
    public List<String> getTokens() {
        String tempText;
        final String EOS = " </s> <s> ";
        tempText = this.text
                .replaceAll("'m", " am")
                .replaceAll("won't", "will not")
                .replaceAll("can't", "can not")
                .replaceAll("shan't", "shall not")
                .replaceAll("n't", " not")
                .replaceAll("'ll", " will")
                .replaceAll("'d", " would")
                .replace("!", EOS)
                .replace("\n", " ")
                .replace("?", EOS);
        
        //TODO: Find </s>
        
        String[] a  = tempText.split(" ");
        tokens.add("<s>");
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > 0){
                tokens.add(a[i]);
            }
        }
        
        if(tokens.get(tokens.size() - 1).equals("<s>")){
            tokens.remove(tokens.size() - 1);
        }
        List<String> temp = Collections.synchronizedList(new LinkedList<String>());
        temp.addAll(tokens);
        return temp;
    }
    
    
    @Override
    public ArrayList<String> getTokens(Map<String, String> map) {
        String tempText = this.text;
        for(String s : map.keySet()){
            tempText = tempText.replace(s, map.get(s));
        }
        
        String[] a  = tempText.split(" ");
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > 0 && !a[i].equals(null)){
                tokens.add(a[i]);
            }
        }
        ArrayList<String> temp = new ArrayList<>();
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
