package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulSigninPage extends SigninPage {
    //
    public static final String BAD_EMAIL_PASSWORD = "Bad email or password";

    private WebElement alertErrorLabel;

    public UnsuccessfulSigninPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertErrorLabel = driver.findElement(By.cssSelector("div.alert-general-error"));
    }

    // PageObject Atomic Operation

    // alertErrorLabel
    public WebElement getAlertErrorLabel() {
        return alertErrorLabel; // Classic Page Object
     }

    public String getAlertErrorLabelText() {
        return getAlertErrorLabel().getText().trim();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

}
