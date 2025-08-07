package the_internet.pages.drag;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement dragMe;
    @FindBy(id = "column-b")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        actions.dragAndDrop(dragMe,dropHere).perform();
        return this;
    }

    public DragAndDropPage verifyByText(String text) {
        Assertions.assertTrue(shouldHaveText(dragMe, text, 5));
        return this;
    }
}