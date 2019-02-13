package tests.example;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.excel.ExcelUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class DataProviderSpec extends DriverBase{
    /**
     * TestNG Parameter in XML example
     * @throws InterruptedException
     */
    /*@Test
    @Parameters({"pUser", "pPass"})
    public void testngParameter(@Optional("Abc") String pUser, String pPass) throws InterruptedException {
    // Optional annotation is default value if pUser does not has any value
        WebDriver driver = getDriver();
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("log")).sendKeys(pUser);
        driver.findElement(By.id("pwd")).sendKeys(pPass);
        driver.findElement(By.id("login")).click();

        Thread.sleep(2000);
    }*/


    /**
     * TestNG Data provider example
     * @Parameters annotation is easy but to HelloController with multiple sets of data we need to use Data Provider.
     * @throws InterruptedException
     */
    /*@DataProvider(name="whateverNameYouWant")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "kadung", "kadung" },     // You can add as much parameter as you want
                        { "Krisha", "Krisha" },
                        { "Keving", "Keving" }
                };

    }

    @Test(dataProvider="whateverNameYouWant")
    public void testngDataProvider(String searchKey,String result) throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys(searchKey);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        System.out.println("Search key is " + searchKey);
        System.out.println("Result is " + result);
        System.out.println("Title is " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(result));
        Thread.sleep(5000);
    }*/


    /**
     * TestNG Data provider with excel example
     * @throws InterruptedException
     */
    @DataProvider(name="fromExcelFile")
    public Object[][] getDataFromDataprovider() throws IOException {
        String fileLocation = System.getProperty("user.dir")+ "\\src\\HelloController\\java\\testsdata\\data.xlsx";
        Object[][] arrayObject = ExcelUtils.getExcelDataToDataProvider(fileLocation,"Sheet1");
        return arrayObject;
    }

    @Test(dataProvider="fromExcelFile")
    public void testngDataProviderfromExcelFile(String searchKey,String result) throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys(searchKey);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        System.out.println("Search key is " + searchKey);
        System.out.println("Result is " + result);
        System.out.println("Title is " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(result));
        Thread.sleep(5000);
    }
}
