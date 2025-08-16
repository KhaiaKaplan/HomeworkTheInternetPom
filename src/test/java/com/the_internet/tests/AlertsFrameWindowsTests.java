package com.the_internet.tests;

import com.the_internet.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import the_internet.pages.alertsFrameWindows.AlertsPage;
import the_internet.pages.alertsFrameWindows.FramePage;
import the_internet.pages.alertsFrameWindows.HomePage;
import the_internet.pages.alertsFrameWindows.WindowsPage;

public class AlertsFrameWindowsTests extends TestBase {

    AlertsPage alerts;
    HomePage homePage;
    FramePage frame;

    @BeforeEach
    public void precondition() {
        alerts = new AlertsPage(driver);
        homePage= new HomePage(driver);
        frame = new FramePage(driver);
    }

    @Test
    public void waitAlertTest() {
        homePage.selectAlerts();
        alerts.verifyAlert();
    }

    @Test
    @Tag("smoky")
    public void alertWithSelectResultTest() {
        homePage.selectAlerts();
        alerts.selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest() {
        homePage.selectAlerts();
        alerts.sendMessageToAlert("Hello World!")
                .verifyMessage("Hello World!");
    }

    @Test
    public void switchToNewTabTest() {
        homePage.selectBrowserWindows();
        new WindowsPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("New Window");
    }

    @Test
    public void nestedFramesTest() {
        homePage.selectNestedFrames();
        frame.handleNestedFrames();
    }

    @Test
    @Tag("smoky")
    public void switchToFrameByNameTest() {
        homePage.selectNestedFrames();
        frame.switchToFrameByName("frame-bottom")
                .verifyFrameByTitle("BOTTOM");
    }
}

