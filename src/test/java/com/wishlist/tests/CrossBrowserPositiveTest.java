package com.wishlist.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class CrossBrowserPositiveTest  {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "C:/Tools/geckodriver.exe");
//            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:/Tools/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    @Test(enabled = true)
    public void crossBrowserTest() throws InterruptedException {

        String[] browsers = {"chrome", "edge"};
        for (String browser : browsers) {
            setup(browser);
            driver.get("http://localhost:3000/");
            Thread.sleep(2000); // Пауза в 2 секунды
        }
        teardown();
    }

    @AfterMethod(enabled = true)

    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
   }

}
