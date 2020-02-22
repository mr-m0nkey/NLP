/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.macaca.Lex.English.Tokenizers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mayowa
 */
public class EnglishTokenizerTest {
    
    EnglishTokenizer instance;
    
    public EnglishTokenizerTest() {
        instance = new EnglishTokenizer();
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

    /**
     * Test of getTokens method, of class EnglishTokenizer.
     */
    @Test
    public void testGetTokens_String() {
        System.out.println("Test 1");
        String text = "<s> I am a boy </s>";
        
        ArrayList<List<String>> expResult = new ArrayList();
        List<String> sentence = new ArrayList();
        sentence.add("<s>");
        sentence.add("i");
        sentence.add("am");
        sentence.add("a");
        sentence.add("boy");
        sentence.add("</s>");
        expResult.add(sentence);
        ArrayList<List<String>> result = instance.getTokens(text);
        System.out.println("String: " + text);
        System.out.println("Expected result: " + expResult);
        System.out.println("Result: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTokens method, of class EnglishTokenizer.
     */
    @Test
    public void testGetTokens_String_Map() {
        System.out.println("Test 2");
        String text = "I will not go";
        Map<String, String> map = new HashMap();
        map.put("will", "might");
        
        ArrayList<List<String>> expResult = new ArrayList();
        List<String> sentence = new ArrayList();
        sentence.add("i");
        sentence.add("might");
        sentence.add("not");
        sentence.add("go");
        expResult.add(sentence);
        ArrayList<List<String>> result = instance.getTokens(text, map);
        System.out.println("Expected result: " + expResult);
        System.out.println("Result: " + result);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTokens method, of class EnglishTokenizer.
     */
    @Test
    public void testGetTokens_File() throws Exception {
        System.out.println("Test 3");
        File file = new File("C:\\Users\\mayowa\\Documents\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\test.txt");
        ArrayList<List<String>> expResult = new ArrayList();
        List<String> sentence = new ArrayList();
        sentence.add("in");
        sentence.add("the");
        sentence.add("line");
        sentence.add("of");
        sentence.add("duty");
        expResult.add(sentence);
        ArrayList<List<String>> result = instance.getTokens(file);
        System.out.println("Expected result: " + expResult);
        System.out.println("Result: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTokens method, of class EnglishTokenizer.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTokens_File_Map() throws Exception {
        System.out.println("Test 4");
        File file = new File("C:\\Users\\mayowa\\Documents\\NetBeansProjects\\NLP\\Training Data\\Corpus\\english\\tokenizer.txt");
        Map<String, String> map = new HashMap();
        map.put("duty", "work");
        ArrayList<List<String>> expResult = new ArrayList();
        List<String> sentence = new ArrayList();
        sentence.add("in");
        sentence.add("the");
        sentence.add("line");
        sentence.add("of");
        sentence.add("work");
        expResult.add(sentence);
        ArrayList<List<String>> result = instance.getTokens(file, map);
        System.out.println("Expected result: " + expResult);
        System.out.println("Result: " + result);
        assertEquals(expResult, result);
        
    }
    
}
