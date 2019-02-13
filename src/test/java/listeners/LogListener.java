package listeners;

import base.DriverBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MyPC
 * Ref: http://www.nullin.com/2010/07/28/logging-tests-to-separate-files
 */
public class LogListener extends TestListenerAdapter {
    private static final Logger log = LoggerFactory.getLogger(LogListener.class);
    private static final String TEST_NAME = "testname";

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private Date date = new Date();
    private String screenshotDirectory = System.getProperty("screenshotDirectory") + File.separator + dateFormat.format(date);

    @Override
    public void onTestStart(ITestResult tr)  {
        MDC.put(TEST_NAME, tr.getName());
        log.info(tr.getMethod() + " is running.");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis()
                + "_PASSED_" + tr.getName() + ".png";
        Screenshoot.takeScreenShot(screenshotAbsolutePath);
        log.info(tr.getMethod() + " is PASSED.");
        MDC.remove(TEST_NAME);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        String screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis()
                + "_FAILED_" + tr.getName() + ".png";
        Screenshoot.takeScreenShot(screenshotAbsolutePath);
        log.error(tr.getMethod() + " is FAILED.");
        MDC.remove(TEST_NAME);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log.info(tr.getMethod() + " is SKIPPED.");
        MDC.remove(TEST_NAME);
    }
}
