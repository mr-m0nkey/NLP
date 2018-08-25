/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import Lex.Tokenizer.Token;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author mayowa
 */
public class TokenHelper {
    
    /**
     *
     */
    @FunctionalInterface
    public interface SubstitutionWeight{

        /**
         *
         * @param a
         * @param b
         * @return
         */
        int getWeight(char a, char b);
    }
    
    /**
     *
     * @param first
     * @param second
     * @param subWeight
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
                        op = Optional.of(subWeight).orElseGet((Supplier<? extends SubstitutionWeight>) (SubstitutionWeight) (char a, char b) -> {
                            return 2;
                        }).getWeight(first.charAt(fir - 1), second.charAt(sec - 1));
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
    
    /**
     *
     * @param first
     * @param second
     * @param subWeight
     * @return
     */
    public static int getMinEditDistence(Token first, Token second, SubstitutionWeight subWeight){
        String f = first.toString();
        String s = second.toString();
        return getMinEditDistence(f, s, subWeight);
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
    
    //override to get the probability of substituting a(correct) for b(incorrect)

    /**
     *
     * @param a
     * @param b
     * @return
     */
        protected static int sub(char a, char b){
        return 2;
    }

    private static class ConsumerImpl implements Consumer<SubstitutionWeight> {

        public ConsumerImpl() {
        }

        @Override
        public void accept(SubstitutionWeight t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
