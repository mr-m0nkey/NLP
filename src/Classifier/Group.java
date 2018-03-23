/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classifier;

import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.ITokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mayowa
 */
public class Group {
    
    private final Map<String, Class> classes;
    private String name;
    private final ITokenizer tokenizer;
    private int no_of_documents = 0;
    
    public Group(String name){
        this.classes = new HashMap();
        this.name = name;
        this.tokenizer = new EnglishTokenizer();
    }
    
    public Group(String name, ITokenizer tokenizer){
        this.classes = new HashMap();
        this.name = name;
        this.tokenizer = tokenizer;
    }
    
    public void createClass(String name){
        classes.put(name, new Class(name, tokenizer));
        
    }
    
    public void trainClass(String name, File[] files) throws FileNotFoundException{
        classes.get(name).train(files);
        no_of_documents += files.length;
        classes.get(name).updateTotal(no_of_documents);
    }
    
    public void trainClass(String name, String text){
        classes.get(name).train(text);
        no_of_documents++;
        classes.get(name).updateTotal(no_of_documents);
    }
    
    public double test(File file) throws FileNotFoundException{
        double prob = 0;
        String highest = "";
        double p = 0;
        int count = 0;
        for(String cl : classes.keySet()){
            if(count == 0){
                count++;
                p = classes.get(cl).getProb(file);
                highest = cl + " " + p;
            }
            if(classes.get(cl).getProb(file) > p){
                p = classes.get(cl).getProb(file);
                highest = cl + " " + p;
            }else if(classes.get(cl).getProb(file) < p){
                
            }else{
                
            }
        }
        System.out.println(highest);
        return prob;
    }
    
    public double test(String text){
        double prob = 0;
        for(String cl : classes.keySet()){
            System.out.println(cl + ": " + classes.get(cl).getProb(text));
        }
        return prob;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void rename(String new_name){
        this.name = new_name;
    }
    
}
