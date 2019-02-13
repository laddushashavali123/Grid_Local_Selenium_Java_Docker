package tests.page_object.specs;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import tests.page_object.pages.Normal_BankLogin;

public class Login_Normal extends DriverBase {
    final private Logger logger = LoggerFactory.getLogger(Login_Normal.class);
    @Test
    public void Normal() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().window().fullscreen();
        Normal_BankLogin login = new Normal_BankLogin(driver);
        login.openLoginPage()
                .enterUsername("mngr136913")
                .enterPassword("YbEhege")
                .clickSubmit()
                .verifyLoginSuccess();

        Thread.sleep(5000);
    }
}
