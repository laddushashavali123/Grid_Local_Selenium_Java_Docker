package tests.example.seleniumeasy.specs.form;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.seleniumeasy.pages.form.DropDownSelectPage;

import java.awt.*;

public class DropDownSelectSpec extends DriverBase {
    @Test
    public void SelectDropDownTest() throws InterruptedException, AWTException {
        WebDriver driver = getDriver();
        DropDownSelectPage selectDropDownPage = new DropDownSelectPage(driver);

        selectDropDownPage.goSelectDropDown()
                .selectOption( "Tuesday")
                .verifySelectListResultIs("Tuesday");

        /*selectDropDownPage.dropDownSingleSelectByText("Multi Select List Demo", "Washington")
                .dropDownSingleSelectByText("Multi Select List Demo","California")
                .clickButton("First Selected");
        Thread.sleep(10000);*/

        /*selectDropDownPage.dropDownMultipleSelectContinous("Multi Select List Demo", 1,3);
        Thread.sleep(5000);*/
    }
}
