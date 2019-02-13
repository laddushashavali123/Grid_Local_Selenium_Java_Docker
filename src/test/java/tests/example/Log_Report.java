package tests.example;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log_Report extends DriverBase {
    final Logger logger = LoggerFactory.getLogger(Log_Report.class);


    @Test
    public void test1() throws Exception {
        Thread.sleep(3000);
        logger.info("This is HelloController 1");
    }

    @Test
    public void test3() throws Exception {
        Thread.sleep(2000);
        logger.info("This is HelloController 3");
        Reporter.log("This is fucking log in report!!");
    }


    @Test
    public void test2() throws Exception  {
        WebDriver driver = DriverBase.getDriver();
        Thread.sleep(1000);
        logger.info("This is HelloController 2");
        Reporter.log("This is error:");
        try {
            driver.get("google.com");
        }
        catch (Exception e){
            logger.debug("Exception error is ", e);
        }
    }
}
