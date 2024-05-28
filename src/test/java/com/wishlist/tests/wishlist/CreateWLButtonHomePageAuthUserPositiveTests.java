package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.wishlist.data.UserData.*;
import static com.wishlist.data.WishListData.WISHLIST_BIRTHDAY_DATA;

public class CreateWLButtonHomePageAuthUserPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        signupPage = new SignUpPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
            homePage.clickOnSignUpLink();
        } else {
            homePage.clickOnSignUpLink();
        }
        signupPage
                .enterPersonalData(USER_DUDKINA_SIGNUP)
                .clickOnSignUpButton()
                .clickAlert();
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        accountPage.clickOnLogOutLinkAccount();
        homePage.clickOnButtonCreateNewWishList();
    }

    @Test
    public void clickOnCreateNewWishList() throws InterruptedException {
        loginPage.enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm(WISHLIST_BIRTHDAY_DATA)
                .clickSaveButton();
        Thread.sleep(1500);
        accountPage
                .verifyCardOfWishList();
    }

    @AfterMethod(enabled = true)
    public void postcondition() {
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}


