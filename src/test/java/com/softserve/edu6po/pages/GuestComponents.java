package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestComponents {

    protected WebDriver driver;
    //
    private WebElement signinlink;
    private WebElement signuplink;

    public GuestComponents(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        signinlink = driver.findElement(By.cssSelector("a[class*='sign-in']"));
        signuplink = driver.findElement(By.cssSelector("div[class*='sign-up']"));
    }

    // PageObject Atomic Operation

    // signinlink
    public WebElement getSigninlink() {
        return signinlink; // Classic Page Object
        //return driver.findElement(By.cssSelector("p.main-header")); // Lazy initialization
    }

    public String getSigninlinkText() {
        return getSigninlink().getText().trim();
    }

    public void clickSigninlink() {
        getSigninlink().click();
    }

    // signuplink
    public WebElement getSignuplink() {
        return signuplink; // Classic Page Object
        //return driver.findElement(By.cssSelector("p.main-header")); // Lazy initialization
    }

    public String getSignuplinkText() {
        return getSignuplink().getText().trim();
    }

    public void clickSignuplink() {
        getSignuplink().click();
    }


    // PageObject Functional Operation

    // PageObject Business Operation

}
