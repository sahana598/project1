package Module.Flipcart.test;

import Module.Flipcart.page.NestedFramesPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NestedFramesTest extends BaseTest {

    @Test
    public void verifyChildFrameText() {
        driver.get("https://demoqa.com/nestedframes");
        NestedFramesPage framePage = new NestedFramesPage(driver);
        framePage.switchToChildFrame();
        String actualText = framePage.getChildFrameText();
        System.out.println("Child Frame Text: " + actualText);
        Assert.assertEquals(actualText, "Child Iframe", " Frame text mismatch!");
    }

    @Test
    public void handleDemoQAAlerts() {
        driver.get("https://demoqa.com/alerts");
        NestedFramesPage page = new NestedFramesPage(driver);
        page.handleAllAlerts();
    }

    @Test
    public void performDragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        NestedFramesPage page = new NestedFramesPage(driver);

        page.performDragAndDrop_NotAcceptable();
    }

    @Test(alwaysRun = true,description = "verify the text in the new window and close it.")
    public void verifyNewWindowText() {
        driver.get("https://demoqa.com/browser-windows");
        NestedFramesPage page = new NestedFramesPage(driver);

        page.handleNewWindow();
    }
}
