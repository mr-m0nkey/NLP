/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import Lex.Tokenizer.Token;

/**
 *
 * @author mayowa
 */
public class TokenHelper {
    
    
    public static int getMinEditDistence(String first, String second){
        //TODO: Implement this method
        int[][] table = new int[first.length() + 1][second.length() + 1];
        
        {
            //when sec = 0
            for(int sec = 0; sec <= second.length(); sec++){
                table[0][sec] = sec;
            }

            //when fir = 0
            for(int fir = 0; fir <= first.length(); fir++){
                table[fir][0] = fir;
            }
        }//initializing the array
        
        
        
        for(int fir = 1; fir <= first.length(); fir++){
            //System.out.println("Row" + fir);
            for(int sec = 1; sec <= second.length(); sec++){
                if(first.charAt(fir - 1) != second.charAt(sec - 1)){
                    int left = table[fir - 1][sec];
                    int leftUp = table[fir - 1][sec - 1];
                    int up = table[fir][sec - 1];
                    table[fir][sec] = min(left, leftUp, up) + 1;
                }else{
                    int leftUp = table[fir - 1][sec - 1];
                    table[fir][sec] = leftUp;
                }
              //              System.out.println(table[fir][sec]);

            }
        }
        //System.out.println(table[0][5]);
        return table[first.length()][second.length()];
    }
    
    public static int getMinEditDistence(Token first, Token second){
        String f = first.toString();
        String s = second.toString();
        return getMinEditDistence(f, s);
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
