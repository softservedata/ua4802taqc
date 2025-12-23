package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutusPage extends GreencityMenuPart {

    private WebElement aboutusLabel;

    public AboutusPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        aboutusLabel = driver.findElement(By.cssSelector("div.about-section.section h2.section__header"));
    }

    // PageObject Atomic Operation

    // homeHeader
    public WebElement getAboutusLabel() {
        return aboutusLabel; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String getAboutusLabelText() {
        return getAboutusLabel().getText().trim();
    }

    public void clickAboutusLabel() {
        getAboutusLabel().click();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

    public AboutusPage switchToEnglishLanguage() {
        chooseEnglishLanguage();
        return new AboutusPage(driver);
    }

    public AboutusPage switchToUkrainianLanguage() {
        chooseUkrainianLanguage();
        return new AboutusPage(driver);
    }
}
