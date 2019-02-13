package tests.java;

import org.testng.annotations.Test;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class CreatePhoneNumber{
    public static String createPhoneNumber(int[] numbers) {
        String result = "(";

        for(int i = 0; i < numbers.length; i++){
            if (i == 3){
                result += ") ";
            }
            if (i == 6){
                result += "-";
            }
            result = result.concat(String.valueOf(numbers[i]));
        }
        System.out.println(result);
        return result;
    }

    public static String bestSolution(int[] numbers){
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }

    @Test
    public void tests() {
        assertEquals("(123) 456-7890", createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
