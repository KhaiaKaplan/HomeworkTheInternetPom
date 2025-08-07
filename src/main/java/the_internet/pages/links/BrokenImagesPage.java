package the_internet.pages.links;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import the_internet.core.BasePage;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenImagesPage checkBrokenImages() {
        System.out.println("Total images on the page: " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            verifyLinks(imageURL);

            try {
                boolean imageDisplayed = (Boolean)js.executeScript
                        ("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);",image);

                if (imageDisplayed) {
                    softly.assertThat(imageDisplayed);
                } else {
                    softly.fail("Broken image is " + imageURL);
                }
            } catch (Exception e) {
                System.out.println("ERROR occurred");
            }
        }
        softly.assertAll();
        return this;
    }

}
