package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebTable extends DriverBase {

    @Test
    public void checkAValue(){
        WebDriver driver = getDriver();
        driver.get("http://toolsqa.com/automation-practice-table/");
        // Dynamic locator
        By Taipei101Height = By.xpath("//*[text()= 'Taipei 101']/following-sibling::td[3]");
        System.out.println("Taipei 101 is " + driver.findElement(Taipei101Height).getText() + " height");
        System.out.println("Burj Khalifa is " + StructureHeight(driver,"Burj Khalifa") + " height");
    }

    // Method
    public String StructureHeight(WebDriver driver, String str){
        String xpath = "//*[text()= '" + str + "']/following-sibling::td[3]";
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
