/**
 * Consider an array of sheep where some sheep may be missing from their place. We need a function that counts the number
 * of sheep present in the array (true means present). For example, the correct answer would be 17:
 *      [true,  true,  true,  false, true,  true,  true,  true , true,  false, true,  false, true,  false, false, true ,
 *      true,  true,  true,  true , false, false, true,  true]
 * Hint: Don't forget to check for bad values like null/undefined
 */
package tests.java;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountingSheep {

    final static Boolean[] array1 = {
            true,  true,  true,  false,
            true,  true,  true,  true ,
            true,  false, true,  false,
            true,  false, false, true ,
            true,  true,  true,  true ,
            false, false, true,  null };

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        int result = 0;
        for (int i=0; i<array1.length; i++){
            if (arrayOfSheeps[i] != null)
                if (arrayOfSheeps[i]) result++;

        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(countSheeps(array1), 16, "Sheeps in total is ");
        System.out.println("There are " + countSheeps(array1) + " sheeps in total");
    }


}
