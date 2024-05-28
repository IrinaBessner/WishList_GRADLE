package com.wishlist.tests;

import com.wishlist.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.lang.reflect.Method;
import java.time.Duration;

import static jdk.internal.org.objectweb.asm.commons.Method.getMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager("chrome");
   Logger logger=LoggerFactory.getLogger(TestBase.class);
    public WebDriver driver;

    public HomePage homePage;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public SignUpPage signupPage;
    public AboutUsPage aboutUsPage;
    public PrivacyPolicyPage privacyPolicyPage;
    public WishListPage wishListPage;

    public GiftPage giftPage;
    public WishListContentPage wishListContentPage;

    @BeforeSuite
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        app = new ApplicationManager(browser);
        driver = app.getDriver();
        app.init();
        WebDriverWait wait = new WebDriverWait(app.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
    }

    @AfterSuite
    public void tearDown() {
        if (app != null && app.driver != null) {
            app.driver.quit();
        }
    }

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Start test: " + method.getName());
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome");
            app = new ApplicationManager(browser);
            driver = app.getDriver();
            app.init();
        }
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("-----------------------------------------------------------");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

//    //@BeforeMethod
//    @BeforeSuite
//    public void setUp(Method method) {
//       logger.info("Start test" + method.getName());
//
//        String browser = System.getProperty("browser", "chrome");
//        app = new ApplicationManager(browser);
//        driver = app.getDriver();
//        app.init();
//        WebDriverWait wait = new WebDriverWait(app.driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
//
//        // app = new ApplicationManager(Browser.CHROME.browserName());
//        // app.init();
//
//        //driver = new ChromeDriver();
//        //driver.get("http://localhost:3000/");
//        //driver.manage().window().maximize();
//        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//    @AfterSuite
//   // @AfterMethod(enabled = true)
//    public void tearDown() {
//        app.driver.quit();
//    }
//
////    @BeforeMethod
////    public void startTest(Method method){
////        logger.info("Start test" + method.getName());
////    }
//
//    @AfterMethod
//    public void stopTest(ITestResult result){
//        if(result.isSuccess()) {
//            logger.info("PASSED" +result.getMethod().getMethodName());
//        }else{
//
//            logger.error("FAILED" + result.getMethod().getMethodName()+ "Screenshot: "
//                    + app.getUser.takeScreenshot());
//        }
//        logger.info("Stop test");
//        logger.info("-----------------------------------------------------------");
//
//    if (driver != null) {
//        driver.quit();
//        driver = null;
//    }
//
//}



