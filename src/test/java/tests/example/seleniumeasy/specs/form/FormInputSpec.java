package tests.example.seleniumeasy.specs.form;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.form.FormInputPage;

public class FormInputSpec extends DriverBase {
    @Test
    public void InputFormTest() throws InterruptedException {
        WebDriver driver = getDriver();
        FormInputPage formInputPage = new FormInputPage(driver);

        formInputPage.goInputForm()
                .enterTextTo("First Name", "Dung Kieu")
                .enterTextTo("Last Name", "Happy")
                .enterTextTo("E-Mail", "kad@kad.com")
                .enterTextTo("Phone #", "1234567890")
                .enterTextTo("Address", "123 Street Ward District HCM")
                .enterTextTo("City", "City")
                .selectStateName("Alaska")
                .enterTextTo("Zip Code", "73000")
                .enterTextTo("Website or domain name", "kad.com")
                .clickRadioButtonName("yes")
                .enterDescription("Hello, Slim Shady")
                .clickSend();
    }

    @Test
    public void verifyErrorMessage() {
        WebDriver driver = getDriver();
        FormInputPage formInputPage = new FormInputPage(driver);

        formInputPage.goInputForm()
                .enterTextTo("First Name", "a")
                .verifyError("First Name", "Please enter more than 2 characters");
                //.enterTextTo("E-Mail", "kad")
    }
}
