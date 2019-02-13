package listeners;

import base.DriverBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Screenshoot {
    private static final Logger log = LoggerFactory.getLogger(LogListener.class);

    public static void takeScreenShot(String savePath){
        try {
            WebDriver driver = DriverBase.getDriver();

            File screenshot = new File(savePath);
            if (createFile(screenshot)) {
                try {
                    writeScreenshotToFile(driver, screenshot);
                }
                catch (ClassCastException weNeedToAugmentOurDriverObject) {
                    writeScreenshotToFile(new Augmenter().augment(driver), screenshot);
                }
                log.info("Written screenshot to " + screenshot);
            }
            else {
                log.error("Unable to create " + screenshot);
            }
        }
        catch (Exception ex) {
            log.error("Unable to capture screenshot...");
            ex.printStackTrace();
        }
    }

    private static boolean createFile(File screenshot) throws IOException {
        boolean fileCreated = false;
        if (screenshot.exists()) {
            fileCreated = true;
        }
        else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                fileCreated = screenshot.createNewFile();
            }
        }
        return fileCreated;
    }

    private static void writeScreenshotToFile(WebDriver driver, File screenshot) throws IOException {
        FileOutputStream screenshotStream = new
                FileOutputStream(screenshot);
        screenshotStream.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        screenshotStream.close();
    }
}
