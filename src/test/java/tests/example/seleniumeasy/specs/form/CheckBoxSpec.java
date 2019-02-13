package tests.example.seleniumeasy.specs.form;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.form.CheckBoxPage;

public class CheckBoxSpec extends DriverBase {
    @Test
    public void CheckBoxTest() throws InterruptedException {
        WebDriver driver = getDriver();
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.goCheckBox()
                .clickCheckBoxName("Click on this check box")
                .verifyCheckBoxMessageIs("Success - Check box is checked");

        checkBoxPage.clickInputButton("Check All")
                .verifyAllCheckBoxIs("Checked")
                .verifyInputButtonTextIs("Uncheck All");

        Thread.sleep(5000);
        checkBoxPage.clickInputButton("Uncheck All")
                .verifyAllCheckBoxIs("Unchecked")
                .verifyInputButtonTextIs("Check All");
        Thread.sleep(5000);
    }
}
