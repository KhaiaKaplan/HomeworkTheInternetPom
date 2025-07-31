package the_internet.pages.dropdown;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import the_internet.core.BasePage;

public class DropdownMenuPage extends BasePage {

    public DropdownMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "dropdown")
    WebElement dropdown;

    public DropdownMenuPage dropdownListSelect(String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
        return this;
    }

    public DropdownMenuPage verifyOption() {
        String FirstOption = new Select(dropdown).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(dropdown, FirstOption,5));
        return this;
    }
}
