package tests.chrome_extension;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.selenium.WebUtils;
import org.testng.asserts.SoftAssert;
import tests.example.Alert;
import java.awt.event.KeyEvent;


public class ClickToCall extends DriverBase {
    private Logger logger = LoggerFactory.getLogger(Alert.class);
    private final String testlink = "http://stdcxx.apache.org/doc/stdlibug/26-1.html";
    private final String extensionGUI = "chrome-extension://djmahmfbjmiaepjbjkoekidjfcgbcfhc/popup.html";
    @Test
    public void install() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://chrome.google.com/webstore/detail/click-to-call/djmahmfbjmiaepjbjkoekidjfcgbcfhc");
        By button = By.className("webstore-HelloController-button-label");
        WebUtils.clickWhenReady(button,5);
        Thread.sleep(8000);
        WebUtils.pressKeyboard(KeyEvent.VK_TAB);
        WebUtils.pressKeyboard(KeyEvent.VK_ENTER);

        for (int i=0;i<30; i++){
            String buttonText = driver.findElement(button).getText();
            logger.info("Button text: " + buttonText);
            if (buttonText.equalsIgnoreCase("ADDED TO CHROME")){
                Assert.assertTrue(buttonText.equalsIgnoreCase("ADDED TO CHROME"));
                break;
            }
            else if (i==29){
                Assert.fail();
            }
            Thread.sleep(5000);
        }
    }

    @Test(dependsOnMethods={"install"})
    public void disableEnableExtension() throws Exception {
        SoftAssert verification = new SoftAssert();
        WebDriver driver = getDriver();
        // Click first time
        driver.get(extensionGUI);
        WebUtils.clickWhenReady(By.id("enabled"),10);
        String buttonText = WebUtils.getText(By.id("enabledLabel"),10);
        logger.info("Button status for first click is " + buttonText);
        if (buttonText.equalsIgnoreCase("Enabled")){
            driver.get(testlink);
            WebElement myDynamicElement = WebUtils.findDynamicElement(By.partialLinkText("1-541-754-3010"), 10);
            String phoneNumLink = myDynamicElement.getAttribute("href");
            logger.info("Phone Number Link is " + phoneNumLink);
            verification.assertEquals(phoneNumLink, "omnicall:15417543010");
        }
        else{
            driver.get(testlink);
            String phonenumber = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]")).getText();
            logger.info("Normal phone number is " + phonenumber);
            verification.assertEquals(phonenumber,"1-541-754-3010");
        }
        Thread.sleep(1000);

        // Click second times
        driver.get(extensionGUI);
        WebUtils.clickWhenReady(By.id("enabled"),3);
        String buttonText1 = WebUtils.getText(By.id("enabledLabel"),3);
        logger.info("Button status for the second click is " + buttonText1);
        if (buttonText1.equalsIgnoreCase("Enabled")){
            driver.get(testlink);
            WebElement myDynamicElement = WebUtils.findDynamicElement(By.partialLinkText("1-541-754-3010"), 10);
            String phoneNumLink = myDynamicElement.getAttribute("href");
            logger.info("Phone Number Link is " + phoneNumLink);
            verification.assertEquals(phoneNumLink, "omnicall:15417543010");
        }
        else{
            driver.get(testlink);
            String phonenumber = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]")).getText();
            logger.info("Normal phone number is " + phonenumber);
            verification.assertEquals(phonenumber,"1-541-754-3010");
        }
        Thread.sleep(1000);

        verification.assertAll();
    }

    @Test(dependsOnMethods={"disableEnableExtension"})
    public void changeExtensionSetting() throws Exception {
        SoftAssert verification = new SoftAssert();
        WebDriver driver = getDriver();

        driver.get(extensionGUI);
        boolean extensionEnabled = driver.findElement(By.id("enabled")).isSelected();
        logger.info("Button status enabled: " + extensionEnabled);
        if (!extensionEnabled){
            WebUtils.clickWhenReady(By.id("enabled"),3);
            logger.info("Enbale extension");
        }

        WebUtils.clickWhenReady(By.id("viewSettings"),5);
        Thread.sleep(1000);

        WebElement northAmerica = driver.findElement(By.id("northAmerica"));
        WebElement southAmerica = driver.findElement(By.id("southAmerica"));
        WebElement europe = driver.findElement(By.id("europe"));
        WebElement asia = driver.findElement(By.id("asia"));
        WebElement input = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement submit = driver.findElement(By.xpath("//input[@type=\"submit\"]"));

        if (!northAmerica.isSelected()) {
            northAmerica.click();
            logger.info("northAmerica is checked");
        }
        if (!southAmerica.isSelected()) {
            southAmerica.click();
            logger.info("southAmerica is checked");
        }
        if (!europe.isSelected()) {
            europe.click();
            logger.info("europe is checked");
        }
        if (!asia.isSelected()) {
            asia.click();
            logger.info("asia is checked");
        }

        input.clear();
        input.sendKeys("testbaby");
        submit.click();
        logger.info("Test is after sendkey: " + input.getAttribute("value"));
        Thread.sleep(1000);

        verification.assertTrue(northAmerica.isSelected());
        verification.assertTrue(southAmerica.isSelected());
        verification.assertTrue(europe.isSelected());
        verification.assertTrue(asia.isSelected());
        verification.assertEquals(input.getAttribute("value"),"testbaby");

        driver.get(testlink);
        WebElement myDynamicElement = WebUtils.findDynamicElement(By.partialLinkText("1-541-754-3010"), 10);
        String phoneNumLink = myDynamicElement.getAttribute("href");
        logger.info("Phone Number Link is " + phoneNumLink);

        verification.assertEquals(phoneNumLink, "testbaby:15417543010");

        verification.assertAll();
    }

    @Test(dependsOnMethods={"install"})
    public void restoreDefault() throws Exception {
        SoftAssert verification = new SoftAssert();
        WebDriver driver = getDriver();
        driver.get(extensionGUI);
        WebElement viewbutton = WebUtils.findDynamicElement(By.id("viewSettings"),10);
        if (viewbutton.getText().equalsIgnoreCase("View Settings")){
            viewbutton.click();
            Thread.sleep(500);
        }

        WebElement restore = driver.findElement(By.id("restore"));
        restore.click();
        Thread.sleep(1000);

        WebElement northAmerica = driver.findElement(By.id("northAmerica"));
        WebElement southAmerica = driver.findElement(By.id("southAmerica"));
        WebElement europe = driver.findElement(By.id("europe"));
        WebElement asia = driver.findElement(By.id("asia"));
        WebElement input = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        verification.assertTrue(northAmerica.isSelected(), "northAmerica");
        verification.assertFalse(southAmerica.isSelected(), "southAmerica");
        verification.assertFalse(europe.isSelected(), "europe");
        verification.assertFalse(asia.isSelected(), "asia");
        verification.assertEquals(input.getAttribute("value"), "omnicall","Input value");
        verification.assertAll();
    }

}
