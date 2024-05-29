package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.wishlist.data.UserData.USER_DUDKINA_LOGIN;
import static com.wishlist.data.UserData.USER_DUDKINA_SIGNUP;
import static com.wishlist.data.WishListData.WISHLIST_BIRTHDAY_DATA;

public class CreateWLiWantButtonHomePageNOTAuthUserPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        wishListPage = new WishListPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
            homePage.clickIwantWishListButtonWithJS();
        } else {
            homePage.clickIwantWishListButtonWithJS();
        }

        loginPage.enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnSignUpLink();
        signupPage
                .enterPersonalData(USER_DUDKINA_SIGNUP)
                .clickOnSignUpButton()
                .clickAlert();
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
    }

    @Test
    public void clickOnIWantWishListButtonTest() throws InterruptedException {
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm(WISHLIST_BIRTHDAY_DATA)
                .clickSaveButton();
        Thread.sleep(1500);
        accountPage
                .verifyCardOfWishList();
    }

    @AfterMethod
    public void postcondition() {
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}
