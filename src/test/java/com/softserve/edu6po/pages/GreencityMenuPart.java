package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class GreencityMenuPart extends LanguagePart {

    private WebElement greencityLogo;
    private WebElement ecoNewsLink;
    private WebElement eventsLink;
    private WebElement aboutusLink;
    private WebElement mySpaceLink;
    private WebElement ubsCourierLink;

    public GreencityMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        greencityLogo = driver.findElement(By.cssSelector("a.header_logo"));
        ecoNewsLink = driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']"));
        eventsLink = driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/events']"));
        aboutusLink = driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/about']"));
        mySpaceLink = driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/profile']"));
        ubsCourierLink = driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/ubs']"));
    }

    // PageObject Atomic Operation

    // greencityLogo
    public WebElement getGreencityLogo() {
        return greencityLogo; // Classic Page Object
        //return driver.findElement(By.cssSelector("a.header_logo"));
    }

    public void  clickGreencityLogo() {
        getGreencityLogo().click();
    }

    // ecoNewsLink
    public WebElement getEcoNewsLink() {
        return ecoNewsLink; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String  getEcoNewsLinkText() {
        return getEcoNewsLink().getText().trim();
    }

    public void  clickEcoNewsLink() {
        getEcoNewsLink().click();
    }

    // eventsLink
    public WebElement getEventsLink() {
        return eventsLink; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String getEventsLinkText() {
        return getEventsLink().getText().trim();
    }

    public void clickEventsLink() {
        getEventsLink().click();
    }

    // aboutusLink
    public WebElement getAboutusLink() {
        return aboutusLink; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String getAboutusLinkText() {
        return getAboutusLink().getText().trim();
    }

    public void clickAboutusLink() {
        getAboutusLink().click();
    }

    // mySpace

    public WebElement getMySpaceLink() {
        return mySpaceLink; // Classic Page Object
    }

    public String getMySpaceLinkText() {
        return getMySpaceLink().getText().trim();
    }

    public void clickMySpaceLink() {
        getMySpaceLink().click();
    }

    // ubsCourier
    public WebElement getUbsCourierLink() {
        return ubsCourierLink; // Classic Page Object
        //return driver.findElement(By.cssSelector("div.header_navigation-menu a[href*='/news']")); // Lazy initialization
    }

    public String getUbsCourierLinkText() {
        return getUbsCourierLink().getText().trim();
    }

    public void clickUbsCourierLink() {
        getUbsCourierLink().click();
    }

    // PageObject Functional Operation

    // PageObject Business Operation

    public HomeGreencityPage gotoHomeGreencityPage() {
        clickGreencityLogo();
        return new HomeGreencityPage(driver);
    }

    public EcoNewsPage gotoEcoNewsPage() {
        clickEcoNewsLink();
        return new EcoNewsPage(driver);
    }

    public EventsPage gotoEventsPage() {
        clickEventsLink();
        return new EventsPage(driver);
    }

    public AboutusPage gotoAboutusPage() {
        clickAboutusLink();
        return new AboutusPage(driver);
    }

    public MySpacePage gotoMySpacePage() {
        clickMySpaceLink();
        return new MySpacePage(driver);
    }

    public HomeUbsPage gotoHomeUbsPage() {
        clickUbsCourierLink();
        return new HomeUbsPage(driver);
    }

}
