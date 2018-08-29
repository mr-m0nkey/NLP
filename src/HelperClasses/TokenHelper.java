/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

/**
 * Perform minor tasks on strings. A utility class
 * @author mayowa
 */
public class TokenHelper {
    
    /**
     * A functional interface representing a lambda that should be run to determine the substitution value of two characters when calculating minimum edit distance
     */
    @FunctionalInterface
    public interface SubstitutionWeight{

        /**
         * determines the cost of substituting a character for another. 
         * @param a The initial character
         * @param b The new character
         * @return The cost of substitution
         */
        int getWeight(char a, char b);
    }
    
    /**
     * Calculates the minium edit distance of two strings
     * @param first The first string
     * @param second The second string
     * @param subWeight A lambda to handle substitution weights, it can be set to null
     * @return
     */
    public static int getMinEditDistence(String first, String second, SubstitutionWeight subWeight){
        first = first.toLowerCase();
        second = second.toLowerCase();
        int[][] table = new int[first.length() + 1][second.length() + 1];
        
        {
            for(int sec = 0; sec <= second.length(); sec++){
                table[0][sec] = sec;
            }

            for(int fir = 0; fir <= first.length(); fir++){
                table[fir][0] = fir;
            }
        }//initializing the array
        
        
        
        for(int fir = 1; fir <= first.length(); fir++){
            for(int sec = 1; sec <= second.length(); sec++){
                if(first.charAt(fir - 1) != second.charAt(sec - 1)){
                    int left = table[fir - 1][sec]; //delete
                    int leftUp = table[fir - 1][sec - 1]; //substitute
                    int up = table[fir][sec - 1]; //insert
                    int minimum = min(left, leftUp, up);
                    int op;
                    if(minimum == left){
                        op = 1;
                    }else if(minimum == up){
                        op = 1;
                    }else{
                        if(subWeight == null){
                            subWeight = (char a, char b) -> 2;
                        }
                        op = subWeight.getWeight(first.charAt(fir - 1), second.charAt(sec - 1));
                    }
                    table[fir][sec] =  + op;
                }else{
                    int leftUp = table[fir - 1][sec - 1];
                    table[fir][sec] = leftUp;
                }

            }
        }
        return table[first.length()][second.length()];
    }
        
    private static int min(int a, int b, int c){
        int smallest = b;
        if(a < b){
            smallest = a;
        }
        if(c < smallest){
            smallest = c;
        }
        return smallest;
    }
    
}
