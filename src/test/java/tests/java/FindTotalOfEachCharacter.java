package tests.java;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FindTotalOfEachCharacter {
    @Test
    public void test() throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('H', 1);
        map.put('e', 2);
        map.put('l', 2);
        map.put('o', 1);
        Assert.assertEquals(map, TotalOfEachCharacter("Heello"));
        System.out.println("---------");
    }
    @Test
    public void test0() throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(' ', 2);
        map.put('1', 2);
        map.put('2', 2);
        map.put('3', 2);
        map.put('4', 1);
        map.put('5', 1);
        Assert.assertEquals(map, TotalOfEachCharacter("123123 45 44"));
    }

    @Test
    public void test1() throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();
        Assert.assertEquals(map, TotalOfEachCharacter(""));
    }

    private HashMap<Character,Integer> TotalOfEachCharacter(String value) throws IOException {
        if (value.equalsIgnoreCase("")){
            System.out.println("String should not be blank");
            throw new IOException();
        }
        HashMap<Character, Integer> result = new HashMap<>();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++){
            int count = StringUtils.countMatches(value,chars[i]);
            result.put(chars[i], count);
        }
        for (Map.Entry<Character, Integer> entry : result.entrySet() ){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        return result;
    }
}
