/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayowa
 */
public class EnglishTokenizer extends EnglishT{
    
    private final String text;
    private final File file;
    private final boolean mode;
    List<String> tokens = new ArrayList();


    public EnglishTokenizer(String text){
        this.mode = true;
        this.text = text;
        file = new File("");
    }
    
    public EnglishTokenizer(File f){
        mode = false;
        this.text = "";
        this.file = f;
    }
    
    @Override
    public List<String> getTokens() {
        List<String> temp = Collections.synchronizedList(new LinkedList<String>());
        final String EOS = " </s> <s> ";
        if(mode == true){
            String tempText;
            
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

            String[] a  = tempText.split("\\s+");
            tokens.add("<s>");
            for (int i = 0; i < a.length; i++) {
                if(a[i].length() > 0){
                    tokens.add(a[i]);
                }
            }

            if(tokens.get(tokens.size() - 1).equals("<s>")){
                tokens.remove(tokens.size() - 1);
            }
            //tokens.add("</s>");
            temp.addAll(tokens);

        }else{
            try {
                Scanner input = new Scanner(this.file);
                temp.add("<s>");
                while(input.hasNext()){
                    String tempString = input.next();
                    tempString
                            .replaceAll("'m", " am")
                            .replaceAll("won't", "will not")
                            .replaceAll("can't", "can not")
                            .replaceAll("shan't", "shall not")
                            .replaceAll("n't", " not")
                            .replaceAll("'ll", " will")
                            .replaceAll("'d", " would")
                            .replace("!", EOS)
                            .replace("\n", " ")
                            .replace("?", EOS)
                            .replace("\\W", " ")
                            .trim();
                    if(tempString.length() > 0){
                        temp.add(tempString);
                    }
                    
                }
                input.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EnglishTokenizer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
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
