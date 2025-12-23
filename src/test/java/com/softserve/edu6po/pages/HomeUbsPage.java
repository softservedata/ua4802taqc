package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeUbsPage extends UbsMenuPart {

    private WebElement orderButton;

    public HomeUbsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        orderButton = driver.findElement(By.cssSelector("div.main-content > button"));
    }

    // PageObject Atomic Operation

    // order
    public WebElement getOrderButton() {
        return orderButton; // Classic Page Object
    }

    public String  getOrderButtonText() {
        return getOrderButton().getText().trim();
    }

    public void  clickOrderButton() {
        getOrderButton().click();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

    public HomeUbsPage switchToEnglishLanguage() {
        chooseEnglishLanguage();
        return new HomeUbsPage(driver);
    }

    public HomeUbsPage switchToUkrainianLanguage() {
        chooseUkrainianLanguage();
        return new HomeUbsPage(driver);
    }

    public HomeUbsPage signoutUser() {
        clickSignoutLink();
        return new HomeUbsPage(driver);
    }
}
