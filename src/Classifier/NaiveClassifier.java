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
 * This class represents a naive bayes text classifier, it stores data on the various classes and can determine the class of a new document.
 * @author mayowa
 */
public class NaiveClassifier {
    
    private final Map<String, Class> classes;
    private String name;
    private final ITokenizer tokenizer;
    private int no_of_documents = 0;
    
    /**
     * Creates a new classifier object, this constructor uses EnglishTokenizer as the default tokenizer
     * @param name The name of this classifier, the user may give it any name
     */
    public NaiveClassifier(String name){
        this.classes = new HashMap();
        this.name = name;
        this.tokenizer = new EnglishTokenizer();
    }
    
    /**
     * Creates a new classifier object
     * @param name The name of this classifier, the user may give it any name
     * @param tokenizer The tokenizer to use
     */
    public NaiveClassifier(String name, ITokenizer tokenizer){
        this.classes = new HashMap();
        this.name = name;
        this.tokenizer = tokenizer;
    }
    
    /**
     * Adds a class to the classifier
     * @param name The name of the class to add
     */
    public void createClass(String name){
        classes.put(name, new Class(name, tokenizer));
        
    }
    
    /**
     * Adds documents to a class
     * @param name The name of the class the documents belong to. The class must have been previously added with createClass()
     * @param files An array of documents to add
     * @throws FileNotFoundException
     * @throws NullPointerException
     */
    public void trainClass(String name, File[] files) throws FileNotFoundException, NullPointerException{
        classes.get(name).train(files);
        no_of_documents += files.length;
        classes.get(name).updateTotal(no_of_documents);
    }
    
    /**
     * Adds a string to a class
     * @param name name The name of the class the documents belong to. The class must have been previously added with createClass()
     * @param text The string to add
     */
    public void trainClass(String name, String text){
        classes.get(name).train(text);
        no_of_documents++;
        classes.get(name).updateTotal(no_of_documents);
    }
    
    /**
     * Determines the class of a file
     * @param file A file to test
     * @return The name of the class the file belongs to
     * @throws FileNotFoundException
     */
    public String test(File file) throws FileNotFoundException{
        //double prob = 0;
        String highest = "";
        double p = 0;
        int count = 0;
        for(String cl : classes.keySet()){
            if(count == 0){
                count++;
                p = classes.get(cl).getProb(file);
                highest = cl;
            }
            if(classes.get(cl).getProb(file) > p){
                p = classes.get(cl).getProb(file);
                highest = cl;
            }else if(classes.get(cl).getProb(file) < p){
                
            }else{
                
            }
        }
        System.out.println(highest);
        return highest;
    }
    
    /**
     * Determines the class of a file
     * @param text A string to test
     * @return The name of the class the file belongs to
     */
    public double test(String text){
        double prob = 0;
        classes.keySet().stream().forEach((cl) -> {
            System.out.println(cl + ": " + classes.get(cl).getProb(text));
        });
        return prob;
    }
    
    /**
     * Returns the name of the classifier
     * @return The name of the classifier
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Renames the classifier
     * @param new_name The new name of the classifier
     */
    public void rename(String new_name){
        this.name = new_name;
    }
    
    
    
}
