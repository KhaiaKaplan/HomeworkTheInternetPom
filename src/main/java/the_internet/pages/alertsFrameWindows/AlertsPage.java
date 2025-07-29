package the_internet.pages.alertsFrameWindows;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement AlertButton;



    public AlertsPage verifyAlert() {
        AlertButton.click();
        Assertions.assertTrue(isAlertPresent());
        return this;
    }


    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement confirmButton;

    public AlertsPage selectResult(String result) {
        confirmButton.click();
        if (result != null && result.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }


    @FindBy(id = "result")
    WebElement confirmResult;

    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(shouldHaveText(confirmResult,text,10));
        return this;
    }


    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement promtButton;
    public AlertsPage sendMessageToAlert(String message) {
        promtButton.click();
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }


    @FindBy(id = "result")
    WebElement promptResult;
    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(shouldHaveText(promptResult,text,10));
        return this;
    }
}
