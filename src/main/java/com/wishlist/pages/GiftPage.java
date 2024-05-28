package com.wishlist.pages;

import com.wishlist.models.Gift;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GiftPage extends BasePage {

    public GiftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gift-link-custom")
    WebElement likWhere;

    @FindBy(id = "gift-name-custom")
    WebElement giftName;

    @FindBy(id = "gift-price-custom")
    WebElement priceField;

    @FindBy(css = ".currency-select")
    WebElement currencyField;

    @FindBy(id = "gift-comment-custom")
    WebElement giftcomment;

    @FindBy(css = ".file-input-text")
    WebElement uploadPhotoWindow;

    @FindBy(css = ".save-button-custom")
    WebElement saveButton;
    @FindBy(id = "link-custom")
    WebElement linkImgField;

    public GiftPage fillGiftform(String link, String name, String price, String currency, String photoPath, String linkImg, String comment) {
        type(likWhere, link);
        type(giftName, name);
        type(priceField, String.valueOf(price));

        click(currencyField);
        currencyField.sendKeys(currency);
        currencyField.sendKeys(Keys.ENTER);

        click(uploadPhotoWindow);
//        uploadFile(uploadPhotoWindow, photoPath);
        uploadFileRobot(photoPath);

        type(linkImgField, linkImg);
        type(giftcomment, comment);
        hideFooter();
        return new GiftPage(driver);
    }
    public GiftPage fillGiftform(Gift gift) {
        type(likWhere, gift.link);
        type(giftName, gift.name);
        type(priceField, String.valueOf(gift.price));

        click(currencyField);
        currencyField.sendKeys(gift.currency);
        currencyField.sendKeys(Keys.ENTER);

        click(uploadPhotoWindow);
//        uploadFile(uploadPhotoWindow, photoPath);
        uploadFileRobot(gift.photoPath);

        type(linkImgField, gift.linkImg);
        type(giftcomment, gift.comment);
        hideFooter();
        return new GiftPage(driver);
    }

    public GiftPage clickSaveButton() {
        click(saveButton);
        return new GiftPage(driver);
    }

    public void waitForSaveButtonAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        click(saveButton);
    }
}

//-----------Вывод в консоль всех полей внутри currency------------------
//        List<WebElement> options=select.getOptions();
//        System.out.println(select.getFirstSelectedOption().getText() + "is first");
//        for (int i = 0; i < options.size(); i++) {
//            System.out.println(options.get(i).getText());
//
//------------Второй вариант выбора currency------------------------------
//        currencyField.sendKeys(currency);
//        currencyField.sendKeys(Keys.ENTER);


//    public GiftPage enterGiftLink(String link) {
//        type(likWhere, link);
//        return this;
//    }


//    public GiftPage enterGiftName(String name) {
//        type(giftName, name);
//        return this;
//    }


//    public GiftPage enterGiftPrice(String price) {
//        type(priceField, String.valueOf(price));
//        return this;
//    }

//    public GiftPage chooseCurrency(String currency) {
//        click(currencyField);
//        currencyField.sendKeys(currency);
//        currencyField.sendKeys(Keys.ENTER);
//        return this;
//    }

//    public GiftPage enterGiftComment(String comment) {
//        type(giftcomment, comment);
//        return this;
//    }

//    public GiftPage enterPhoto(String photoPath) {
//        uploadPhotoWindow.sendKeys(photoPath);
//        return this;
//    }

//    public GiftPage clickSaveButton() {
//        click(saveButton);
//        return new GiftPage(driver);
//    }