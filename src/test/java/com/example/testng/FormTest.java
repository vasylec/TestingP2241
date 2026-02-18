package com.example.testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.pom.FormPom;
import com.example.utils.Driver;

public class FormTest {

    public static WebDriver driver;
    static public String URL = "https://demoqa.com/";

    static public String FIRST_NAME = "Cozma";
    static public String LAST_NAME = "Vasile";
    static public String EMAIL = "vcozma06@gmail.com";

    @BeforeMethod
    public void beforeMethod() {
        driver = Driver.getAutoLocalDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void formTest() {
        // demoqa.com
        System.out.println("---START TEST---");
        driver.get(URL);
        FormPom formPom = new FormPom(driver);

        formPom.pause(1000);

        formPom.clickForms();
        formPom.clickPracticeForms();
        formPom.setFirstName(FIRST_NAME);
        formPom.setLastName(LAST_NAME);
        formPom.setEmail(EMAIL);
        System.out.println("---FINISH TEST---");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
