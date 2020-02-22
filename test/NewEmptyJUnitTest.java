/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author mayowa
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
   
    /*
    public static void testPos(){
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        PosTagger tagger = new PosTagger(tokenizer.getTokens("<s> I::pronoun am::verb a::determiner boy::noun </s>"));
        List<String> tags = tagger.tag(tokenizer.getTokens("I am a boy").get(0));
        System.out.println(tags);
    }
    
    public static void testNgramProb(){
        ITokenizer tokenizer;
        tokenizer = new EnglishTokenizer();
        NgramProb ngram = new NgramProb(2, tokenizer.getTokens("bawo ni omo ", null));
        System.out.println(ngram.getProb(tokenizer.getTokens("doix", null).get(0)));
        System.out.println(ngram.getProb(tokenizer.getTokens("bawn", null).get(0)));
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
        IIndexWord idxWord = dict.getIndexWord("is", io.macaca.POS.VERB);
        IWordID wordID = idxWord.getWordIDs().get(0);
        IWord word = dict.getWord(wordID);
        System.out.println("Id = " + wordID);
        System.out.println("Lemma = " + word.getLemma());
        System.out.println("Gloss = " + word.getSynset().getGloss());
        }
    
    
    
    */
}
