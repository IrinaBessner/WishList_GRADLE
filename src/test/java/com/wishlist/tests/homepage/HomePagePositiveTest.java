package com.wishlist.tests.homepage;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePagePositiveTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        aboutUsPage = new AboutUsPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        privacyPolicyPage = new PrivacyPolicyPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
        }
    }

    @Test
    public void clickOnAboutUsLinkTest() {
        homePage
                .clickOnAboutUsLink();
        aboutUsPage
                .verifyAboutUs("convenient");
    }

    @Test
    public void clickOnLogInLink() {
        homePage
                .clickOnLogInLink();
        loginPage
                .verifyLoginForm("Log In");
    }

    @Test
    public void clickOnSignUpLink() {
        homePage
                .clickOnSignUpLink();
        signupPage
                .verifySignUpButton("Sign Up");
    }

    @Test
    public void clickOnCreateNewWishList() {
        homePage
                .clickOnButtonCreateNewWishList();
        loginPage
                .verifyLoginForm("Log In");
    }

    @Test
    public void clickOnIwantWishListButton() {
        homePage
                .clickIwantWishListButtonWithJS();
        loginPage
                .verifyLoginForm("Log In");
    }

    @Test
    public void cliclOnPrivacyPolicyTest() {
        homePage
                .clickOnPrivacyPolicyLink();
        privacyPolicyPage
                .verifyPolicy("PrivacyPolicy");
    }

    @Test
    public void clickOnGitHubButtonTest() {
        homePage
                .clickOnGitHubButton();
    }

    @AfterMethod
    public void postcondition() {
        tearDown();
    }
}
