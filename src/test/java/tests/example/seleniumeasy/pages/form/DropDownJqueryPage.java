package tests.example.seleniumeasy.pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.selenium.WebUtils;

public class DropDownJqueryPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(DropDownJqueryPage.class);

    // Constructor
    public DropDownJqueryPage(WebDriver driver){
        this.driver =  driver;
    }

    // Locator
    By popupSearch      = By.xpath("//span[contains(@class,'select2-container select2-container--default select2-container--open')]/span/span/input");


    // Action
    public DropDownJqueryPage goJqueryDropDown() {
        driver.get("http://www.seleniumeasy.com/HelloController/jquery-dropdown-search-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public  DropDownJqueryPage selectCountry(String country){
        WebElement popupSearchBox = WebUtils.findDynamicElement(popupSearch,3);
        popupSearchBox.sendKeys(country);
        popupSearchBox.sendKeys(Keys.ENTER);
        return this;
    }

    public DropDownJqueryPage clickDropBox(String dropboxName){
        driver.findElement(By.xpath("//*[contains(text(), '" + dropboxName + "')]/following-sibling::span")).click();
        return this;
    }

    public DropDownJqueryPage enterDropBox(String dropboxName, String content){
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(), '" + dropboxName + "')]/following-sibling::span/span/span/ul/li/input"));
        ele.sendKeys(content);
        ele.sendKeys(Keys.ENTER);
        return  this;
    }

}
