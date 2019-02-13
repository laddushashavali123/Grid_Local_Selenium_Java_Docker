package tests.page_object.specs;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.page_object.pages.Annotation_BankLogin;
import tests.page_object.pages.Normal_BankLogin;

public class Login_Annotation extends DriverBase {
    @Test
    public void AnnotationTest(){
        WebDriver driver = getDriver();
        Annotation_BankLogin loginPage = new Annotation_BankLogin(driver);
        loginPage.nagivateToLoginPage()
                .enterUsername("mngr136913")
                .enterPassword("YbEhege")
                .clickSubmit()
                .verifyLoginSuccess();
    }
}
