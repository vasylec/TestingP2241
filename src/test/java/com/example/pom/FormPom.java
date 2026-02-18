package com.example.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPom {
    static public WebDriver driver;

    @FindBy(xpath = "//*[text()='Forms']")
    WebElement forms;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div/ul/li/a/span")
    WebElement practiceForms;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    WebElement email;

    public FormPom(WebDriver driverParam) {
        driver = driverParam;
        PageFactory.initElements(driver, this);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void clickForms() {
        scrollToElement(forms);
        forms.click();
    }

    public void clickPracticeForms() {
        scrollToElement(practiceForms);
        practiceForms.click();
    }

    public void setFirstName(String firstNameParam) {
        scrollToElement(firstName);
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }

    public void setLastName(String lastNameParams) {
        scrollToElement(lastName);
        lastName.clear();
        lastName.sendKeys(lastNameParams);
    }

    public void setEmail(String userEmailParams) {
        scrollToElement(email);
        email.clear();
        email.sendKeys(userEmailParams);
    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
