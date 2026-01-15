package com.softserve.edu6po.pages;

import com.softserve.edu6po.data.Languages;
import com.softserve.edu6po.tests.GreencityUbsClassicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LanguagePart {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected WebDriver driver;
    //
    private WebElement languageDropdown;
    //private GuestComponents guestComponents;
    //private WebElement userNameLabel;
    //private ProfileComponent profileComponent;

    public LanguagePart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        GreencityUbsClassicTest.presentationSleep(2);
        languageDropdown = driver.findElement(By.cssSelector("li.lang-option>span"));
     }

    // PageObject Atomic Operation

    // languageDropdown
    public WebElement getLanguageDropdown() {
        return languageDropdown; // Classic Page Object
        //return driver.findElement(By.cssSelector("li.lang-option>span"));
    }

    public String getLanguageDropdownText() {
        return getLanguageDropdown().getText().trim();
    }

    public void clickLanguageDropdown() {
        getLanguageDropdown().click();
    }

    // PageObject Functional Operation

    public boolean isEnglishEnable() {
        return getLanguageDropdownText().contains("E");
    }

    public boolean isUkrainianEnable() {
        return getLanguageDropdownText().contains("U");
    }

    // english
    public WebElement getEnglishLabel() {
        if (isUkrainianEnable()) {
            clickLanguageDropdown();
        }
        return driver.findElement(By.xpath("//ul[contains(@class, 'header_lang-switcher-wrp')]//span[contains(text(),'E')]"));
        //return english; // Classic Page Object
    }

    public String getEnglishLabelText() {
        return getEnglishLabel().getText().trim();
    }

    public void clickEnglishLabel() {
        getEnglishLabel().click();
    }

    // ukrainian
    public WebElement getUkrainianLabel() {
        if (isEnglishEnable()) {
            clickLanguageDropdown();
        }
        return driver.findElement(By.xpath("//ul[contains(@class, 'header_lang-switcher-wrp')]//span[contains(text(),'U')]"));
        //return ukrainian; // Classic Page Object
    }

    public String getUkrainianLabelText() {
        return getUkrainianLabel().getText().trim();
    }

    public void clickUkrainianLabel() {
        getUkrainianLabel().click();
    }

    protected void chooseEnglishLanguage() {
        if (isUkrainianEnable()) {
            clickEnglishLabel();
        }
    }

    protected void chooseUkrainianLanguage() {
        if (isEnglishEnable()) {
            clickUkrainianLabel();
        }
    }

    protected void chooseLanguage(Languages languages) {
        if (isEnglishEnable() && languages.getShortText().equals("u")) {
            clickUkrainianLabel();
        }
        if (isUkrainianEnable() && languages.getShortText().equals("e")) {
            clickEnglishLabel();
        }
    }

    // GuestComponents
    public GuestComponents createGuestComponents() {
        //guestComponents = new GuestComponents(driver);
        //return guestComponents;
        return new GuestComponents(driver);
    }

    // singnin
    public WebElement getSingnin() {
        return createGuestComponents().getSigninlink();
    }

    public void clickSingnin() {
        getSingnin().click();
    }

    // singnup
    public WebElement getSingnup() {
        return createGuestComponents().getSignuplink();
    }

    public String getSingnupText() {
        return getSingnup().getText().trim();
    }

    public void clickSingnup() {
        getSingnup().click();
    }

    // usernameLabel
    public WebElement getUsernameLabel() {
        return driver.findElement(By.cssSelector("li.body-2[class*='user-name']"));
    }

    public String getUsernameLabelText() {
        return getUsernameLabel().getText().trim();
    }

    public void clickUsernameLabel() {
        getUsernameLabel().click();
    }

    // profileComponent
    public ProfileComponent createProfileComponent() {
        clickUsernameLabel();
        return new ProfileComponent(driver);
    }

    // signout
    public WebElement getSignoutLink() {
        return createProfileComponent().getSignoutlink();
        // return driver.findElement(By.xpath("//li[@class='drop-down-item']/a[contains(text(),'Sign out')]"));
    }

    public String getSignoutLinkText() {
        return getSignoutLink().getText().trim();
    }

    public void clickSignoutLink() {
        getSignoutLink().click();
    }

    // PageObject Business Operation

    public SigninPage gotoSigninPage() {
        logger.debug("Start gotoSigninPage()");
        clickSingnin();
        return new SigninPage(driver);
    }

    public HomeUbsPage gotoSignoutUbs() {
        clickSignoutLink();
        return new HomeUbsPage(driver);
    }

    public HomeGreencityPage gotoSignoutGreencity() {
        clickSignoutLink();
        return new HomeGreencityPage(driver);
    }

}
