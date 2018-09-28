/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Default English Tokenizer
 * @author mayowa
 */
public class EnglishTokenizer extends EnglishT implements Serializable{
    
    /**
     * Extracts the tokens from a text
     * @param text Text to tokenize
     * @return Text tokens. Each element of the arraylist contains a group of tokens (this may represent sentences, etc. Each list then contains it's extracted tokens) 
     */
    @Override
    public ArrayList<List<String>> getTokens(String text) {
        List<String> temp = Collections.synchronizedList(new LinkedList<String>());
        ArrayList<List<String>> arr = new ArrayList();
        //final String EOS = " </s> <s> ";
        
        String tempText;
            
            tempText = text
                    .replaceAll("'m", " am")
                            .replaceAll("won't", "will not")
                            .replaceAll("can't", "can not")
                            .replaceAll("shan't", "shall not")
                            .replaceAll("n't", " not")
                            .replaceAll("'ll", " will")
                            .replaceAll("'s", " 's")
                            .replaceAll("'d", " would")
                            .replace("!", " ! ")
                            .replace("\\s+", " ")
                            .replace("?", " ? ")
                            .replace(".", " . ")
                            .replace(",", " , ")
                            .toLowerCase()
                            .trim();

            //TODO: Find </s>

            String[] a  = tempText.split("\\s+");
            //tokens.add("<s>");
            for (int i = 0; i < a.length; i++) {
                if(a[i].length() > 0){
                    temp.add(a[i]);
                    if(a[i].equals("</s>")){
                        arr.add(temp);
                        temp = Collections.synchronizedList(new LinkedList<String>());
                    }
                    
                }
            }

         
        if(arr.size() < 1){
                arr.add(temp);
            }
        return arr;
    }
    
    @Override
    public ArrayList<List<String>> getTokens(String text, Map<String, String> map) {
        List<String> temp = Collections.synchronizedList(new LinkedList<String>());
        //final String EOS = " </s> <s> ";
        String split = "\\s";
        if(map == null){
            map = new HashMap();
            split = "";
        }
        String tempText = text;
            
            
        for(String t : map.keySet()){
            tempText = text.replaceAll(t, map.get(t)).toLowerCase().trim();
        }

        ArrayList<List<String>> arr = new ArrayList();
        String[] a  = tempText.split(split);
        //tokens.add("<s>");
        for (int i = 0; i < a.length; i++) {
            if(a[i].length() > 0){
                temp.add(a[i]);
                if(a[i].equals("</s>")){
                        arr.add(temp);
                        temp = Collections.synchronizedList(new LinkedList<String>());
                    }
            }
        }

         
       if(arr.size() < 1){
                arr.add(temp);
            }
        return arr;
    }
    
    /**
     *
     * @param file A file of text to be tokenized
     * @return Text tokens. Each element of the arraylist contains a group of tokens (this may represent sentences, etc. Each list then contains it's extracted tokens) 
     * @throws FileNotFoundException
     */
    @Override
    public ArrayList<List<String>> getTokens(File file) throws FileNotFoundException{
        
                    List<String> temp = Collections.synchronizedList(new LinkedList<String>());
                    
                      ArrayList<List<String>> arr = new ArrayList();

        //temp.add("<s>");
        try (Scanner input = new Scanner(file)) {
            //temp.add("<s>");
            String tempString;
            int count = 0;
            input.useDelimiter("\\s+");
            while(input.hasNextLine()){
                count++;
                tempString = input.nextLine();
                

                tempString = tempString
                        .replaceAll("'m", " am")
                        .replaceAll("won't", "will not")
                        .replaceAll("can't", "can not")
                        .replaceAll("shan't", "shall not")
                        .replaceAll("n't", " not")
                        .replaceAll("'ll", " will")
                        .replaceAll("'d", " would")
                        .replace("!", " ! ")
                        .replace("\\s+", " ")
                        .replace("?", " ? ")
                        .replace(".", " . ")
                        .replace(",", " , ")
                        .toLowerCase()
                        .trim();
                
                if(tempString.length() > 0){
                    String[] a  = tempString.split("\\s+");
                    //temp.add("<s>");
                    for(int i = 0; i < a.length; i++){
                        temp.add(a[i]);
                        if(a[i].equals("</s>")){
                        arr.add(temp);
                        temp = Collections.synchronizedList(new LinkedList<String>());
                    }

                    }
                    //temp.add("</s>");
                }

            }
        }
                
            if(arr.size() < 1){
                arr.add(temp);
            }
            return arr;
    }

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
    @Override
    public ArrayList<List<String>> getTokens(File file, Map<String, String> map) throws FileNotFoundException{
        
                    List<String> temp = Collections.synchronizedList(new LinkedList<String>());
                    String split = "\\s+";
                    if(map == null){
                        map = new HashMap();
            split = "";
        }
                    
                      ArrayList<List<String>> arr = new ArrayList();

        //temp.add("<s>");
        try (Scanner input = new Scanner(file)) {
            //temp.add("<s>");
            String tempString;
            int count = 0;
            input.useDelimiter(split);
            while(input.hasNextLine()){
                count++;
                tempString = input.nextLine();
                

                for(String s : map.keySet()){
                    tempString = tempString.replaceAll(s, map.get(s)).toLowerCase().trim();
                }
                
                if(tempString.length() > 0){
                    String[] a  = tempString.split("\\s+");
                    //temp.add("<s>");
                    for(int i = 0; i < a.length; i++){
                        temp.add(a[i]);
                        if(a[i].equals("</s>")){
                        arr.add(temp);
                        temp = Collections.synchronizedList(new LinkedList<String>());
                    }

                    }
                    //temp.add("</s>");
                }

            }
        }
                
            if(arr.size() < 1){
                arr.add(temp);
            }
            return arr;
    }

    

    
}
