/**
 * Find all possible combination for all the number in the given list
 * Solution: https://introcs.cs.princeton.edu/java/23recursion/
 */

package tests.java;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Permutation_Recursion {
    /**
     * Permutation for a giving String
     * @throws IOException
     */
    @Test
    public void test1(){
        //permutation(",", "abcdf");

    }






    /**
     * Permutation for a giving array of number
     */
    @Test
    public void test() throws IOException {
        long[] numbers = {5, 3, 1};
        long[] expected = {531, 513, 351, 315, 153, 135,};
        //Assert.assertEquals(expected, permutation(numbers));
    }

    private String[] permutationss(long[] numbers) throws IOException {
        String[] result = null;
        int len = numbers.length;
        if (len == 0) {
            System.out.println("Invalid input!");
            throw new IOException("");
        }

        for(long n : numbers){


        }
        return result;
    }
}
