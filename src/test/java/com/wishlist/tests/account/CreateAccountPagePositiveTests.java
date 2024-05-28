package com.wishlist.tests.account;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.*;

import static com.wishlist.data.UserData.*;

public class CreateAccountPagePositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        signupPage = new SignUpPage(app.driver);

        if (!homePage.logInLinkPresent()) {
            homePage.clickOnLogOutLink();
            homePage.clickOnSignUpLink();
        } else {
            homePage.clickOnSignUpLink();
        }
    }

    @Test
    public void fillRegistrationForm() {
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
//        Random random = new Random();
//        int i = random.nextInt(1000) + 1000;
//        signupPage
//                .enterPersonalData("Lena", "Dudkina", "dudkina" + i + "@web.de", "Berlin2024!")
//                .clickOnSignUpButtonRegistr();
//                accountPage-.                        .verifyAccountPage("Create WishList");
