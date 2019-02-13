package tests.example.demoqa.testcase;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.example.demoqa.pages.ToolTipPage;

public class ToolTipSpec extends DriverBase{
    /*@Test
    public void ToolTip() throws InterruptedException {
        WebDriver driver = getDriver();
        ToolTipPage toolTipPage = new ToolTipPage(driver);

        toolTipPage.accessPage();
        Assert.assertTrue(toolTipPage.checkToolTipText("age","We ask for your age only for statistical purposes."));
        Thread.sleep(1000);
        System.out.println("Age tooltips is PASSED");
        Assert.assertTrue(toolTipPage.checkToolTipText("event","move down on show"));
        System.out.println("Age tooltips is PASSED");
        Thread.sleep(3000);
    }*/

    @Test
    public void checkToolTipTextFromItsDiv() throws InterruptedException {
        WebDriver driver = getDriver();
        ToolTipPage toolTipPage = new ToolTipPage(driver);

        toolTipPage.accessPage();
        Assert.assertTrue(toolTipPage.checkToolTipTextFromItsDiv("age","We ask for your age only for statistical purposes."));
        Thread.sleep(1000);
        Assert.assertTrue(toolTipPage.checkToolTipTextFromItsDiv("event","move down on show"));
    }
}
