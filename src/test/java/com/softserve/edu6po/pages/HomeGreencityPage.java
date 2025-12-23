package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeGreencityPage extends GreencityMenuPart {

    private WebElement homeHeaderLabel;

    public HomeGreencityPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        homeHeaderLabel = driver.findElement(By.cssSelector("div#main-content h1"));
    }

    // PageObject Atomic Operation

    // homeHeader
    public WebElement getHomeHeaderLabel() {
        return homeHeaderLabel; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String getHomeHeaderLabelText() {
        return getHomeHeaderLabel().getText().trim();
    }

    public void clickHomeHeaderLabel() {
        getHomeHeaderLabel().click();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

    public HomeGreencityPage switchToEnglishLanguage() {
        chooseEnglishLanguage();
        return new HomeGreencityPage(driver);
    }

    public HomeGreencityPage switchToUkrainianLanguage() {
        chooseUkrainianLanguage();
        return new HomeGreencityPage(driver);
    }

    public HomeGreencityPage signoutUser() {
        clickSignoutLink();
        return new HomeGreencityPage(driver);
    }
}
