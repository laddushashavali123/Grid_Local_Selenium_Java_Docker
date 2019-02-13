package tests.example;

import base.DriverBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TabSwitch extends DriverBase {
    Logger logger = LoggerFactory.getLogger(TabSwitch.class);
    /*@Test
    public void TabSwitch() throws  Exception   {
        WebDriver driver = getDriver();
        driver.get("http://demo.guru99.com/popup.php");
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        // Get the ID of parent tab
        String MainWindow = driver.getWindowHandle();
        logger.info("Current tab id is " + MainWindow);

        // Get all the IDs of tabs
        Set<String> allID = driver.getWindowHandles();
        String newWindow = null;
        for (String ID : allID){
            if (ID.equalsIgnoreCase(MainWindow)) {
                newWindow = ID;
            }
        }
        loger.info("New Wiindow ID is " + newWindow);
g
        Thread.sleep(5000);
        driver.switchTo().window(MainWindow);
        Thread.sleep(5000);
    }*/

    @Test
    public void TabSwitchMany() throws  Exception   {
        WebDriver driver = getDriver();
        driver.get("https://google.com.vn");

        // Tab ID
        List<String> tabIDs = new ArrayList<>();

        // Get the tab ID of current tab
        tabIDs.add(driver.getWindowHandle());
        logger.info("Current tab id is " + tabIDs.get(0));

        // Open new tab
        openNewTab();

        // Add new tab ID to our array
        tabIDs.add(returnNewTabID(tabIDs, driver.getWindowHandles()));
        logger.info("Current tab id is " + tabIDs.get(1));

        // Switch to new tab
        driver.switchTo().window(tabIDs.get(1));
        driver.get("https://google.com.vn");

        // Open new tab
        openNewTab();

        // Add new tab ID to our array
        tabIDs.add(returnNewTabID(tabIDs, driver.getWindowHandles()));
        logger.info("Current tab id is " + tabIDs.get(2));

        // Switch to new tab
        driver.switchTo().window(tabIDs.get(2));
        driver.get("https://bing.com");

        Thread.sleep(10000);

        /*logger.info("------------------------" );
        for (String ID : tabIDs){
            logger.info(ID);
        }*/
    }

    public void openNewTab(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            Thread.sleep(3000);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String returnNewTabID(List<String> tabIDs, Set<String> allID){
        List<String> temp = new ArrayList<>();
        temp.addAll(allID);

        for(String i : tabIDs){
            for (String j : temp){
                if (i.equalsIgnoreCase(j)){
                    temp.remove(i);
                    break;
                }
            }
        }
        return temp.get(0);
    }
}
