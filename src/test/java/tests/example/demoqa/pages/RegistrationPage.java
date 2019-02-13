package tests.example.demoqa.pages;

import utils.selenium.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {
    // Default
    private WebDriver driver;

    // Elements locator
    private By firstNameTextBox = By.xpath("//*[@id='name_3_firstname']");
    private By lasNameTextBox   = By.xpath("//*[@id='name_3_lastname']");
    private By countryDropdown  = By.xpath("//*[@id='dropdown_7']");
    private By monthDropdown    = By.xpath("//*[@id='mm_date_8']");
    private By dayDropdown      = By.xpath("//*[@id='dd_date_8']");
    private By yearDropdown     = By.xpath("//*[@id='yy_date_8']");
    private By phoneTextBox     = By.xpath("//*[@id='phone_9']");
    private By usernameTextBox  = By.xpath("//*[@id='username']");
    private By emailTextBox     = By.xpath("//*[@id='email_1']");
    private By uploadButton     = By.xpath("//*[@id='profile_pic_10']");
    private By aboutTextBox     = By.xpath("//*[@id='description']");
    private By pwdTextBox       = By.xpath("//*[@id='password_2']");
    private By pwdConfTextBox   = By.xpath("//*[@id='confirm_password_password_2']");
    private By submitButton     = By.xpath("//*[@name='pie_submit']");

    private By successMessage   = By.xpath("//*[@class='piereg_message']");
    private By errorMessage     = By.xpath("//*[@class='piereg_login_error']");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Access registration pages
    public void accessRegistration() {
        String registrationURL = "http://demoqa.com/registration/";
        driver.get(registrationURL);
        driver.manage().window().maximize();
    }

    public void enterFirstName(String text){
        driver.findElement(firstNameTextBox).sendKeys(text);
    }

    public void enterLastName(String text){
        driver.findElement(lasNameTextBox).sendKeys(text);
    }

    public void selectMaritalStatus(String text){
        // Check if first leter is UpperCase
        if (text.substring(0,1).equals(text.substring(0,1).toUpperCase()) ) {
            text = text.substring(0,1).toLowerCase() + text.substring(1);
        }
        By xpath = By.xpath("//input[@value='" + text + "']");
        driver.findElement(xpath).click();
    }

    public void selectHobby(String hobby){
        // Check if first leter is UpperCase
        if (hobby.substring(0,1).equals(hobby.substring(0,1).toUpperCase()) ) {
            hobby = hobby.substring(0,1).toLowerCase() + hobby.substring(1);
        }
        By xpath = By.xpath("//input[@value='" + hobby + "']");
        driver.findElement(xpath).click();
    }

    public void selectCountry(String country){
        WebUtils.selectDropDownByText(countryDropdown, country);
    }

    public void selectMonth(String month){
        WebUtils.selectDropDownByValue(monthDropdown, month);
    }

    public void selectDay(String day){
        WebUtils.selectDropDownByValue(dayDropdown, day);
    }

    public void selectYear(String year){
        WebUtils.selectDropDownByValue(yearDropdown, year);
    }

    public void enterPhone(String phone){
        driver.findElement(phoneTextBox).sendKeys(phone);
    }

    public void enterUsername(String username){
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void enterEmail(String email){
        driver.findElement(emailTextBox).sendKeys(email);
    }

    public void uploadFile(String location){
        driver.findElement(uploadButton).sendKeys(location);
    }

    public void enterAbout(String text){
        driver.findElement(aboutTextBox).sendKeys(text);
    }

    public void enterPWD(String pwd){
        driver.findElement(pwdTextBox).sendKeys(pwd);
        driver.findElement(pwdConfTextBox).sendKeys(pwd);
    }

    public void submitClick() {
        driver.findElement(submitButton).click();
    }

    public String getFlashMessage() {
        String flashMessage;
        try {
            flashMessage = WebUtils.findDynamicElement(successMessage,10).getText();
        }
        catch (Exception e){
            flashMessage = WebUtils.findDynamicElement(errorMessage,10).getText();
        }
        return flashMessage;
    }
}
