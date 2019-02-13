/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are
 * substrings of strings of a2.
 * #Example 1:
 *      a1 = ["arp", "live", "strong"]
 *      a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *      returns ["arp", "live", "strong"]
 * #Example 2:
 *      a1 = ["tarp", "mice", "bull"]
 *      a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *      returns []
 * Notes:
 *  Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
 *  In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
 *  Beware: r must be without duplicates.
 */
package tests.java;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class WhichAreIn {

    public static String[] bestsolution(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(str -> Arrays.stream(array2).anyMatch(s -> s.contains(str)))
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }

    public static String[] inArray(String[] array1, String[] array2) {
        List<String> list = new ArrayList<String>();
        for (String arr1 : array1){
            for (String arr2 : array2){
                if (arr2.contains(arr1)){
                    list.add(arr1);
                    break;
                }
            }
        }
        list = list.stream().distinct().collect(Collectors.toList());   // remove duplicated item
        Collections.sort(list);                                         // sort a-z
        String[] result = list.toArray(new String[0]);                  // convert list to string array
        for (String i : list){
            System.out.println(i);
        }
        return result;
    }

    @Test
    public void test1() {
        String a[] = new String[] { "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, WhichAreIn.bestsolution(a, b));
    }

    @Test
    public void test2() {
        String a[] = new String[] { "live", "strong", "arp" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, WhichAreIn.bestsolution(a, b));
    }

    @Test
    public void test3() {
        String a[] = new String[]{ "arp", "live", "strong", "arp" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, WhichAreIn.bestsolution(a, b));
    }

}
