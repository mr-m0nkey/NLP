package languagedetection;

import io.macaca.Lex.English.Tokenizers.EnglishTokenizer;
import io.macaca.POS.PosTagger;
import io.macaca.POS.WordTag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LangDetTest {

    EnglishTokenizer instance;

    public LangDetTest() {
        instance = new EnglishTokenizer();
    }



    @Test
    public void test() {
        String text = "wetin::question dey::aux-verb worry::verb you::noun </s> You::noun dey::verb house::noun";
        ArrayList<List<String>> result = instance.getTokens(text);


        PosTagger posTagger = new PosTagger(result);
        String text2 = "wetin dey do you";
        ArrayList<List<String>> result2 = instance.getTokens(text2);


        for (WordTag s : posTagger.tag(result2.get(0))) {

           System.out.println(s.getWord() + " " + s.getTag());

        }

//        boolean addIng = false;
//        for (WordTag s : posTagger.tag(result2.get(0))) {
//
//            if("dey".equalsIgnoreCase(s.getWord())) {
//                if("aux-verb".equalsIgnoreCase(s.getTag())){
//                    addIng = true;
//                    s.suggestedWord = "is";
//                }
//            } else {
//                if(addIng) {
//                    s.suggestedWord += "ing";
//                }
//                addIng = false;
//            }
//
//            if("wetin".equalsIgnoreCase(s.getWord())) {
//                s.suggestedWord = "what";
//            }
//
//            System.out.println(s.suggestedWord);
//
//        }
    }

    @Test
    public void daysOfWeekTest() {
        String[] daysOfTheWeek = {"SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT"};
        int k = 1000000000;
        String dayOfTheWeek = "SUN";
        int indexOfDayOfTheWeek = 0;

        for(int i = 0; i < daysOfTheWeek.length; i++) {
            if(daysOfTheWeek[i] == dayOfTheWeek) {
                indexOfDayOfTheWeek = i;
                break;
            }
        }

        int finalIndex = indexOfDayOfTheWeek;
        for(int i = indexOfDayOfTheWeek; i < k + indexOfDayOfTheWeek; i ++) {
            if(finalIndex >= daysOfTheWeek.length - 1) {
                finalIndex = 0;
            } else {
                finalIndex++;
            }
        }

        System.out.println(daysOfTheWeek[finalIndex]);
    }


    @Test
    public void daysOfWeekTest2() {
        String[] daysOfTheWeek = {"SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT"};
        int k = 1000000000;
        String dayOfTheWeek = "SUN";
        int indexOfDayOfTheWeek = 0;

        for(int i = 0; i < daysOfTheWeek.length; i++) {
            if(daysOfTheWeek[i] == dayOfTheWeek) {
                indexOfDayOfTheWeek = i;
                break;
            }
        }

//        k modulus 7
//        this will divide k by 7 and store the remainder
        int finalIndex = k % daysOfTheWeek.length;


        finalIndex += indexOfDayOfTheWeek + 1;
        if(finalIndex >= daysOfTheWeek.length) {
            finalIndex = k % daysOfTheWeek.length;
        }


        System.out.println(daysOfTheWeek[finalIndex - 1]);
    }
}
