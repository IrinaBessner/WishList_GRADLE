package com.wishlist.pages;

import com.wishlist.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import static com.wishlist.pages.ApplicationManager.app;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement yourname;
    @FindBy(id = "last-name")
    WebElement yourlastname;
    @FindBy(id = "email")
    WebElement youremail;
    @FindBy(id = "password")
    WebElement yourpass;
    @FindBy(id = "confirm-password")
    WebElement confirmyourmpass;
    // @FindBy(xpath = "//button[.='Sign Up']")
   //  WebElement signUpButton;
    @FindBy(css = ".input-group:nth-child(4) svg")
    WebElement eye;

    public SignUpPage enterPersonalData(String name, String secondname, String email, String password, String confpass) {
        type(yourname, name);
        type(yourlastname, secondname);
        type(youremail, email);
        type(yourpass, password);
        type(confirmyourmpass, password);
        return new SignUpPage(driver);
    }

    public SignUpPage enterPersonalData(User user) {
        type(yourname, user.name);
        type(yourlastname, user.secondName);
        type(youremail, user.email);
        type(yourpass, user.password);
        type(confirmyourmpass, user.password);
        return new SignUpPage(driver);
    }

    @FindBy(css = ".save-button")
    WebElement signUpButton;

    public SignUpPage clickOnSignUpButton() {
        click(signUpButton);
        return new SignUpPage(driver);
    }

    public SignUpPage clickAlert() {
        clickAlert(signUpButton);
        return this;
    }

//    public SignUpPage enterPersonalDataOhneAlert(String name, String secondname, String email, String password, String confpass) {
//        type (yourname,name);
//        type(yourlastname, secondname);
//        type(youremail, email);
//        type(yourpass, password);
//        type(confirmyourmpass, password);
//        click(signUpButton);
//
//        return new SignUpPage(driver);
//    }


    @FindBy(css = ".error-message")
    WebElement error;

    public SignUpPage verifyErrorMessage(String text) {
        scrollToTopWithJS();
        Assert.assertTrue(error.getText().contains(text));
        return this;

    }

    @FindBy(css = "h2")
    WebElement verifySignUpButton;

    public SignUpPage verifySignUpButton(String text) {
        Assert.assertTrue(verifySignUpButton.getText().contains(text));
        return this;
    }

    @FindBy(css = "li:nth-child(3)")
    WebElement logInLink;

    public SignUpPage clickOnLogInLink() {
        click(logInLink);
        return new SignUpPage(driver);
    }

    @FindBy(xpath = "//p/a[.='Log In']")
    WebElement loginLinkDownForm;

    public SignUpPage clickOnLogInLinkFormDownWithJS() {
        clickWithJS(loginLinkDownForm, 0, 1000);
        return new SignUpPage(driver);
    }

    @FindBy(xpath = "//a[.='GiftListify']")
    WebElement clickOnLogo;

    public AccountPage clickOnLogo() {
        click(clickOnLogo);
        return new AccountPage(driver);
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.driver.quit();
    }
}
