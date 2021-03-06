/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classifier;

import Lex.Tokenizer.ITokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a group of documents for classification, documents in the same class have similar content
 * @author mayowa
 */
public class Class implements Serializable{
    
    String name;
    int no_of_documents = 0;
    int total_no_of_documents = 0;
    final ITokenizer tokenizer;
    int no_of_words = 0;
    private final Map<String, Integer> words;
    
    /**
     * Creates a class of documents
     * @param name The name of this class
     * @param tokenizer A tokenizer object
     */
    public Class(String name, ITokenizer tokenizer){
        this.words = new HashMap();
        this.name = name;
        this.tokenizer = tokenizer;
    }
    
    /**
     * This method accepts an array of files and trains the class with the files given. It is used to store necessary features received from the documents
     * @param files An array of documents that belong to this class
     * @throws FileNotFoundException
     */
    public void train(File[] files) throws FileNotFoundException{
        no_of_documents += files.length;
        List<String> tokens = Collections.synchronizedList(new LinkedList<String>());
        for (File file : files) {
            tokens.addAll(tokenizer.getTokens(file).get(0));
            tokens.stream().forEach((token) -> {
                if(words.containsKey(token)){
                    words.put(token, words.get(token) + 1);
                    no_of_words++;
                }else{
                    words.put(token, 1);
                    no_of_words++;
                }
            });
        }
    }
    
    /**
     * This method accepts an array of files and trains the class with the string given. It is used to store necessary features received from the documents
     * @param text A string belonging to a particular class
     */
    public void train(String text){
        no_of_documents++;
        List<String> tokens = Collections.synchronizedList(new LinkedList<String>());
        tokens.addAll(tokenizer.getTokens(text).get(0));
        tokens.stream().forEach((token) -> {
            if(words.containsKey(token)){
                words.put(token, words.get(token) + 1);
                no_of_words++;
            }else{
                words.put(token, 1);
                no_of_words++;
            }
        });
    }
    
    /**
     * Gets the probability of a string belonging to this class
     * @param text The string to test
     * @return The logarithmic probability of the string belonging to the class
     */
    public double getProb(String text){
        List<String> tokens = Collections.synchronizedList(new LinkedList<String>());
        tokens.addAll(tokenizer.getTokens(text).get(0));
        return (double)(getProb(tokens) + Math.log(getPrior()));
    }
    
    /**
     * Gets the probability of a file belonging to this class
     * @param file The file to test
     * @return The logarithmic probability of the file belonging to the class
     * @throws FileNotFoundException
     */
    public double getProb(File file) throws FileNotFoundException{
        List<String> tokens = Collections.synchronizedList(new LinkedList<String>());
        tokens.addAll(tokenizer.getTokens(file).get(0));
        return (double)(getProb(tokens) + Math.log(getPrior()));
    }
    
    private double getProb(List<String> tokens){
        double prob = 1;
        Map<String, Double> words_probabilities = new HashMap();
        for(String token : tokens){
            double den;
            int count_w_c = 1;
            if(words.containsKey(token)){
                count_w_c += words.get(token);
            }
            den = words.size() + no_of_words;
            words_probabilities.put(token, count_w_c/den);
            prob += Math.log(count_w_c/den);
        }
        return prob;
    }
    
    void updateTotal(int new_total){
        total_no_of_documents = new_total;
    }
    
    private double getPrior(){
        return (double)no_of_documents/total_no_of_documents;
    }
    
    /**
     *
     * @return Returns the name given to this class
     */
    public String getName(){
        return this.name;
    }
    
    
}
