package tests.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;

public class S4B_Electron {
	@Test
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\drivers\\binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
		String S4BLocation = "C:\\Users\\kadung\\AppData\\Local\\Programs\\RTC_Client_for_Skype_for_Business_SV_NVS_Vz_CuCM_O365\\RTC Client for Skype for Business - SV NVS Vz CuCM O365.exe";


		ChromeOptions options = new ChromeOptions();
	    options.setBinary(S4BLocation);

	    // Local instance
		WebDriver driver = new ChromeDriver(options);

		// Remote instance
		//WebDriver driver = new RemoteWebDriver(new URL("http://10.250.193.110:4444/wd/hub"), options);


		// Action

		Thread.sleep(30000);
		driver.findElement(By.partialLinkText("Can’t access your account?")).click();
		Thread.sleep(10000);
		System.out.println("cannot access display?" + driver.findElement(By.id("i0116")).isDisplayed());
		System.out.println("cannot access display?" + driver.findElement(By.id("cantAccessAccount")).isDisplayed());
		System.out.println(driver.findElement(By.id("cantAccessAccount")).getText());

		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='i0116']")));
		element.clear();
		element.sendKeys("ucc.user61@gbsolutions.work");




      	driver.close();
	  	driver.quit();
	}
}
