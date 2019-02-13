/**
 * Story:
 *  Ben has a very simple idea to make some profit: he buys something and sells it again. Of course, this wouldn't give
 *  him any profit at all if he was simply to buy and sell it at the same price. Instead, he's going to buy it for the
 *  lowest possible price and sell it at the highest.
 *
 * Task:
 *  Write a function that returns both the minimum and maximum number of the given list/array.
 *
 * Examples:
 *  MinMax.minMax(new int[]{1,2,3,4,5}) == {1,5}
 *  MinMax.minMax(new int[]{2334454,5}) == {5, 2334454}
 *  MinMax.minMax(new int[]{1}) == {1, 1}
 *
 * Remarks:
 *  All arrays or lists will always have at least one element, so you don't need to check the length. Also, your function
 *  will always get an array or a list, you don't have to check for null, undefined or similar.
 */
package tests.java;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class MaxMinInArray {


    public static int[] solution1(int[] arr) {
        int result[] = {arr[0], arr[0]};
        for (int i : arr){
            if (i < result[0]) {
                result[0] = i;
            }
            if (i > result[1]) {
                result[1] = i;
            }
        }
        return result;
    }

    public static int[] solution2(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[0], arr.length -1};
    }

    Random rand;

    @BeforeTest
    public void initTest() {
        rand = new Random();
    }

    @Test
    public void minMaxRandomTest() {
        for(int i = 0; i < 20; i++) {
            int r = rand.nextInt();
            //Assert.assertArrayEquals(new int[]{r, r}, MaxMinInArray.solution1(new int[]{r}));
        }
    }
}
