package tests.example.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SortablePage {
    private WebDriver driver;
    public SortablePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator
    By sorttable = By.xpath("//*[@id='sortable']");

    // Element


    // Method
    public void accessPage(){
        driver.get("http://demoqa.com/sortable/");
    }

    public void moveElement(String fromItem, String toItem){
        WebElement from = driver.findElement(By.xpath("//*[text()='" + fromItem +"']"));
        WebElement to = driver.findElement(By.xpath("//*[text()='" + toItem +"']"));

        System.out.println(from.getText());
        System.out.println(to.getText());

        Actions act=new Actions(driver);
        //ct.dragAndDrop(from, to).build().perform();
        act.clickAndHold(from).clickAndHold(to).release().build().perform();
        //act.clickAndHold(from).moveToElement(to).release().build().perform();

    }

    // Assertion
    public void checkLocation() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Items position after sorting is:");
        System.out.println(driver.findElement(sorttable).getText());
    }

}

