package com.wishlist.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    JavascriptExecutor js;
    public WebDriver driver;
    FluentWait<WebDriver> wait;

    public static final Duration WAIT_SEC = Duration.ofSeconds(5);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
//        wait = new FluentWait<>(driver) // Инициализируем FluentWait
//                .withTimeout(Duration.ofSeconds(15)) // Устанавливаем таймаут ожидания
//                .pollingEvery(Duration.ofSeconds(1)) // Устанавливаем периодичность проверки
//                .ignoring(NoSuchElementException.class) // Игнорируем исключение NoSuchElementException
//                .ignoring(StaleElementReferenceException.class); // Игнорируем исключение StaleElementReferenceException
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clickAlert(WebElement element) {
        click(element);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void clickWithJSEye(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void type(WebElement element, String text) {

        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    //Использование ожидания доступности элемента click
    public void safeClick(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    //Использование ожидания доступности элемента type
    public void safeType(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        pause(500);
        click(element);
    }

    public void scrollToTopWithJS() {
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }

    public void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void hideElementWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.visibility='hidden';", element);
    }

    public void showElementWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.visibility='visible';", element);
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());

        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

    public void uploadFileRobot(String filePath) {
        try {
            // Скопировать путь к файлу в буфер обмена
            StringSelection stringSelection = new StringSelection(filePath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            // Создать объект Robot
            Robot robot = new Robot();

            // Добавить задержку
            robot.delay(1000);

            // Нажать комбинацию клавиш для вставки текста из буфера обмена
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Добавить задержку
            robot.delay(1000);

            // Нажать Enter для подтверждения выбора файла
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForGiftFormToBeFilled(WebElement[] requiredFields) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement field : requiredFields) {
            wait.until(ExpectedConditions.attributeToBeNotEmpty(field, "value"));
        }
    }

    public String takeScreenshoot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("Screenshots/screen-"
                + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}



