package com.wishlist.pages;

import com.wishlist.models.Wishlist;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v125.fedcm.model.Account;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".create-wishlist-button-in-account")
    //@FindBy(xpath = "//a[contains(text(),'Create WishList')]")
    WebElement account;

    public AccountPage verifyAccountPage(String text) {
        Assert.assertTrue(account.getText().contains(text));
        return this;
    }

    @FindBy(css = ".create-wishlist-button-in-account")
    //@FindBy(xpath = "//a[contains(text(),'Create WishList')]")
    WebElement wishListButtonAccount;

    public AccountPage createWishListButton() {
        click(wishListButtonAccount);
        return new AccountPage(driver);
    }

    //@FindBy(css = "li:nth-child(3)")
    @FindBy(xpath = "//a[.='Log Out']")
    WebElement clickOnLogOutAcc;

    public AccountPage clickOnLogOutLinkAccount() {
        click(clickOnLogOutAcc);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        return  new AccountPage(driver);
    }
//    public AccountPage clickOnLogOutLinkAccount() {
//        clickOnLogOutAcc.click();
//        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/dashboard"));
//        return new AccountPage(driver);
//    }
//    public HomePage clickOnLogOutLinkAccount() {
//        clickOnLogOutAcc.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
//        return new HomePage(driver);
//    }


    @FindBy(css = "li:nth-child(1)")
    WebElement linkHome;

    public AccountPage clickOnHomeLinkAccount() {
        click(linkHome);
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//a[.='GiftListify']")
    WebElement clickOnLogo;

    public AccountPage clickOnLogo() {
        click(clickOnLogo);
        return new AccountPage(driver);
    }

    @FindBy(css = ".delete-button-in-account")
    WebElement clickDeleteButtonToDeleteAccount;
    @FindBy(css = ".delete-account-button")
    WebElement selectDeleteButton;

    public AccountPage selectDeleteAccountButton() {
        safeClick(clickDeleteButtonToDeleteAccount);
        click(selectDeleteButton);
        return new AccountPage(driver);
    }

    @FindBy(css = ".delete-button-in-account")
    WebElement verifyDelete;

    public AccountPage verifyDelete(String text) {
        Assert.assertTrue(verifyDelete.getText().contains(text));
        return this;
    }

    @FindBy(css = ".create-wishlist-button")
    WebElement createWLButton;

    public AccountPage clickOnCreateWishListButton() {
        click(createWLButton);
        return new AccountPage(driver);
    }

    @FindBy(css = ".ant-card")
    WebElement cardExisted;

    public AccountPage verifyCardOfWishList() {
        Assert.assertTrue(isElementPresent(cardExisted));
        return this;
    }

    //    @FindBy(css=".ant-card")
    @FindBy(css = ".ant-card-head")
    WebElement card;

    public AccountPage clickOnWishlist() {
        click(card);
        return new AccountPage(driver);
    }

    //    @FindBy(xpath = "//button [.='add gift']")
    @FindBy(css = ".add-gift-in-card-button-in-account")
    WebElement addGiftButton;

    public AccountPage clickOnAddGiftButton() {
        //click(addGiftbutton);
        clickWithJS(addGiftButton, 0, 500);
        return new AccountPage(driver);
    }

    @FindBy(css = ".gift-count-text-in-account")
    WebElement counterGifts;

    public int getGiftCount() {
        String text = counterGifts.getText().replaceAll("[^0-9]", "");
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @FindBy(css = ".time-left-text-in-account")
    WebElement daysLeftText;

    public int daysLeftExpected() {
        String text = daysLeftText.getText().replaceAll("[^0-9]", "");
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;   //508
        }
    }

    public int daysLeftActual(String eventdate) {
        //String eventDate = "15082025";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate localDate = LocalDate.parse(eventdate, formatter);
        LocalDate today = LocalDate.now();

        int days = (int) ChronoUnit.DAYS.between(today, localDate);
        return days;
        // return (int) ChronoUnit.DAYS.between(today, localDate);
    }

    public AccountPage verifyDayCounterLeft(int leftDays) {
        int expected = daysLeftExpected();

        Assert.assertEquals(leftDays-1 , expected);
        return this;
    }

    public AccountPage confirmWishListsAreAbsent() {
        Assert.assertTrue(!isElementPresent(addGiftButton));
        return this;
    }

    public boolean isAddGiftButtonPresent() {
        return isElementPresent(addGiftButton);
    }
}

