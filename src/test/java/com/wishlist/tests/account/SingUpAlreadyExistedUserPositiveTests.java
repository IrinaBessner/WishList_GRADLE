package com.wishlist.tests.account;

import com.wishlist.fw.DataProviderClass;
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

public class SingUpAlreadyExistedUserPositiveTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        signupPage = new SignUpPage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);

        homePage.clickOnSignUpLink();
        signupPage
                .enterPersonalData(USER_DUDKINA_SIGNUP)
                .clickOnSignUpButton()
                .clickAlert();
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        accountPage
                .clickOnLogOutLinkAccount();
    }

    @Test
    public void signUpAlreadyRegisteredUserTest() {
        homePage.clickOnSignUpLink();
        signupPage
                .enterPersonalData(USER_DUDKINA_SIGNUP)
                .clickOnSignUpButton()
                .verifyErrorMessage("exists");
    }

    @Test(dataProvider = "inValidEmailSignUpData", dataProviderClass = DataProviderClass.class)
    public void fillSignUpWithCsvFileNegative(User user) {
        new HomePage(app.driver).clickOnSignUpLink();
        new SignUpPage(app.driver)
                .enterPersonalData(user)
                .clickOnSignUpButton()
                .verifySignUpButton("Sign Up");

    }

    @AfterMethod(enabled = true)
    public void postcondition() {
        signupPage.clickOnLogInLinkFormDownWithJS();
        loginPage
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        accountPage.selectDeleteAccountButton();
        homePage.isHomePagePresent();
        tearDown();
    }
}
