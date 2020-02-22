package io.macaca;

import io.macaca.LanguageDetection.LangDetector;
import io.macaca.LanguageModels.NgramProb;
import io.macaca.Lex.English.Tokenizers.EnglishTokenizer;
import io.macaca.Lex.Tokenizer.ITokenizer;
import io.macaca.POS.PosTagger;
import io.macaca.POS.WordTag;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayowa
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
       langDet();
    }

    public static void langDet() throws FileNotFoundException{
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        LangDetector a = new LangDetector();
        Scanner get = new Scanner(System.in);
        a.addLanguage("English", tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\english.txt"), null), tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\english-train.txt"), null));
        //a.addLanguage("Japanese",  tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\Japanese-romaji.txt"), null), tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\japanese-romaji.txt"), null));
        a.addLanguage("German",  tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\german.txt"), null), tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\german-train.txt"), null));
        String text;

        while(true){
            System.out.println("Write a sentence in either English, or German");
            text = get.nextLine();
            System.out.println(a.getLaguage(text));
        }

    }

    public static void textPredict() throws FileNotFoundException{


        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        Map<String, String> map = new HashMap();
        map.put(".", " ");
        map.put(",", " ");
        map.put("!", " ");
        File file = new File("C:\\Users\\mayowa\\Documents\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\test.txt");
        NgramProb ngram = new NgramProb(2, tokenizer.getTokens(file));
        ngram.test(tokenizer.getTokens(new File("C:\\Users\\mayowa\\Documents\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\text.txt")));
        String text;
        Scanner get = new Scanner(System.in);
        while(true){
             System.out.println("Enter a string of words and a word will be suggested");
             text = get.nextLine();
             String p = ngram.getNext(tokenizer.getTokens(text).get(0));
             System.out.println("Predicted word: " + p);
         }
    }

    public static void pos() throws FileNotFoundException{
        String text = "I am not going there";
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        PosTagger tagger = new PosTagger(tokenizer.getTokens(new File("C:\\Users\\mayowa\\Documents\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\pos.txt")));
        List<WordTag> tags = tagger.tag(tokenizer.getTokens(text).get(0));
        System.out.println(text);
        System.out.println(tags);
    }
}
