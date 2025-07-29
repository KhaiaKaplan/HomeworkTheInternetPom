package the_internet.pages.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href^='/javascript_alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        alerts.click();
        return new AlertsPage(driver);
    }

    @FindBy(css = "a[href^='/windows']")
    WebElement browserWindows;
    public WindowsPage selectBrowserWindows() {
    browserWindows.click();
        return new WindowsPage(driver);
    }
}

