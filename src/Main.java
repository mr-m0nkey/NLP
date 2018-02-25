
import DataStructures.NgramGraph;
import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.Token;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
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
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        
        
        
        
        EnglishTokenizer a = new EnglishTokenizer("What are you doing?");
        Map<String, String> map = new HashMap();
        map.put(".", "");
        map.put("*", "");
        List<Token> t;
        t = a.getTokens();
        NgramGraph g = new NgramGraph(2, t);
        t.stream().forEach((t1) -> {
            System.out.println(t1.word_form);
            g.AddVertex(t1);
        });
        
        
        
        
        
        
        
        
        
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
