package com.the_internet.tests;

import com.the_internet.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.pages.alertsFrameWindows.HomePage;
import the_internet.pages.links.BrokenImagesPage;

public class BrokenImagesTests extends TestBase {

    HomePage homePage;
    BrokenImagesPage brokenImages;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        brokenImages= new BrokenImagesPage(driver);
        new HomePage(driver).selectBrokenImages();
    }

    @Test
    public void checkBrokenImagesTest() {
        brokenImages.checkBrokenImages();
    }
}
