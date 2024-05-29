package com.wishlist.tests.login;

import com.wishlist.models.User;
import com.wishlist.pages.AccountPage;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.*;

import static com.wishlist.data.UserData.*;
public class LoginAuthUserNegativeTests extends TestBase {

    @BeforeMethod

    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        accountPage = new AccountPage(app.driver);

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
                .clickOnLogOutLinkAccount();
        homePage
                .clickOnLogInLink();
    }
    // No any errorMessage for empty fields. Verify page is not changed
    @Test
    public void loginWithoutPasswordNegativeTest() {
        loginPage
                .enterPersonalData(USER_DUDKINA_WITHOUT_PASSWORD)
                .clickOnLogInButton();
        loginPage.verifyLoginForm("Log In");
    }

    @Test
    public void loginWithoutEmaildNegativeTest() {
        loginPage
                .enterPersonalData(USER_DUDKINA_WITHOUT_EMAIL)
                .clickOnLogInButton();
        loginPage.verifyLoginForm("Log In");
    }

    @Test
    public void loginWithInvalidEmaildNegativeTest() {
        loginPage
                .enterPersonalData(USER_DUDKINA_INVALID_EMAIL)
                .clickOnLogInButton();
        loginPage.verifyLoginForm("Log In");
    }

    @Test
    public void loginWithWrongPasswordNegativeTest() {
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN_WRONG_PASSWORD)
                .clickOnLogInButton();
        loginPage.verifyErrorMessage("Invalid");
    }

  @AfterMethod(enabled = true)

    public void postcondition() {
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}
