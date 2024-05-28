package com.wishlist.tests.login;

import com.wishlist.fw.DataProviderClass;
import com.wishlist.models.User;
import com.wishlist.pages.HomePage;
import com.wishlist.pages.LoginPage;
import com.wishlist.pages.SignUpPage;
import com.wishlist.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static com.wishlist.data.UserData.*;
import static com.wishlist.pages.ApplicationManager.app;

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
                .enterPersonalData(USER_DUDKINA_LOGIN)
                .clickOnLogInButton();
        loginPage.verifyErrorMessage("Invalid");
    }


//    @Test(dataProvider = "iNvalidLoginData", dataProviderClass = DataProviderClass.class)
//    public void fillLogInWithCsvFileNegative(User user) {
//        WebDriver driver;
//
//        new LoginPage(app.driver)
//                .enterPersonalData(user.getEmail(), user.getPassword())
//                .clickOnLogInButton();
//                loginPage.verifyErrorMessage("Error");
//    }

    @Test(dataProvider = "LoginInValidData", dataProviderClass = DataProviderClass.class)
    public void fillLogInWithCsvFileNegative(User user) {
        new LoginPage(app.driver)
                .enterPersonalData(user)
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
