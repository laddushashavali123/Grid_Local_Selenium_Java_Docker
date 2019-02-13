package tests.example.demoqa.testcase;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.example.demoqa.pages.SelectablePage;

public class SelectableSpec extends DriverBase{
    @Test
    public void selectAndVerifyColor() throws InterruptedException {
        WebDriver driver = getDriver();
        SelectablePage selectablePage = new SelectablePage(driver);
        selectablePage.accessPage();
        selectablePage.selectOneItem();
        Thread.sleep(5000);
    }
}
