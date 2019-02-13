package tests.example.seleniumeasy.specs.form;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.form.DropDownJqueryPage;

public class DropDownJquerySpec extends DriverBase{
    @Test
    public void JqueryDropDownTest() throws InterruptedException {
        WebDriver driver = getDriver();
        DropDownJqueryPage jqueryDropDownPage = new DropDownJqueryPage(driver);

        jqueryDropDownPage.goJqueryDropDown()
                .clickDropBox("Select Country")
                .selectCountry("Bangladesh")
                .enterDropBox("Select State", "Alaska")
                .enterDropBox("Select State", "Alaba");

        Thread.sleep(5000);
    }
}
