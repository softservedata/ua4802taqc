package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UbsMenuPart extends LanguagePart {

    private WebElement aboutService;
    private WebElement sortingRules;
    private WebElement ecoShop;
    private WebElement greenCity;

    public UbsMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        aboutService = driver.findElement(By.cssSelector("ul a.pick-up-service"));
        sortingRules = driver.findElement(By.cssSelector("div.header_navigation-menu-ubs a[href*='/sort-station']"));
        ecoShop = driver.findElement(By.cssSelector("div.header_navigation-menu-ubs a[href*='/shop']"));
        greenCity = driver.findElement(By.cssSelector("div.header_navigation-menu-ubs a[href*='/greenCity']"));
    }

    // PageObject Atomic Operation

    // aboutService;
    public WebElement getAboutService() {
        return aboutService; // Classic Page Object
    }

    public String  getAboutServiceText() {
        return getAboutService().getText().trim();
    }

    public void  clickAboutService() {
        getAboutService().click();
    }

    // sortingRules;
    public WebElement getSortingRules() {
        return sortingRules; // Classic Page Object
    }

    public String  getSortingRulesText() {
        return getSortingRules().getText().trim();
    }

    public void  clickSortingRules() {
        getSortingRules().click();
    }

    // ecoShop;
    public WebElement getEcoShop() {
        return ecoShop; // Classic Page Object
    }

    public String  getEcoShopText() {
        return getEcoShop().getText().trim();
    }

    public void  clickEcoShop() {
        getEcoShop().click();
    }

    // greenCity;
    public WebElement getGreenCity() {
        return greenCity; // Classic Page Object
    }

    public String  getGreenCityText() {
        return getGreenCity().getText().trim();
    }

    public void  clickGreenCity() {
        getGreenCity().click();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

    public HomeGreencityPage gotoHomeGreencityPage() {
        clickGreenCity();
        return new HomeGreencityPage(driver);
    }

    public HomeUbsPage switchToEnglishLanguage() {
        chooseEnglishLanguage();
        return new HomeUbsPage(driver);
    }

    public HomeUbsPage switchToUkrainianLanguage() {
        chooseUkrainianLanguage();
        return new HomeUbsPage(driver);
    }
}
