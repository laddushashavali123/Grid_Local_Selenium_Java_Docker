package tests.example.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ColorUtils;

import java.util.List;

public class SelectablePage {
    private WebDriver driver;
    // Constructor
    public SelectablePage(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    private By selectable = By.xpath("//ol[@id='selectable']/li");



    // Action
    public void accessPage(){
        driver.get("http://demoqa.com/selectable/");
    }

    public void selectOneItem() throws InterruptedException {
        // WebElement
        List<WebElement> selectList = driver.findElements(selectable);
        selectList.get(0).click();
        Thread.sleep(500);
        String backGroundColor = selectList.get(0).getCssValue("background-color");
        String[] temp = backGroundColor.replaceAll("[^0-9,]" ,"").split(",");
        for (String i : temp){
            System.out.println(i);
        }
        int red   = Integer.parseInt(temp[0]);
        int blue  = Integer.parseInt(temp[1]);
        int green = Integer.parseInt(temp[2]);

        ColorUtils color = new ColorUtils();
        System.out.println(color.getColorNameFromRgb(red,green, blue));

    }

    // Assertion

}
