
import Classifier.Group;
import Lex.English.Tokenizers.EnglishTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



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
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        
        
        
      EnglishTokenizer a = new EnglishTokenizer();
      
      Group Reviews = new Group("author"); 
      Reviews.createClass("Positive");
      Reviews.createClass("Negative");
      File[] positive = new File("Training Data\\Corpus\\english\\movie reviews\\pos").listFiles();
      Reviews.trainClass("Positive", positive);
      File[] negative = new File("Training Data\\Corpus\\english\\movie reviews\\neg").listFiles();
      Reviews.trainClass("Negative", negative);
      
      File[] positive_test = new File("Training Data\\Corpus\\english\\movie reviews\\positive test").listFiles();
      File[] negative_test = new File("Training Data\\Corpus\\english\\movie reviews\\negative test").listFiles();
      
      System.out.println("positive");
      for(int i = 0; i < positive_test.length; i++){
          Reviews.test(positive[i]);
      }
      
      System.out.println("Negative");
      for(int i = 1; i <= negative_test.length; i++){
          Reviews.test(negative[i]);
      }
        /*
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
        */
        
        
        
        
        
    }
    

    
}
