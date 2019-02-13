package tests.example.seleniumeasy.specs.form;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.form.FormSimplePage;

public class FormSimpleSpec extends DriverBase {
    @Test
    public void SimpleFormTest1(){
        WebDriver driver = getDriver();
        FormSimplePage simpleFormPage = new FormSimplePage(driver);

        simpleFormPage.goSimpleForm()
                .enterTextToTextBox("Enter message", "Hi, I am Danny")
                .clickButtonName("Show Message")
                .verifyResultTextIs("Hi, I am Danny");

        simpleFormPage.enterTextToTextBox("Enter a", "1")
                .enterTextToTextBox("Enter b", "2")
                .clickButtonName("Get Total")
                .verifyTotalTextIs("3");
    }
}
