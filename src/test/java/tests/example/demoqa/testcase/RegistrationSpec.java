package tests.example.demoqa.testcase;

import base.DriverBase;
import tests.example.demoqa.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegistrationSpec extends DriverBase{
    @Test
    public void registerSuccess() throws Exception {
        WebDriver driver = DriverBase.getDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.accessRegistration();
        registrationPage.enterFirstName("Dung");
        registrationPage.enterLastName("Kieu Anh");
        registrationPage.selectMaritalStatus("Married");
        registrationPage.selectHobby("Dance");
        registrationPage.selectHobby("Reading");
        registrationPage.selectHobby("Cricket ");
        registrationPage.selectCountry("Vietnam");
        registrationPage.selectMonth("7");
        registrationPage.selectDay("7");
        registrationPage.selectYear("1990");
        registrationPage.enterUsername("kadung1");
        registrationPage.enterPhone("0123456789");
        registrationPage.enterEmail("kadung1@kadung.com");
        registrationPage.uploadFile("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
        registrationPage.enterAbout("Hi my name is Slim Shaddy.");
        registrationPage.enterPWD("12345678x@X");
        registrationPage.submitClick();


        System.out.println(registrationPage.getFlashMessage());
    }


}

