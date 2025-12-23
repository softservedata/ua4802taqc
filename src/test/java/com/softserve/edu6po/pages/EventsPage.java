package com.softserve.edu6po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventsPage extends GreencityMenuPart {

    private WebElement eventsLabel;

    public EventsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        eventsLabel = driver.findElement(By.cssSelector("p.main-header"));
    }

    // PageObject Atomic Operation

    // homeHeader
    public WebElement getEventsLabel() {
        return eventsLabel; // Classic Page Object
        //return driver.findElement(By.cssSelector("p.main-header")); // Lazy initialization
    }

    public String getEventsLabelText() {
        return getEventsLabel().getText().trim();
    }

    public void clickEventsLabel() {
        getEventsLabel().click();
    }
    // PageObject Functional Operation

    // PageObject Business Operation

    public EventsPage switchToEnglishLanguage() {
        chooseEnglishLanguage();
        return new EventsPage(driver);
    }

    public EventsPage switchToUkrainianLanguage() {
        chooseUkrainianLanguage();
        return new EventsPage(driver);
    }

}
