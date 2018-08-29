
import Classifier.NaiveClassifier;
import LanguageDetection.LangDetector;
import LanguageModels.NgramProb;
import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.ITokenizer;
import POS.PosTagger;
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // 1. Test the ngram probability
        // 2. Use the ngram probability for language detection
        
        //testLangDet();
        //testNgramProb();
        //testMinEditDist();
        //testClassifier();
        //testPos();
        //testTextPredict();
      
        
       
        
        
        
        
        
        
    }

    /**
     *
     */
    public static void testPos(){
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        PosTagger tagger = new PosTagger(tokenizer.getTokens("<s> I::pronoun am::verb a::determiner boy::noun </s>"));
        List<String> tags = tagger.tag(tokenizer.getTokens("I am a boy").get(0));
        System.out.println(tags);
    }
    
    /**
     *
     */
    public static void testNgramProb(){
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        NgramProb ngram = new NgramProb(2, tokenizer.getTokens("bawo ni omo ", null));
        System.out.println(ngram.getProb(tokenizer.getTokens("doix", null).get(0)));
        System.out.println(ngram.getProb(tokenizer.getTokens("bawn", null).get(0)));
    }
    
    /**
     *
     * @throws FileNotFoundException
     */
    public static void testTextPredict() throws FileNotFoundException{
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        NgramProb ngram = new NgramProb(3, tokenizer.getTokens(new File("C:\\Users\\mayowa\\Docume"
                + "nts\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\test.txt")));
        ngram.test(tokenizer.getTokens(new File("C:\\Users\\mayowa\\Docume"
                + "nts\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\text.txt")));
        String text;
        Scanner get = new Scanner(System.in);
       while(true){
            System.out.println("Enter a sttring of words and a word will be suggested");
            text = get.nextLine();
            String p = ngram.getNext(tokenizer.getTokens(text).get(0));
            System.out.println("Predicted word: " + p);
        }
    }
    
    /**
     *
     * @throws FileNotFoundException
     */
    public static void testLangDet() throws FileNotFoundException{
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        LangDetector a = new LangDetector();
        Scanner get = new Scanner(System.in);
        a.addLanguage("English", tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\english.txt"), null));
        a.addLanguage("Japanese",  tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\Japanese-romaji.txt"), null));
        a.addLanguage("German",  tokenizer.getTokens(new File("Training Data\\Corpus\\lang detection\\german.txt"), null));
        String text;
        
        while(true){
            System.out.println("Write a sentence in either Japanese(romaji), English, or German");
            text = get.nextLine();
            System.out.println(a.getLaguage(text));
        }
        
    }
    
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void testClassifier() throws FileNotFoundException, IOException{
      EnglishTokenizer a = new EnglishTokenizer();  
      NaiveClassifier Reviews = new NaiveClassifier("author"); 
      Reviews.createClass("Positive");
      Reviews.createClass("Negative");
      File[] positive = new File("Training Data\\Corpus\\english\\movie reviews\\pos").listFiles();
      Reviews.trainClass("Positive", positive);
      File[] negative = new File("Training Data\\Corpus\\english\\movie reviews\\neg").listFiles();
      Reviews.trainClass("Negative", negative);
      
      File[] positive_test = new File("Training Data\\Corpus\\english\\movie reviews\\positive test").listFiles();
      File[] negative_test = new File("Training Data\\Corpus\\english\\movie reviews\\negative test").listFiles();
      
      System.out.println("positive");
      double count = 0;
      double correct = 0;
      for(int i = 0; i < positive_test.length; i++){
          if(Reviews.test(positive_test[i]).equals("Positive")){
              correct += 1;
          }
          count++;
      }
      
      System.out.println("Negative");
      for(int i = 0; i < negative_test.length; i++){
          if(Reviews.test(negative_test[i]).equals("Negative")){
              correct += 1;
          }
          count++;
      }
      double p = (double)((correct/count) * 100);
      System.out.println(correct + " of " + count + " %: " + p);
    }
    
    /**
     *
     * @throws IOException
     */
    public static void testWordNet() throws IOException{
        //String wnhome = System.getenv("C:\\Program Files (x86)\\WordNet\\2.1\\dict");
        String path = "C:\\Program Files (x86)\\WordNet\\2.1\\dict";
         URL url = null;
         try{ url = new URL("file", null, path); } 
         catch(MalformedURLException e){ e.printStackTrace(); }
         if(url == null) return;

        // construct the dictionary object and open it
        IDictionary dict = new Dictionary(url);
        dict.open();

        // look up first sense of the word "dog"
        IIndexWord idxWord = dict.getIndexWord("is", POS.VERB);
        IWordID wordID = idxWord.getWordIDs().get(0);
        IWord word = dict.getWord(wordID);
        System.out.println("Id = " + wordID);
        System.out.println("Lemma = " + word.getLemma());
        System.out.println("Gloss = " + word.getSynset().getGloss());
        }
    

    
}
