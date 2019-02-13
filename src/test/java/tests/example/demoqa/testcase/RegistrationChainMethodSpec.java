package tests.example.demoqa.testcase;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.demoqa.pages.RegistrationChainMethodPage;

public class RegistrationChainMethodSpec extends DriverBase{
    @Test
    public void registerSuccess() throws Exception {
        WebDriver driver = DriverBase.getDriver();
        RegistrationChainMethodPage registrationPage = new RegistrationChainMethodPage(driver);

        registrationPage.accessPage();
        registrationPage.enterTextTo("First Name", "Dung Pro")
                .enterTextTo("Last Name", "Handsome")
                .selectCheckBox("Single")
                .selectCheckBox("Dance")
                .selectCheckBox("Reading")
                .selectCheckBox("Cricket ")
                .selectCountry("Vietnam")
                .setDateOfBirth(7,7,1990)
                .enterTextTo("Phone Number", "1234567890")
                .enterTextTo("Username", "kadung1234")
                .enterTextTo("E-mail", "kadung@mail.com")
                .enterTextTo("Your Profile Picture", "C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg")
                .enterTextTo("About Yourself","Hi my name is Slim Shaddy." )
                .enterTextTo("Password", "123456789")
                .enterTextTo("Confirm Password", "123456789");

        Thread.sleep(8000);
        registrationPage.submitClick();

        System.out.println(registrationPage.getFlashMessage());
    }
}

