package tests.java;

import org.testng.annotations.Test;

/**
 * Strip any leading or trailing spaces from a Java String
 * Consider you have a text "    keep space inside   ", it should be "keep space inside" after trim
 */
public class DeleteAllSpaceExceptInTheMiddle {
    @Test
    public void test(){
        String givenString = "  keep space inside   ";
        System.out.println(givenString);
        System.out.println(givenString.trim());
    }
}
