/**
 * x Simple, given a string of words, return the length of the shortest word(s).
 * String will never be empty and you do not need to account for different data types.
 */
package tests.java;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShortestWord {
    public int findShort(String str){
        if (str == null || str.length() == 0) return 0;
        String[] temp = str.split(" ");
        int result = temp[0].length();
        for (String i : temp){
            if (i.length() < result) result = i.length();
        }
        return result;
    }

    @Test
    public void findShort() throws Exception {
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, findShort("turns out random HelloController cases are easier than writing out basic ones"));
    }

}
