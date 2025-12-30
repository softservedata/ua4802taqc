package com.softserve.edu6po.pages;

import com.softserve.edu6po.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {
    private final String VALUE_ATTRIBUTE = "value";

    protected WebDriver driver;
    //
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signinButton;
    private WebElement closeFormButton;

    public SigninPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        emailField = driver.findElement(By.id("email"));
        passwordField = driver.findElement(By.id("password"));
        signinButton = driver.findElement(By.cssSelector("button[type='submit']"));
        closeFormButton = driver.findElement(By.cssSelector("a.close-modal-window"));
    }

    // PageObject Atomic Operation

    // emailField
    public WebElement getEmailField() {
        return emailField; // Classic Page Object
    }

    public String getEmailFieldText() {
        return getEmailField().getDomProperty(VALUE_ATTRIBUTE);
    }

    public void clickEmailField() {
        getEmailField().click();
    }

    public void clearEmailField() {
        getEmailField().clear();
    }

    public void sendKeysEmailField(String email) {
        getEmailField().sendKeys(email);
    }

    // passwordField
    public WebElement getPasswordField() {
        return passwordField; // Classic Page Object
    }

    public String getPasswordFieldText() {
        return getPasswordField().getDomProperty(VALUE_ATTRIBUTE);
    }

    public void clickPasswordField() {
        getPasswordField().click();
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }

    public void sendKeysPasswordField(String password) {
        getPasswordField().sendKeys(password);
    }

    // signinButton
    public WebElement getSigninButton() {
        return signinButton; // Classic Page Object
    }

    public String getSigninButtonText() {
        return getSigninButton().getText().trim();
    }

    public void clickSigninButton() {
        getSigninButton().click();
    }

    // closeFormButton
    public WebElement getCloseFormButton() {
        return closeFormButton; // Classic Page Object
    }

    public void clickCloseFormButton() {
        getCloseFormButton().click();
    }

    // PageObject Functional Operation

    private void typeEmail(String email) {
        clickEmailField();
        clearEmailField();
        sendKeysEmailField(email);
    }

    private void typePassword(String password) {
        clickPasswordField();
        clearPasswordField();
        sendKeysPasswordField(password);
    }

    private void enterCredention(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickSigninButton();
    }

    // PageObject Business Operation

    //public HomeUbsPage loginUbs(String email, String password) {
    //    return loginUbs(new User(email, password, ""));
    //}

    public HomeUbsPage loginUbs(String email, String password) {
    //public HomeUbsPage loginUbs(User user) {
        enterCredention(email, password);
        return new HomeUbsPage(driver);
    }

    public HomeUbsPage loginUbs(User validUser) {
        enterCredention(validUser.getEmail(), validUser.getPassword());
        return new HomeUbsPage(driver);
    }

    public HomeGreencityPage loginGreencity(String email, String password) {
        //public HomeGreencityPage loginGreencity(User user) {
        enterCredention(email, password);
        return new HomeGreencityPage(driver);
    }

    public HomeGreencityPage loginGreencity(User validUser) {
        enterCredention(validUser.getEmail(), validUser.getPassword());
        return new HomeGreencityPage(driver);
    }

    //public SigninPage invalidLogin(User invalidUser) {
    public UnsuccessfulSigninPage invalidLogin(String invalidEmail, String invalidPassword) {
        enterCredention(invalidEmail, invalidPassword);
        return new UnsuccessfulSigninPage(driver);
    }

    public UnsuccessfulSigninPage invalidLogin(User invalidUser) {
        enterCredention(invalidUser.getEmail(), invalidUser.getPassword());
        return new UnsuccessfulSigninPage(driver);
    }

}
