/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lex.English.Tokenizers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mayowa
 */
public class EnglishTokenizer extends EnglishT{
    
  


  
    public EnglishTokenizer(){
        
    }

    
    @Override
    public List<String> getTokens(String text) {
        List<String> temp = Collections.synchronizedList(new LinkedList<String>());
        //final String EOS = " </s> <s> ";
        
        String tempText;
            
            tempText = text
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

            //TODO: Find </s>

            String[] a  = tempText.split("\\s+");
            //tokens.add("<s>");
            for (int i = 0; i < a.length; i++) {
                if(a[i].length() > 0){
                    temp.add(a[i]);
                }
            }

         
          

     
        
        
        return temp;
    }
    
    
    @Override
    public List<String> getTokens(File file) throws FileNotFoundException{
        
                    List<String> temp = Collections.synchronizedList(new LinkedList<String>());
                    
      
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

                    }
                    //temp.add("</s>");
                }

            }
        }
                
            
            return temp;
    }


    

    
}
