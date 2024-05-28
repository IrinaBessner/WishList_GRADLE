package com.wishlist.tests.login;

import com.wishlist.models.User;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.wishlist.data.UserData.*;
public class LogInNotAuthUserNegativeTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        signupPage = new SignUpPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
            homePage.clickOnLogInLink();
        } else {
            homePage.clickOnLogInLink();
        }
    }
    // Проверка, что незарегистрированный пользователь c валидным email НЕ может залогиниться
    @Test
    public void loginWithValidEmailNegativeTest() {
        loginPage
                .enterPersonalData(USER_DUDKINA_SIGNUP)
                .clickOnLogInButton();
        loginPage.verifyErrorMessage("Invalid");
    }

    @AfterMethod(enabled = true)
    public void postcondition() {
        loginPage.clickOnHomeLink();
        homePage.isHomePagePresent();
        tearDown();

    }
}

//    @Test(dataProvider = "iNvalidLoginData", dataProviderClass = DataProviderClass.class)
//    public void fillLogInWithCsvFileNegative(UserLogin user) {
//        new LoginPage(driver)
//                .enterPersonalData(user.getEmail(), user.getPassword())
//                .clickOnLogInButtonWithJs()
//                .verifyErrorMessage("Error");
//    }
//
//    @Test(dataProvider = "validLoginData", dataProviderClass = DataProviderClass.class)
//    public void fillLogInWithCsvFilePositive(String validEmail, String validPassword) {
//        new LoginPage(driver)
//                .enterPersonalData(validEmail, validPassword)
//                .clickOnLogInButtonWithJs()
//                .verifyErrorMessage("Error");
//    }


