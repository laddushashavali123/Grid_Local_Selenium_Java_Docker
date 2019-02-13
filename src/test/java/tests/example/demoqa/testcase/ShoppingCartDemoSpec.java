package tests.example.demoqa.testcase;

import base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.example.demoqa.pages.ShoppingCartDemoPage;

import java.util.Arrays;
import java.util.List;

public class ShoppingCartDemoSpec extends DriverBase{
    List<String> tShirtItems = Arrays.asList("Lolcat Shirt", "Cheezeburger Shirt", "Buckit Shirt");
    List<String> bagItems    = Arrays.asList("Zebra Striped", "Black Leather", "Alligator Leather");
    List<String> gadgetItems = Arrays.asList("iPhone", "iPod", "iPad");
    List<String> cartItems   = Arrays.asList("Lolcat Shirt");

    @Test
    public void verifyItemInCatalogue() throws InterruptedException {
        WebDriver driver = getDriver();
        ShoppingCartDemoPage shop = new ShoppingCartDemoPage(driver);
        shop.accessPage();

        Thread.sleep(1000);
        System.out.println("Gadget " + shop.checkItemsFromCatalogue("gadget").size() + " items are: " + shop.checkItemsFromCatalogue("gadget"));
        System.out.println("Expected" + gadgetItems.size() + "Gadget items are: " + gadgetItems );
        Assert.assertEquals(shop.checkItemsFromCatalogue("gadget"), gadgetItems);

        System.out.println("Shirt items are: " + shop.checkItemsFromCatalogue("shirt"));
        Assert.assertEquals(shop.checkItemsFromCatalogue("shirt"), tShirtItems);

        System.out.println("Bag items are: " + shop.checkItemsFromCatalogue("bag"));
        Assert.assertEquals(shop.checkItemsFromCatalogue("bag"), bagItems);

    }

    @Test
    public void verifyProductIsAddedToCart() throws InterruptedException {
        WebDriver driver = getDriver();
        ShoppingCartDemoPage shop = new ShoppingCartDemoPage(driver);
        shop.accessPage();

        shop.drapItemToCart();
        Assert.assertEquals(shop.checkCart(),cartItems);

    }
}
