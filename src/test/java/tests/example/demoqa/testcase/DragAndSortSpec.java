package tests.example.demoqa.testcase;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.example.demoqa.pages.DragAndSortPage;

public class DragAndSortSpec extends DriverBase{

    @Test
    public void test1() throws Exception {
        WebDriver driver = DriverBase.getDriver();
        DragAndSortPage dragAndSortPage = new DragAndSortPage(driver);
        dragAndSortPage.accessPage();
        dragAndSortPage.drapToItem();
        Assert.assertEquals(dragAndSortPage.getText(6), "Drag me down");
    }

}
