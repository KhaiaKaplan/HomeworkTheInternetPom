package com.the_internet.tests;

import com.the_internet.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.pages.alertsFrameWindows.HomePage;
import the_internet.pages.drag.DragAndDropPage;

public class DragAndDropTests extends TestBase {

    HomePage homePage;
    DragAndDropPage dragDrop;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        dragDrop = new DragAndDropPage(driver);
        new HomePage(driver).selectDragAndDrop();
    }

    @Test
    public void actionDragMeTest() {
        dragDrop.actionDragMe()
                .verifyByText("B");
    }

}
