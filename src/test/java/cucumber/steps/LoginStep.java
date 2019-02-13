package cucumber.steps;

import base.DriverBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.steps.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStep extends DriverBase {
    final Logger logger = LoggerFactory.getLogger(LoginStep.class);
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("^I am on the Login page$")
    public void iAmOnTheLoginPage(){
        this.driver = getDriver();
        loginPage = new LoginPage(driver);
        loginPage.nagivateToLoginPage();
    }

    @When("^I fill in username with \"([^\"]*)\"$")
    public void iFillInUsernameWith(String arg0) {
        loginPage.enterUsername(arg0);
    }

    @And("^I fill in password with \"([^\"]*)\"$")
    public void iFillInPasswordWith(String arg0){
        loginPage.enterPassword(arg0);
    }

    @And("^I click on the login button$")
    public void iClickOnTheLoginButton(){
        loginPage.clickSubmit();
    }

    @Then("^I should login successfully$")
    public void iShouldLoginSuccessfully() throws InterruptedException {
        loginPage.verifyLoginSuccess();
    }
}
