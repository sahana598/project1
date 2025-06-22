package Module.Flipcart.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlipkartPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public FlipkartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    By closePopup = By.cssSelector("button._2KpZ6l._2doB4z");
    By fashionMenu = By.xpath("//span[text()='Fashion']");
    By kidsSubMenu = By.xpath("//a[text()='Kids']");
    By boysGirlsJeans = By.xpath("//a[text()='Boys & Girls Jeans']");
    By lowToHighSort = By.xpath("//div[text()='Price -- Low to High']");
    By productItems = By.cssSelector("a.rPDeLR");
    By productName = By.cssSelector("#container span.VU-ZEz");
    By productPrice = By.cssSelector("#container div.Nx9bqj.CxhGGd");
    By sizeOption = By.cssSelector("#swatch-0-size");
    By wishList = By.cssSelector("#container div.oUss6M");

    By addToCart = By.xpath("//button[text()='Add to cart']");
    By goToCart = By.xpath("//button[text()='GO TO CART']");
    By placeOrder = By.xpath("//span[text()='Place Order']");
    By cartItemName = By.cssSelector("div.gE4Hlh");
    By cartItemPrice = By.cssSelector("span.LAlF6k.re6bBo");

    public void closeLoginPopupIfPresent() {
        try {
            driver.findElement(closePopup).click();
        } catch (Exception ignored) {}
    }

    public void navigateToKidsJeansSection() {
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(fashionMenu))).perform();
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(kidsSubMenu))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(boysGirlsJeans)).click();
    }

    public void sortByLowToHigh() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(lowToHighSort)).click();
        Thread.sleep(3000);
    }

    public void selectFirstItem() {
        List<WebElement> items = driver.findElements(productItems);
        items.get(0).click();
    }

    public void switchToNewTab() {
        for (String win : driver.getWindowHandles()) {
            driver.switchTo().window(win);
        }
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void moveCursorAway() {
        WebElement logo = driver.findElement(By.cssSelector("a[title='Flipkart']"));  // Logo is always safe
        Actions actions = new Actions(driver);
        actions.moveToElement(logo).perform();
    }

        public void selectSizeAndAddToCart() throws InterruptedException {
          driver.findElement(sizeOption).click();
            Thread.sleep(1000);
            WebElement addBtn = driver.findElement(addToCart);
            scrollToElement(addBtn);
            addBtn.click();
        }

    public void goToCart() throws InterruptedException {
        WebElement placeAnOrder = driver.findElement(placeOrder);
        Thread.sleep(1000);
       if (placeAnOrder.isDisplayed()){
           System.out.println("Already in cart page");
       }
       else {
           wait.until(ExpectedConditions.visibilityOfElementLocated(goToCart)).click();
           System.out.println("Clicked on go to cart");
       }
    }

    public String getCartItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemName)).getText();
    }

    public String getCartItemPrice() {
        return driver.findElement(cartItemPrice).getText();
    }
}
