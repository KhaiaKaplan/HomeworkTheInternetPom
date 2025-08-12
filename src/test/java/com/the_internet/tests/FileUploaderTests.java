package com.the_internet.tests;

import com.the_internet.core.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_internet.pages.alertsFrameWindows.HomePage;
import the_internet.pages.files.FileUploaderPage;


public class FileUploaderTests extends TestBase {

    HomePage homePage;
    FileUploaderPage fileUploader;



    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        fileUploader = new FileUploaderPage(driver);
        new HomePage(driver).selectFileUploader();
    }

    @Test
    public void uploadFileTest(){
        fileUploader.uploadFile("C:/Tools/Number-One.jpg")
                .clickUpload()
                .verifyNewTabTitle("File Uploaded!");

    }
}
