/**
 * You have an array of numbers. Your task is to sort ascending odd numbers but even numbers must be on their places.
 * Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.
 * Example:
 *      sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
 */
package tests.java;

import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import java.util.*;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class SortTheOddNotEven {
    private int[] bestsolution(int[] array) {
        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then replace them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }

        return array;
    }

    private int[] sortArray(int[] ints) {
        List<Integer> oddArr  = new ArrayList<>();
        List<Integer> evenArr = new ArrayList<>();
        List<Integer> evenPos = new ArrayList<>();


        for (int i=0; i< ints.length; i++){
            // Get index of even value
            if (ints[i] % 2 == 0){
                evenArr.add(ints[i]);
                evenPos.add(i);
            }
            // add odd value to another collection
            else{
                oddArr.add(ints[i]);
            }
        }

        // Sort odd collection
        Collections.sort(oddArr);

        // add even value back to its position
        for (int i=0; i < evenPos.size(); i++){
            oddArr.add(evenPos.get(i), evenArr.get(i));
        }

        int[] result = new int[oddArr.size()];
        for(int i = 0; i < oddArr.size(); i++) result[i] = oddArr.get(i);


        System.out.println("Odd collection is " + oddArr);

        return result;
    }

    @Test
    public void exampleTest1() {
        ArrayAsserts.assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, sortArray(new int[]{ 5, 3, 1, 8, 0 }));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, sortArray(new int[]{}));
    }
}
