/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

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
public class TokenHelperTest {

    public TokenHelperTest() {
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
     * Test of getMinEditDistence method, of class TokenHelper.
     */
    @Test
    public void testGetMinEditDistenceA() {
        System.out.println("getMinEditDistence: Null Subweight");
        String first = "boy";
        String second = "bot";
        int expResult = 2;
        int result = TokenHelper.getMinEditDistence(first, second, null);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinEditDistanceB() {
        System.out.println("getMinEditDistence Non-null Subweight");
        String first = "boy";
        String second = "bot";
        int expResult = 1;
        int result = TokenHelper.getMinEditDistence(first, second, (char a, char b) -> 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinEditDistanceC() {
        System.out.println("getMinEditDistence Non-null Subweight implemented");
        String first = "boy";
        String second = "bot";
        int expResult = 2;
        int result = TokenHelper.getMinEditDistence(first, second, (char a, char b) -> {
            if (a == 'y' && b == 't') {
                return 2;
            } else {
                return 3;
            }
        });
        assertEquals(expResult, result);
    }

    @Test
    public void testMinEditDistanceD() {
        System.out.println("getMinEditDistence 1 empty string");
        String first = "";
        String second = "bot";
        int expResult = 3;
        int result = TokenHelper.getMinEditDistence(first, second, (char a, char b) -> 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinEditDistanceE() {
        System.out.println("getMinEditDistence 2 empty strings");
        String first = "";
        String second = "";
        int expResult = 0;
        int result = TokenHelper.getMinEditDistence(first, second, (char a, char b) -> 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testMinEditDistanceF() {
        System.out.println("getMinEditDistence all operations");
        String first = "azc";
        String second = "abz";
        int expResult = 2;
        int result = TokenHelper.getMinEditDistence(first, second, (char a, char b) -> 1);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
