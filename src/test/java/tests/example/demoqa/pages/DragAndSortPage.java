package tests.example.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndSortPage {
    // Constructor
    WebDriver driver;
    public DragAndSortPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements locator
    By drapAndSort = By.xpath("//a[@href='#tabs-7']");
    By dragElement = By.xpath("//*[@id='draggablebox']");
    By sortList = By.xpath("//*[@id='sortablebox']/li");


    // Execution methods
    public void accessPage() throws InterruptedException {
        driver.get("http://demoqa.com/draggable/");
        driver.findElement(drapAndSort).click();
        Thread.sleep(500);
    }

    public void drapToItem() throws InterruptedException {
        WebElement fromElement = driver.findElement(dragElement);
        List<WebElement> sortListElement = driver.findElements(sortList);
        Actions act = new Actions(driver);
        act.dragAndDrop(fromElement, sortListElement.get(0)).build().perform();
        Thread.sleep(1000);
        /*act.dragAndDrop(fromElement, sortListElement.get(0)).build().perform();
        Thread.sleep(1000);
        act.dragAndDrop(fromElement, sortListElement.get(1)).build().perform();
        Thread.sleep(1000);
        act.dragAndDrop(fromElement, sortListElement.get(2)).build().perform();
        Thread.sleep(1000);
        act.dragAndDrop(fromElement, sortListElement.get(3)).build().perform();
        Thread.sleep(1000);
        act.dragAndDrop(fromElement, sortListElement.get(4)).build().perform();
        Thread.sleep(10000);*/
    }

    public String getText(int i) throws InterruptedException {
        List<WebElement> sortListElement = driver.findElements(sortList);
        return sortListElement.get(i-1).getText();
    }

}
