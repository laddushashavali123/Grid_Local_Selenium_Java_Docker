package tests.example.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToolTipPage {
    private WebDriver driver;
    public ToolTipPage(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    private By age      = By.xpath("//*[@id='age']");
    private By tootip   = By.xpath("//*[@class='ui-tooltip-content']");
    private By openEvt  = By.xpath("//*[@id='open-event']");

    // Method
    public void accessPage(){
        driver.get("http://demoqa.com/tooltip/");
    }

    public boolean checkToolTipText(String tooltipName,String expectedString) throws InterruptedException {
        WebElement element = null;
        if (tooltipName.equalsIgnoreCase("age")){
            element = driver.findElement(age);
        }
        else if (tooltipName.equalsIgnoreCase("event")){
            driver.findElement(By.xpath("//*[@id='ui-id-2']")).click();
            Thread.sleep(500);
            element = driver.findElement(openEvt);
        }
        else{
            System.out.println("No Tooltip Element selected");
            return false;
        }

        if (element == null) {
            System.out.println("No element found");
            return false;
        }

        System.out.println(element.getAttribute("title"));
        if (element.getAttribute("title").equalsIgnoreCase(expectedString)){
            return true;
        }
        else{
            return false;
        }
    }

    // Check if the tooltip really display
    public boolean checkToolTipTextFromItsDiv(String tooltipName,String expectedString) throws InterruptedException {
        WebElement element = null;
        if (tooltipName.equalsIgnoreCase("age")){
            driver.findElement(By.xpath("//*[@id='ui-id-1']")).click();
            Thread.sleep(500);
            element = driver.findElement(age);
        }
        else if (tooltipName.equalsIgnoreCase("event")){
            driver.findElement(By.xpath("//*[@id='ui-id-2']")).click();
            Thread.sleep(500);
            element = driver.findElement(openEvt);
        }
        else{
            System.out.println("No Tooltip Element selected");
            return false;
        }

        if (element == null) {
            System.out.println("No element found");
            return false;
        }

        // Hover to tooptip element
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

        // Get tool tip content
        String tooltipText = driver.findElement(tootip).getText();
        System.out.println(tooltipText);

        // Verify
        if (tooltipText.equalsIgnoreCase(expectedString)){
            return true;
        }
        else {
            return false;
        }
    }
}

