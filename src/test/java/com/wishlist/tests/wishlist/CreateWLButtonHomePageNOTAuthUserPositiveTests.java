package com.wishlist.tests.wishlist;

import com.wishlist.models.User;
import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.wishlist.data.UserData.*;
public class CreateWLButtonHomePageNOTAuthUserPositiveTests extends TestBase {
    public User user;
    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        user = new User(app.driver);
        if (!homePage
                .logInLinkPresent()) {
            homePage
                    .clickOnSignUpLink();
            homePage
                    .clickOnButtonCreateNewWishList();
        } else {
            homePage
                    .clickOnButtonCreateNewWishList();
        }
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
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
    public void clickOnCreateNewWishList() throws InterruptedException {
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm("Birthday", "I have birthday soon", "15102025")
                .clickSaveButton();
        Thread.sleep(1500);
        accountPage
                .verifyCardOfWishList();
    }

    @AfterMethod(enabled = true)
    public void postcondition() {
        accountPage
                .selectDeleteAccountButton();
        homePage
                .isHomePagePresent();
        tearDown();
    }
}
