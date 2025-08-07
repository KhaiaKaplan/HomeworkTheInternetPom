package the_internet.pages.drag;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='range']")
    WebElement sliderInput;


    public SliderPage moveSliderInHorizontalDirection() {
        actions.dragAndDropBy(sliderInput,65,0).perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement sliderValue;

    public SliderPage verifySliderByText(String number) {
        Assertions.assertTrue(shouldHaveText(sliderValue, number, 5));
        return this;
    }
}


