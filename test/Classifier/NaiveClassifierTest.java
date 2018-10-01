/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classifier;

import Lex.English.Tokenizers.EnglishTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mayowa
 */
public class NaiveClassifierTest {
    
    File file;
    public NaiveClassifierTest() throws FileNotFoundException, IOException {
        file = new File("C:\\Users\\mayowa\\Documents\\NetBeansProjects\\NLP\\Training Data\\DAT files\\classifier.dat");
        if(!file.exists()){
            EnglishTokenizer a = new EnglishTokenizer();  
            NaiveClassifier reviews = new NaiveClassifier("Reviews"); 
            reviews.createClass("Positive");
            reviews.createClass("Negative");
            File[] positive = new File("Training Data\\Corpus\\english\\movie reviews\\pos").listFiles();
            reviews.trainClass("Positive", positive);
            File[] negative = new File("Training Data\\Corpus\\english\\movie reviews\\neg").listFiles();
            reviews.trainClass("Negative", negative);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(reviews);
        }
        
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

   @Test
    public void testCreateClass() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        NaiveClassifier classifier = (NaiveClassifier)input.readObject();
        File[] positive_test = new File("Training Data\\Corpus\\english\\movie reviews\\positive test").listFiles();
        File[] negative_test = new File("Training Data\\Corpus\\english\\movie reviews\\negative test").listFiles();
      
      double count = 0;
      double correct = 0;
      for(int i = 0; i < positive_test.length; i++){
          if(classifier.test(positive_test[i]).equals("Positive")){
              correct += 1;
          }
          count++;
      }
      
      for(int i = 0; i < negative_test.length; i++){
          if(classifier.test(negative_test[i]).equals("Negative")){
              correct += 1;
          }
          count++;
      }
      double p = (double)((correct/count) * 100);
      System.out.println(correct + " of " + count + " = " + p + "%");  
    }
    
    @Test
    public void testddCreateClass() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        NaiveClassifier classifier = (NaiveClassifier)input.readObject();
        
        String review = "it was a good movie";
        System.out.println(review);
        System.out.println(classifier.test(review) + " review");
    }
    
    
}
