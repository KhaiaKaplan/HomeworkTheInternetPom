package the_internet.pages.alertsFrameWindows;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href^='/windows/new']")
    WebElement linkButton;

    public WindowsPage switchToNewTab(int index) {
        linkButton.click();
        switchToNewWindow(index);
        return this;
    }

    @FindBy(className = "example")
    WebElement newWindow;

    public WindowsPage verifyNewTabTitle(String title) {
        Assertions.assertTrue(shouldHaveText(newWindow,title,5));
        return this;
    }
}
