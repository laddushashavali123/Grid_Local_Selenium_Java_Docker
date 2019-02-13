package tests.java;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class HumanReadableTime {
    @Test
    public void Tests() throws IOException {
        assertEquals("00:00:00", makeReadable(0));
        assertEquals("00:00:15", makeReadable(15));
        assertEquals("00:01:00", makeReadable(60));
        assertEquals("00:01:20", makeReadable(80));
        assertEquals("01:00:00", makeReadable(3600));
        assertEquals("23:59:59", makeReadable(86399));
        assertEquals("99:59:59", makeReadable(359999));
    }

    public static String makeReadable(int second) throws IOException {
        String result = "", minute, hour, sec;

        if (second >= 0){
            if(second < 60){
                result = "00:00:" + String.format("%02d", second);
            }
            else {
                sec = String.format("%02d", second%60);
                int min = second/60;
                if ( min < 60 ){
                    minute = String.format("%02d", min);
                }
                else {
                    minute = String.format("%02d", min%60);
                }

                hour   = String.format("%02d", second/3600);
                result = hour + ":" + minute + ":" + sec;
            }

        } else {
            System.out.println("Time is never negative buddy !!!");
            throw new IOException();
        }
        System.out.println("-------------------");
        System.out.println(result);
        return result;
    }
}
