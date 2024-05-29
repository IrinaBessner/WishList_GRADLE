package com.wishlist.pages;

import com.wishlist.models.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    //@FindBy(css="input:nth-child(2)")
    //@FindBy(xpath = "//input[@type='email']")
    WebElement useremailloc;
    @FindBy(id = "password")
    //@FindBy(xpath = "//input[@type='password']")
    WebElement userpassword;
    @FindBy(css = ".eye-icon")
    WebElement eye;

    public LoginPage enterPersonalData(String email, String password) {
        scrollToUpWithJS();
        pause(1000);
        type(useremailloc, email);
        type(userpassword, password);
        return new LoginPage(driver);
    }
    public LoginPage enterPersonalData(User user) {
//        scrollToUpWithJS();
        type(useremailloc , user.email);
        type(userpassword, user.password);
        return new LoginPage(driver);
    }

    public LoginPage enterEmail(String email) {
        scrollToUpWithJS();
        pause(1000);
        type(useremailloc, email);
        return this;
    }

    public LoginPage togglePasswordVisibility() {
        click(eye);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.attributeToBe(userpassword, "type", "text"));
        return this;
    }

    public LoginPage enterPasswordAndHideWithEnter(String password) {
        togglePasswordVisibility();
        userpassword.clear();
        userpassword.sendKeys(password);
        userpassword.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(css = ".save-button")
    WebElement logInButton;

    public void clickOnLogInButton() {
        clickWithJS(logInButton, 0, 50);
    }

    @FindBy(xpath = "//a[.='Home']")
    WebElement linkHome;

    public LoginPage clickOnHomeLink() {
        click(linkHome);
        return new LoginPage(driver);
    }

    @FindBy(css = ".error-message")
    WebElement error;

    public LoginPage verifyErrorMessage(String text) {
        Assert.assertTrue(error.getText().contains(text));
        return this;
    }

    @FindBy(css = "[href='/signup']")
    WebElement signUpLink;

    public LoginPage clickOnSignUpLink() {
        clickWithJS(signUpLink, 0, 300);
        return new LoginPage(driver);
    }

    public void scrollToUpWithJS() {
        js.executeScript("window.scrollTo(0, 0)");
    }

    @FindBy(css = "h2")
    WebElement loginContainer;

    public LoginPage verifyLoginForm(String text) {
        Assert.assertTrue(loginContainer.getText().contains(text));
        return this;
    }
}
