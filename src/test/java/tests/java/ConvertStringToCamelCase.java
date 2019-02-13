package tests.java;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ConvertStringToCamelCase {
    @Test
    public void test() throws IOException {
        String[] input = new String[] {"the_stealth_Warrior", "the-Stealth-warrior", "the-Stealth_Warrior", "the-stealth-warrior"};

        for (String s : input){
            System.out.println("input: "+ s);
            assertEquals("theStealthWarrior", toCamelCase(s));
        }

        System.out.println("input: "+ "t");
        assertEquals("t", toCamelCase("t"));

        System.out.println("input: "+ "T");
        assertEquals("T", toCamelCase("T"));

        System.out.println("input: "+ "The-stealth-warrior");
        assertEquals("TheStealthWarrior", toCamelCase("The-stealth-warrior"));
    }

    private String toCamelCase(String input) throws IOException {
        if (input.isEmpty() || input == null){
            System.out.println("Incorrect input buddy!!!");
            throw new IOException();
        }
        String[] splitStr = input.split("[_-]");
        if (splitStr.length != 1){
            for (int i=1; i< splitStr.length; i++){
                splitStr[i] = splitStr[i].substring(0,1).toUpperCase() + splitStr[i].substring(1).toLowerCase();
            }
            System.out.println("ouput: " + String.join("",splitStr));
            return String.join("",splitStr);
        }
        System.out.println("ouput: " + input);
        return input;
    }
}
