
import Classifier.NaiveClassifier;
import HelperClasses.TokenHelper;
import LanguageDetection.LangDetector;
import LanguageModels.NgramProb;
import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.ITokenizer;
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
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 1. Test the ngram probability
        // 2. Use the ngram probability for language detection
        
        testLangDet();
        //testNgramProb();
        //testMinEditDist();
        
      
        
       
        
        
        
        
        
        
    }
    
    public static void testNgramProb(){
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        NgramProb ngram = new NgramProb(2, tokenizer.getTokens("bawo ni omo ", null));
        System.out.println(ngram.getProb(tokenizer.getTokens("doix", null), false));
        System.out.println(ngram.getProb(tokenizer.getTokens("bawn", null), false));
    }
    
    public static void testLangDet(){
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        LangDetector a = new LangDetector();
        a.addLanguage("English", tokenizer.getTokens(" How are you doing today "
                + " I will not go to school today "
                + " Where is everyone going today", null));
        a.addLanguage("Japanese",  tokenizer.getTokens(" watashi no namae wa tanaka desu "
                + " kyou wa nanimo shinaide kudasai "
                + " kore ijou wa murii da to omoimasu ", null));
        a.addLanguage("German",  tokenizer.getTokens(" das ist gut "
                + " ich abeite nicht hier aber du abeit da "
                + " sie lient mich ", null));
        System.out.println(a.getLaguage("ramen wa oishii desu kedo oretachi wa yoku tabenai"));
    }
    
    public static void testMinEditDist(){
        String first = "boy";
        String second = "bot";
        System.out.println(TokenHelper.getMinEditDistence(first, second));
    }
    
   
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
