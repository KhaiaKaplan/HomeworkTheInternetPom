package the_internet.pages.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;
import the_internet.pages.drag.DragAndDropPage;
import the_internet.pages.drag.SliderPage;
import the_internet.pages.dropdown.DropdownMenuPage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "a[href^='/javascript_alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        alerts.click();
        return new AlertsPage(driver);
    }

    @FindBy(css= "a[href^='/windows']")
    WebElement browserWindows;
    public WindowsPage selectBrowserWindows() {
    browserWindows.click();
        return new WindowsPage(driver);
    }

    @FindBy(css= "a[href^='/nested_frames']")
    WebElement frames;

    public FramePage selectNestedFrames() {
        click(frames);
        return new FramePage(driver);
    }

    @FindBy(css= "a[href^='/dropdown']")
    WebElement dropdownMenu;

    public DropdownMenuPage selectDropdown() {
        click(dropdownMenu);
        return new DropdownMenuPage(driver);
    }



    @FindBy (css= "a[href^='/horizontal_slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        click(slider);
        return new SliderPage(driver);
    }

    @FindBy (css= "a[href^='/drag_and_drop']")
    WebElement dragDrop;

    public DragAndDropPage selectDragAndDrop() {
        click(dragDrop);
        return new DragAndDropPage(driver);
    }
}
