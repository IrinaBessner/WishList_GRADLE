package com.wishlist.tests.gift;

import com.wishlist.models.User;
import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.wishlist.data.GiftData.GIFT_FOR_LENA;
import static com.wishlist.data.UserData.*;
import static com.wishlist.data.WishListData.WISHLIST_BIRTHDAY_DATA;

public class DeleteGiftFromWishListPositiveTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        aboutUsPage = new AboutUsPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        giftPage = new GiftPage(app.driver);
        wishListContentPage = new WishListContentPage(app.driver);

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
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm(WISHLIST_BIRTHDAY_DATA)
                .clickSaveButton();
        accountPage
                .clickOnAddGiftButton();
        giftPage
                .fillGiftform(GIFT_FOR_LENA)
                .clickSaveButton();
    }

    @Test
    private void deleteGiftFromWishList() {
        wishListContentPage
                .chooseDelete()
                .verifyShare();
    }

    @AfterMethod
    public void postcondition() {
        wishListContentPage.clickOnGoToWishLists();
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}
