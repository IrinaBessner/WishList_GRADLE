package com.wishlist.tests.gift;

import com.wishlist.data.WishListData;
import com.wishlist.models.User;
import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.wishlist.data.GiftData.GIFT_FOR_LENA;
import static com.wishlist.data.UserData.*;
import static com.wishlist.data.WishListData.WISHLIST_BIRTHDAY_DATA;

public class AddGiftToWishListPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        giftPage = new GiftPage(app.driver);
        wishListContentPage=new WishListContentPage(app.driver);

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
    }

    @Test
    private void addGiftToExistedWishListTest() throws InterruptedException {
        accountPage
                .clickOnAddGiftButton();
        giftPage
                .fillGiftform(GIFT_FOR_LENA);                                 // "https://butik-duhov.ru/parfjumerija/originaly/25198-1/"
        Thread.sleep(3000);
        giftPage.clickSaveButton();
//        Thread.sleep(5000);

        wishListContentPage.verifyShare();
    }

    @AfterMethod(enabled = true)
    public void postcondition() {
        wishListContentPage.clickOnGoToWishLists();
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}
