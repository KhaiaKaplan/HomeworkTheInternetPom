package the_internet.pages.alertsFrameWindows;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }


    public FramePage switchToFrameByName(String frameName) {
        driver.switchTo().frame(frameName);
        return this;
    }


    @FindBy(xpath = "//body[contains(text(), 'BOTTOM')]")
    WebElement bottomFrame;

    public FramePage verifyFrameByTitle(String title) {
        Assertions.assertTrue(shouldHaveText(bottomFrame,title,5));
        return this;
    }


    @FindBy(css = "body")
    WebElement frameBody;

    public FramePage handleNestedFrames() {

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        Assertions.assertTrue(shouldHaveText(frameBody, "MIDDLE", 5));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        Assertions.assertTrue(shouldHaveText(frameBody, "LEFT", 5));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assertions.assertTrue(shouldHaveText(frameBody, "RIGHT", 5));
        return this;
    }

}
