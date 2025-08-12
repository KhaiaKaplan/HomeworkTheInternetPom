package the_internet.pages.files;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

public class FileUploaderPage extends BasePage {

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "file-upload")
    WebElement uploadPicture;

    public FileUploaderPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement uploadButton;

    public FileUploaderPage clickUpload() {
        click(uploadButton);
        return this;
    }

    @FindBy(className = "no-js")
    WebElement newWindow;

    public FileUploaderPage verifyNewTabTitle(String title) {
        Assertions.assertTrue(shouldHaveText(newWindow,title,5));
        return this;
    }
}
