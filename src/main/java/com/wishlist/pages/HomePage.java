package com.wishlist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/about']")
    WebElement aboutUsLink;

    public HomePage clickOnAboutUsLink() {
        click(aboutUsLink);
        return new HomePage(driver);
    }

//    @FindBy(css = "ul.nav-list :nth-child(3)")
    @FindBy(xpath = "//a[.='Log In']")
    WebElement logInLink;

    public HomePage clickOnLogInLink() {
        click(logInLink);
//        safeClick(logInLink);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
////        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/dashboard"));
//        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));

        return new HomePage(driver);
    }

    @FindBy(css = "ul.nav-list :nth-child(3)")
    //@FindBy(xpath = "//a[.='Log In']")
    WebElement linkLogin;

    public boolean logInLinkPresent() {
        linkLogin.isDisplayed();
        return true;
    }

    @FindBy(xpath = "//button[.='Log In']")
    WebElement logInResult;

    public HomePage verifyLogInButton(String text) {
        Assert.assertTrue(logInResult.getText().contains(text));
        return this;
    }

    //@FindBy(css = "ul.nav-list :nth-child(4)")
    @FindBy(xpath = "//a[.='Sign Up']")
    WebElement signUp;

    public HomePage clickOnSignUpLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(signUp));
        click(signUp);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//button[.='Sign Up']")
    WebElement signUpresult;

    public HomePage verifySignUpButton(String text) {
        Assert.assertTrue(signUpresult.getText().contains(text));
        return this;
    }

    @FindBy(css = ".create_list_button")
    WebElement saveWishList;

    public HomePage clickOnButtonCreateNewWishList() {
        clickWithJS(saveWishList, 0, 500);
        return new HomePage(driver);
    }

    @FindBy(css = ".save-button-custom")
    WebElement save;

    public HomePage verifySaveButton(String text) {
        Assert.assertTrue(save.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//button[text()='I want a Wishlist']")
    WebElement iWantbutton;

    public HomePage clickIwantWishListButtonWithJS() {
        clickWithJS(iWantbutton, 0, 900);
        return new HomePage(driver);
    }

    @FindBy(css = "[href='/privacy-policy']")
    WebElement privacyPolicyLink;

    public HomePage clickOnPrivacyPolicyLink() {
        clickWithJS(privacyPolicyLink, 0, 500);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//span[.='PrivacyPolicy']")
    WebElement textPolicy;

    public HomePage verifyPrivacyPolicy(String text) {
        Assert.assertTrue(textPolicy.getText().contains(text));
        return this;
    }

    @FindBy(css = "li:nth-child(3)")
    WebElement logOutLink;

    public HomePage clickOnLogOutLink() {
        click(logOutLink);
        return this;
    }

    @FindBy(css = ".header")
    WebElement image;

    public boolean isHeaderImagePresent() {
        return isElementPresent(image);
    }

    @FindBy(css = ".section")
    WebElement homePagesection;

    public boolean isHomePagePresent() {
        return isElementPresent(homePagesection);
    }

    @FindBy(css = "svg")
    WebElement svgAccount;

    public HomePage clickOnIconAccount() {
        click(svgAccount);
        return new HomePage(driver);
    }

    //@FindBy(css = "[href='https://github.com/ania0005/Wishlist-project']")
    @FindBy(css = "img[alt='Link']")
    WebElement gitHubButton;

    public HomePage clickOnGitHubButton() {
        clickWithJS(gitHubButton, 0, 3000);
        return new HomePage(driver);
    }
}

