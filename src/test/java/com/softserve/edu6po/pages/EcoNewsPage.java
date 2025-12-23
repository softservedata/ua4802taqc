package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EcoNewsPage extends GreencityMenuPart {

    private WebElement ecoNewsLabel;

    public EcoNewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        ecoNewsLabel = driver.findElement(By.cssSelector("h1.main-header"));
    }

    // PageObject Atomic Operation

    // homeHeader
    public WebElement getEcoNewsLabel() {
        return ecoNewsLabel; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String getEcoNewsLabelText() {
        return getEcoNewsLabel().getText().trim();
    }

    public void clickEcoNewsLabel() {
        getEcoNewsLabel().click();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

    public EcoNewsPage switchToEnglishLanguage() {
        chooseEnglishLanguage();
        return new EcoNewsPage(driver);
    }

    public EcoNewsPage switchToUkrainianLanguage() {
        chooseUkrainianLanguage();
        return new EcoNewsPage(driver);
    }
}
