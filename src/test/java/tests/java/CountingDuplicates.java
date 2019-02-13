package tests.java;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        char chars[] = text.toCharArray();
        Set duplicateChar = new HashSet();
        for (int i=0; i<chars.length; i++){
            for (int j=i+1; j<chars.length; j++){
                if (chars[i] == (chars[j]) & !duplicateChar.contains(chars[i])){
                    duplicateChar.add(chars[i]);
                    break;
                }
            }
        }
        System.out.println("result: " + duplicateChar.size());
        return duplicateChar.size();
    }

    @Test
    public void abcdeReturnsZero() {
        assertEquals(duplicateCount("abcde"), 0);
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(2, CountingDuplicates.duplicateCount("inndivisibility"));
    }
}
