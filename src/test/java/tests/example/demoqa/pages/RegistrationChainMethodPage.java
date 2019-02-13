package tests.example.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.selenium.WebUtils;

import java.io.IOException;


public class RegistrationChainMethodPage {
    // Default
    private WebDriver driver;
    String registrationURL = "http://demoqa.com/registration/";

    // Elements locator
    private By countryDropdown  = By.xpath("//*[@id='dropdown_7']");
    private By monthDropdown    = By.xpath("//*[@id='mm_date_8']");
    private By dayDropdown      = By.xpath("//*[@id='dd_date_8']");
    private By yearDropdown     = By.xpath("//*[@id='yy_date_8']");
    private By uploadButton     = By.xpath("//*[@id='profile_pic_10']");
    private By submitButton     = By.xpath("//*[@name='pie_submit']");

    private By successMessage   = By.xpath("//*[@class='piereg_message']");
    private By errorMessage     = By.xpath("//*[@class='piereg_login_error']");

    // Constructor
    public RegistrationChainMethodPage(WebDriver driver) {
        this.driver = driver;
    }

    // Access registration pages
    public void accessPage() {
        driver.get(registrationURL);
        driver.manage().window().maximize();
    }

    public RegistrationChainMethodPage enterTextTo(String inputName, String content){
        By xpath = By.xpath("//*[text()=\"" + inputName + "\"]/following-sibling::*");
        driver.findElement(xpath).sendKeys(content);
        return this;
    }

    public RegistrationChainMethodPage selectCheckBox(String boxName){
        By xpath = By.xpath("//*[text()=\"" + boxName + "\"]/following-sibling::input");
        driver.findElement(xpath).click();
        return this;
    }

    public RegistrationChainMethodPage setDateOfBirth(int m, int d, int y) throws IOException {
        if(m > 0 && m < 13){
            WebUtils.selectDropDownByValue(monthDropdown, Integer.toString(m));
        }
        else {
            System.out.println("Invalid month value");
            throw new IOException();
        }
        if (d > 0 && d < 32){
            WebUtils.selectDropDownByValue(dayDropdown, Integer.toString(d));
        }
        else {
            System.out.println("Invalid day value");
            throw new IOException();
        }
        if (y > 1950 && y < 2015){
            WebUtils.selectDropDownByValue(yearDropdown, Integer.toString(y));
        }
        else {
            System.out.println("Invalid year value");
            throw new IOException();
        }
        return this;
    }

    public RegistrationChainMethodPage selectCountry(String country){
        WebUtils.selectDropDownByText(countryDropdown, country);
        return this;
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
