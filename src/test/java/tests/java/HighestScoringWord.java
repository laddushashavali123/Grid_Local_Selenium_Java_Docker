/**
 * Given a string of words, you need to find the highest scoring word.
 * Each letter of a word scores points according to it's position in the alphabet: a = 1, b = 2, c = 3 etc.
 * You need to return the highest scoring word as a string.
 * If two words score the same, return the word that appears earliest in the original string.
 * All letters will be lowercase and all inputs will be valid.
 */

package tests.java;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HighestScoringWord {
    @Test
    public void sampleTests() {
        assertEquals("taxi", high("man i need a taxi up to ubud"));
        assertEquals("volcano", high("what time are we climbing up to the volcano"));
        assertEquals("semynak", high("take me to semynak"));
    }

    private String high(String s) {
        String[] strArray = s.split(" ");
        String result = "";
        int highestPoint = 0;

        for (String s1 : strArray){
            char[] chars = s1.toCharArray();
            int point = 0;
            for (char c : chars){
                point = point + (c - 96);
            }
            System.out.println(s1 + " has " + point);
            if (point > highestPoint){
                highestPoint = point;
                result = s1;
            }
        }
        return result;
    }
}
