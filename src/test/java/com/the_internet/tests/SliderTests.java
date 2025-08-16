package com.the_internet.tests;

import com.the_internet.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import the_internet.pages.alertsFrameWindows.HomePage;
import the_internet.pages.drag.SliderPage;

public class SliderTests extends TestBase {

    HomePage homePage;


    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        new HomePage(driver).selectSlider();
    }

    @Test
    @Tag("smoky")
    public void SliderTest() {
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .verifySliderByText("5");
    }
}
