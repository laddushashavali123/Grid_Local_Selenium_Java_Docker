package tests.page_object.specs;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.page_object.pages.HashMap_BankLogin;
import tests.page_object.pages.Normal_BankLogin;

public class Login_Hashmap extends DriverBase {
    @Test
    public void Hashmap(){
        WebDriver driver = getDriver();
        HashMap_BankLogin login = new HashMap_BankLogin(driver);
        login.enter("username", "mngr136913")
                .enter("password", "YbEhege")
                .click("submitButton")
                .verifyLoginSuccess();
    }
}
