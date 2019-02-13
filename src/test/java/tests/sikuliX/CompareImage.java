package tests.sikuliX;

import base.DriverBase;
import org.openqa.selenium.*;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareImage extends DriverBase {
    @Test
    public void test(){
        WebDriver driver = getDriver();
        driver.get("https://www.google.com.vn");
        driver.manage().window().maximize();

        // Verify that logo is existed
        Pattern checkedLogo = new Pattern(System.getProperty("user.dir") + "\\img\\sikulixDemo\\googlelogo.png");
        Screen screen = new Screen();
        try{
            double score = screen.find(checkedLogo).getScore();
            System.out.println("Similarity score the image or pattern was found: " + score);
            Assert.assertTrue((score>0.8));
            System.out.println("Logo is found");
        }
        catch(Exception e){
            System.out.println("Logo is not found");
            System.out.println(e.getStackTrace());
        }

    }

    public void takeElementScreenShoot(WebElement e){
        Point point = e.getLocation();
        Dimension dimensions = e.getSize();
        System.out.println("Getting element screenshoot ...");
        System.out.println("Element Width : " + dimensions.width);
        System.out.println("Element Height : " + dimensions.height);
        System.out.println("Element X Position : " + point.x);
        System.out.println("Element Y Position : " + point.y);
        Screen screen = new Screen();
        // Remember the padding CSS and it should include in x or y for equality
        ScreenImage screenShoot = screen.capture(point.x, point.y, dimensions.width, dimensions.height);
        screenShoot.save(System.getProperty("user.dir"));
    }
}
