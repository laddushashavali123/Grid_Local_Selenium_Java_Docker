// https://www.guru99.com/select-option-dropdown-selenium-webdriver.html
// http://toolsqa.com/selenium-webdriver/dropdown-multiple-select-operations

package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.selenium.WebUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DropDownandCheckBox extends DriverBase{
    Logger logger = LoggerFactory.getLogger(DropDownandCheckBox.class);

    @Test
    public void test() throws InterruptedException, AWTException {
        WebDriver driver = DriverBase.getDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");

        WebUtils.pressKeyboard(KeyEvent.VK_PAGE_DOWN);

        // Checkbox and Radio button
        WebUtils.selectCheckBox("Male");
        WebUtils.selectCheckBox("Automation Tester");
        WebUtils.selectCheckBox("Automation Tester");

        // Single dropdown list
        By dropDownList = By.xpath("//*[@id='continents']");
        WebUtils.selectDropDownByText(dropDownList, "Antartica");

        // Multiple choice list
        WebUtils.selectDropDownByText(By.xpath("//*[@id='selenium_commands']"),"Navigation Commands");
        WebUtils.selectDropDownByText(By.xpath("//*[@id='selenium_commands']"),"Switch Commands");
        WebUtils.selectDropDownByText(By.xpath("//*[@id='selenium_commands']"),"Wait Commands");

        Thread.sleep(5000);


    }






}
