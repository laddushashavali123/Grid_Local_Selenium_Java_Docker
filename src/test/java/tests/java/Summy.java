/**
 * Instructions: Write a function that takes a string which has integers inside it separated by spaces, and your task is
 * to convert each integer in the string into an integer and return their sum.
 * Example:  summy("1 2 3")  ==> 6
 * Maximim int is 2,147,483,647
 */

package tests.java;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Summy {
    static long summy(String stringOfInts) {
        String temps[] = stringOfInts.split(" ", -1);
        int sum=0;
        for(String temp : temps){
            sum += Integer.parseInt(temp);
        }
        return sum;
    }

    @Test
    public void randomTests() {
        assertEquals(summy("1 2 3"), 6);
        System.out.println("1 2 3 equal to 6");
        assertEquals(summy("1 2 3 4"), 10);
        System.out.println("1 2 3 4 equal to 10");
        assertEquals(summy("1 2 3 4 5"), 15);
        System.out.println("1 2 3 4 5 equal to 15");
        assertEquals(summy("10 10"), 20);
        System.out.println("10 10 equal to 20");
        assertEquals(summy("0 0"), 0);
        System.out.println("0 0 equal to 0");
    }
}
