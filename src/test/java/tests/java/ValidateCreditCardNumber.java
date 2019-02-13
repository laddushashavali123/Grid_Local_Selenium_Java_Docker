/**
 * In this Kata, you will implement the Luhn Algorithm, which is used to help validate credit card numbers. Given a
 * positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not. Here is
 * the algorithm:
 *  Double every other digit, scanning from right to left, starting from the second digit (from the right). Another way
 *  to think about it is: if there are an even number of digits, double every other digit starting with the first; if
 *  there are an odd number of digits, double every other digit starting with the second:
 *      1714 ==> [1*, 7, 1*, 4] ==> [2, 7, 2, 4]
 *      12345 ==> [1, 2*, 3, 4*, 5] ==> [1, 4, 3, 8, 5]
 *      891 ==> [8, 9*, 1] ==> [8, 18, 1]
 *  If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as subtracting
 *  9 from it):
 *      [8, 18*, 1] ==> [8, (1+8), 1] ==> [8, 9, 1]
 *  or:
 *      [8, 18*, 1] ==> [8, (18-9), 1] ==> [8, 9, 1]
 *  Sum all of the final digits:
 *      [8, 9, 1] ==> 8 + 9 + 1 = 18
 *  Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.
 *      18 (modulus) 10 ==> 8 , which is not equal to 0, so this is not a valid credit card number
 */
package tests.java;

import org.testng.annotations.Test;
import java.io.IOException;


import static org.testng.Assert.assertEquals;

public class ValidateCreditCardNumber {
    @Test
    public void test891() throws IOException {
        assertEquals(false, anotherValidate("891"));
        assertEquals(false, anotherValidate("4321"));
    }

    private boolean validate(String s) {
        int[] digits = new int[s.length()];
        int sum = 0;

        // Parse string to integer Array
        for (int i=0 ; i<s.length(); i++){
            digits[i] = s.charAt(i) - '0';
        }

        // Double every other digit, scanning from right to left, starting from the second digit (from the right)
        //ArrayUtils.reverse(digits);
        for (int i=0; i<digits.length/2; i++){
            int temp = digits[i];
            digits[i] = digits[digits.length - i - 1];
            digits[digits.length - i - 1] = temp;
        }
        for (int i=0; i<digits.length; i++){
            if (i%2 != 0){
                digits[i] += digits[i];
            }
            if (digits[i]>9){
                digits[i] -= 9;
            }
            sum += digits[i];
        }
        return sum%10 == 0;
    }

    private boolean anotherValidate(String s) throws IOException {
        if (s == null || s.isEmpty()){
            System.out.println("String is empty !!!");
            throw new IOException();
        }
        int[] digits = new int[s.length()];
        int sum = 0;

        // Parse string to integer Array and reverse the array
        for (int i=s.length()-1 ; i>=0; i--){
            digits[i] = s.charAt(i) - '0';
        }

        // Double every other digit, scanning from right to left, starting from the second digit (from the right)
        for (int i=0; i<digits.length; i++){
            if (i%2 != 0){
                digits[i] += digits[i];
            }
            if (digits[i]>9){
                digits[i] -= 9;
            }
            sum += digits[i];
        }
        return sum%10 == 0;
    }
}
