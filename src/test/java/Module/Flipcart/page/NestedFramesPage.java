package Module.Flipcart.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

public class NestedFramesPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // ========== FRAMES ==========
    private By childFrame = By.tagName("iframe");
    private By childText = By.tagName("p");

    public void switchToChildFrame() {
        driver.switchTo().frame("frame1");
        WebElement frame = driver.findElement(childFrame);
        driver.switchTo().frame(frame);
    }

    public String getChildFrameText() {
        return driver.findElement(childText).getText();
    }

    // ========== ALERTS ==========
    private By alertButton = By.id("alertButton");
    private By timerAlertButton = By.id("timerAlertButton");
    private By confirmButton = By.id("confirmButton");
    private By promptButton = By.id("promtButton");

    public void handleAllAlerts() {
        driver.findElement(alertButton).click();
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Simple Alert: " + alert1.getText());
        alert1.accept();

        driver.findElement(timerAlertButton).click();
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Timed Alert: " + alert2.getText());
        alert2.accept();

        driver.findElement(confirmButton).click();
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirm Alert: " + alert3.getText());
        alert3.dismiss();

        driver.findElement(promptButton).click();
        Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Prompt Alert: " + alert4.getText());
        alert4.sendKeys("Test User");
        alert4.accept();
    }

    // ========== DRAG AND DROP ==========
    private By acceptTab = By.id("droppableExample-tab-accept");
    private By notAcceptable = By.id("notAcceptable");
    private By dropHere = By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']");

    public void performDragAndDrop_NotAcceptable() {
        driver.findElement(acceptTab).click();
        WebElement source = driver.findElement(notAcceptable);
        WebElement target = driver.findElement(dropHere);
        actions.dragAndDrop(source, target).perform();
        System.out.println("🔄 Drag and Drop performed for 'Not Acceptable'");
    }

    // ========== NEW WINDOW ==========
    private By newWindowButton = By.id("windowButton");

    public void handleNewWindow() {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(newWindowButton).click();
        // Wait for new window to open
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);

                WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));

                String text = heading.getText();
                System.out.println("✅ New window heading text: " + text);

                // Optional assertion
                if (!text.contains("This is a sample page")) {
                    throw new RuntimeException("❌ Unexpected text in new window");
                }

                driver.close(); // Close new tab/window
            }
        }

        driver.switchTo().window(mainWindow); // Return to original tab
    }


}
