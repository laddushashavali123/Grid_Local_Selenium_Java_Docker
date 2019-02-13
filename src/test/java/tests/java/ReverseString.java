package tests.java;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.util.ArrayUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseString {

    @Test
    public void test1(){
        Assert.assertEquals("Hello", reverseStr("olleH"));
    }

    private String reverseStr(String value) {
        char[] chars = value.toCharArray();
        ArrayUtils.reverse(chars);
        System.out.println("Old value is " + value);
        System.out.println("Return value is " + String.valueOf(chars));
        return String.valueOf(chars);
    }
}
