package com.the_internet.tests;

import com.the_internet.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.pages.alertsFrameWindows.HomePage;
import the_internet.pages.dropdown.DropdownMenuPage;

public class DropdownMenuTests extends TestBase {

    HomePage homePage;
    DropdownMenuPage dropdownMenu;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        dropdownMenu = new DropdownMenuPage(driver);
        new HomePage(driver).selectDropdown();
    }

    @Test
    public void DropdownListTest(){
        dropdownMenu.dropdownListSelect("Option 1")
                .verifyOption();
    }
}
