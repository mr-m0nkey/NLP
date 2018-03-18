
import LanguageModels.NgramProb;
import Lex.English.Tokenizers.EnglishTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



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
        
        String review = "film is good";
        List<String> t = Collections.synchronizedList(new LinkedList<String>());
        File positive = new File("Training Data\\corpus\\english\\movie reviews\\pos");
        File[] pos = positive.listFiles();
        EnglishTokenizer a;
        for(int i = 0; i < 1; i++){
            a = new EnglishTokenizer(pos[i]);
            t.add("<s>");
            t.addAll(a.getTokens());
            t.add("</s>");
        }
        
        Map<String, String> map = new HashMap();
        map.put(".", "");
        map.put("*", "");
        
        t.stream().forEach((t1) -> {
            //System.out.println(t1);
        });
        System.out.println("Pos scan complete");
        NgramProb bigram = new NgramProb(2, t);
        System.out.println("Pos build complete");
        bigram.getNext(new EnglishTokenizer(review).getTokens(), 1);

        //float posres = bigram.getProb(new EnglishTokenizer(review).getTokens());
        /*
        
        List<String> y = Collections.synchronizedList(new LinkedList<String>());
        File negative = new File("Training Data\\corpus\\english\\movie reviews\\neg");
        File[] neg = negative.listFiles();
        for(int i = 0; i < 100; i++){
            a = new EnglishTokenizer(neg[i]);
            y.add("<s>");
            y.addAll(a.getTokens());
            y.add("</s>");
        }
        System.out.println("Negative scan complete");
        y.stream().forEach((t1) -> {
            //System.out.println(t1);
        });
        
        
        
        NgramProb bigrams = new NgramProb(3, y);
        System.out.println("neg build complete");
        float negres = bigrams.getProb(review);
        
        
        
        System.out.println("Pos res: " + posres + " Neg res: " + negres);
        if(posres > negres){
            System.out.println("Positive");
        }else{
            System.out.println("Negative");
        }
        */
        
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
