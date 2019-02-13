package tests.example;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion extends DriverBase{
    @Test
    public void SoftTest(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(false);
        softAssert.assertEquals(1, 2);
        softAssert.assertAll();
    }
}
