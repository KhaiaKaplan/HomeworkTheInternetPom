package the_internet.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    public static Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);

    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return wait(time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public WebDriverWait wait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void switchToNewWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }
}

