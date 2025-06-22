package Module.Flipcart.test;

import Module.Flipcart.page.FlipkartPage;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartTest extends BaseTest {

    @Test
    public void flipkartFlowWithPOM() throws InterruptedException {
        driver.get("https://www.flipkart.com/");

        FlipkartPage flipkart = new FlipkartPage(driver);
        flipkart.closeLoginPopupIfPresent();
        flipkart.navigateToKidsJeansSection();
        flipkart.sortByLowToHigh();
        flipkart.selectFirstItem();
        flipkart.switchToNewTab();

        String productName = flipkart.getProductName();
        String productPrice = flipkart.getProductPrice();

        flipkart.selectSizeAndAddToCart();
        flipkart.goToCart();
        String cartName = flipkart.getCartItemName();
        String cartPrice = flipkart.getCartItemPrice();

        System.out.println("Product name before adding to cart: " + productName);
        System.out.println("Product price before adding to cart: " + productPrice);
        System.out.println("Product name in cart: " + cartName);
        System.out.println("Product price in cart: " + cartPrice);
        Assert.assertTrue(
                cartName != null && productName != null && cartName.toLowerCase().contains(productName.toLowerCase()),
                "❌ Item name mismatch! Expected name to contain: " + productName + " but got: " + cartName
        );
        Assert.assertEquals(cartPrice, productPrice, "❌ Price mismatch!");

    }

}
