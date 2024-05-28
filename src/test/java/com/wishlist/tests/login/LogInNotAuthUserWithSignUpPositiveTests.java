package com.wishlist.tests.login;

import com.wishlist.models.User;
import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.wishlist.data.UserData.*;

public class LogInNotAuthUserWithSignUpPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        accountPage = new AccountPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
            homePage.clickOnLogInLink();
        } else {
            homePage.clickOnLogInLink();
        }
    }

    // Проверка, что незарегистрированный пользователь c валидным email логинится через регистрацию
    @Test
    public void fillLogInFormViaRegistrationForm() {

        loginPage.enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        loginPage.clickOnSignUpLink();

        signupPage
                .enterPersonalData(USER_DUDKINA_SIGNUP)
                .clickOnSignUpButton()
                .clickAlert();
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        accountPage
                .verifyAccountPage("Create WishList");
    }

    @AfterMethod(enabled = true)
    public void postcondition() {
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}
