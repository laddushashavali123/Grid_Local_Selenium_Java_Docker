package tests.java;

import com.tigervnc.rdr.InStream;
import gherkin.lexer.Fi;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
    /**
     * Create a array (length is 3) which has even number from 0
     */
    @Test
    public void createArray(){
        int[] arr = IntStream.iterate(0, i -> i + 2).limit(3).toArray();
        for (int i = 0; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * Create an Fibonaci list
     */
    @Test
    public void test1(){
        long[] FabonaciFirstTen = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        assertEquals(FabonaciFirstTen, createFibonaciWithLength(10));
    }

    private long[] createFibonaciWithLength(int n) {
        long[] result = new long[n];
        for (int i = 0; i < n; i++){
            result[i] = returnFibonacciNumAtPosition(i+1);
            System.out.println(i+1 + " : " + result[i]);
        }
        return result;
    }

    private long returnFibonacciNumAtPosition(int n) {
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }


}
