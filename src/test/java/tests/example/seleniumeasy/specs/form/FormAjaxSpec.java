package tests.example.seleniumeasy.specs.form;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.form.FormAjaxPage;

public class FormAjaxSpec extends DriverBase {
    @Test
    public void AjaxFormTest() throws InterruptedException {
        WebDriver driver = getDriver();
        FormAjaxPage formAjaxPage = new FormAjaxPage(driver);

        formAjaxPage.goAjaxForm()
                .enterTextTo("Name", "Dung Kieu")
                .enterDiscription("There is nothing to enter here !!!")
                .clickSend()
                .verifyWatingMessage();

    }
}
