package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PrivacyPolicyPage extends BasePage {
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[contains(text(),'PrivacyPolicy')]")
    WebElement polisytitle;

    public PrivacyPolicyPage verifyPolicy(String text) {
        Assert.assertTrue(polisytitle.getText().contains("PrivacyPolicy"));
        return this;
    }
}






