package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileComponent {

    protected WebDriver driver;
    //
    private WebElement personalAccountlink;
    private WebElement signoutlink;

    public ProfileComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        personalAccountlink = driver.findElement(By.cssSelector("ul.dropdown-list a[href*='/user/orders']"));
        signoutlink = driver.findElement(By.cssSelector("li[aria-label='sign-out']>a"));
    }

    // PageObject Atomic Operation

    // personalAccountlink
    public WebElement getPersonalAccountlink() {
        return personalAccountlink; // Classic Page Object
    }

    public String getPersonalAccountlinkText() {
        return getPersonalAccountlink().getText().trim();
    }

    public void clickPersonalAccountlink() {
        getPersonalAccountlink().click();
    }

    // signoutlink
    public WebElement getSignoutlink() {
        return signoutlink; // Classic Page Object
        //return driver.findElement(By.cssSelector("p.main-header")); // Lazy initialization
    }

    public String getSignoutlinkText() {
        return getSignoutlink().getText().trim();
    }

    public void clickSignoutlink() {
        getSignoutlink().click();
    }


    // PageObject Functional Operation

    // PageObject Business Operation

}
