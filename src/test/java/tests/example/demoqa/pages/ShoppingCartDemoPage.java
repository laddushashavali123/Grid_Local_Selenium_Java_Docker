package tests.example.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.selenium.WebUtils;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDemoPage {
    private WebDriver driver;
    // Constructor
    public ShoppingCartDemoPage (WebDriver driver){
        this.driver = driver;
    }

    // Locator
    private By page        = By.xpath("//a[@href='#tabs-5']");
    private By cart        = By.xpath("//ol[@class='ui-droppable ui-sortable']");
    private By shirts      = By.xpath("//*[@id='ui-id-6']");
    private By bags        = By.xpath("//*[@id='ui-id-8']");
    private By gadgets     = By.xpath("//*[@id='ui-id-10']");
    private By shirtItems  = By.xpath("//*[@id='ui-id-7']/ul/li");
    private By bagItems    = By.xpath("//*[@id='ui-id-9']/ul/li");
    private By gadgetItems = By.xpath("//*[@id='ui-id-11']/ul/li");

    // Action
    public void accessPage() throws InterruptedException {
        driver.get("http://demoqa.com/droppable/");
        driver.findElement(page).click();
        Thread.sleep(500);
    }

    public void drapItemToCart() throws InterruptedException {
        List<WebElement> shirts = driver.findElements(shirtItems);
        List<WebElement> bags = driver.findElements(bagItems);
        List<WebElement> gadgets = driver.findElements(gadgetItems);
        WebElement carts = driver.findElement(cart);

        WebUtils.drapAndDrop(shirts.get(0), carts);
        Thread.sleep(500);

    }


    // Assertion
    public List<String> checkItemsFromCatalogue(String str) throws InterruptedException {
        List<String> result = new ArrayList<>();
        List<WebElement> elements = new ArrayList<>();
        if (str.equalsIgnoreCase("shirt")){
            driver.findElement(shirts).click();
            Thread.sleep(200);
            elements = driver.findElements(shirtItems);
        }
        else if (str.equalsIgnoreCase("bag") ){
            driver.findElement(bags).click();
            Thread.sleep(200);
            elements = driver.findElements(bagItems);
        }
        else if (str.equalsIgnoreCase("gadget")){
            driver.findElement(gadgets).click();
            Thread.sleep(200);
            elements = driver.findElements(gadgetItems);
        }
        for (WebElement ele : elements){
            result.add(ele.getText());
        }
        return result;
    }

    public List<String> checkCart(){
        List<String> result = new ArrayList<>();
        List<WebElement> cartItems = driver.findElements(cart);
        for (WebElement ele : cartItems){
            result.add(ele.getText());
        }
        return result;
    }
}
