package tests.sikuliX;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class SikuliX extends DriverBase{
    @Test
    public void sikulixDemo() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com.vn/");
        Thread.sleep(3000);

        Screen sc = new Screen();
        String fileLoc = System.getProperty("user.dir") +"\\img\\sikulixDemo\\";

        try{
            sc.type(fileLoc + "Searchbox.png", "Dung HandSome");
            Thread.sleep(1000);
            sc.click(fileLoc + "SearchButton.png");
            Thread.sleep(1000);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }

        /*sc.type(fileLoc + "UserName.PNG", "abcdefg@gmail.com");
        sc.type(fileLoc + "Password.PNG", "password123");*/

        Thread.sleep(5000);
    }
}
