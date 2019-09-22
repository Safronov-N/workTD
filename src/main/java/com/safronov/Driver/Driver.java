package com.safronov.Driver;

import com.safronov.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Driver {
    private WebDriverWait wait;
    public static Driver driver;
    public WebDriver webDriver;

    /**
     * Путь до хром драйвера
     */
    static final String PATH_TO_DRIVER = "C:\\Users\\Николай\\Desktop\\projectAT-master\\bin\\chromedriver.exe";

    /**
     * Сайт который надо открыть
     */
    static final String SITE = "https://mail.google.com/mail";

    private Driver() {
        webDriver = new ChromeDriver(getConfiguration());
        wait = new WebDriverWait(webDriver, 5, 1222);
        webDriver.get(SITE);
        webDriver.manage().window().maximize();
    }


    private ChromeOptions getConfiguration() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        ChromeOptions chromeOptions = new ChromeOptions();
        return chromeOptions;
    }

    /**
     * Экземпляр класса-обертки вебдрайвера, построена с использованием паттерна Singleton, создается только один экземпляр класса на всю
     * программу, доступ через метод getInstance()
     */
    public static Driver getInstance() {
        if (driver == null) {
            driver = new Driver();
        }
        return driver;

    }

    public WebElement findElement(String xPath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        return webDriver.findElement(By.xpath(xPath));
    }

    public List<WebElement> findElements(String xPath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        return webDriver.findElements(By.xpath(xPath));
    }

    public void click(String xpath) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            webDriver.findElement(By.xpath(xpath)).click();
            Logger.debug(String.format("Выполняется клик по элементу %s", xpath));
        } catch (Exception e) {
            Logger.warn(String.format("Не удалось выполнить клик по элементу %s", xpath));
        }
    }

    public void setText(String xPath, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            Logger.debug(String.format("Ввод текста в поле : %s", xPath));
            findElement(xPath).sendKeys(text);
        } catch (Exception e) {
            Logger.warn(String.format("Невозможно ввести текст в элемент %s", xPath));
        }
    }

    public String getValue(String xPath) {
        return findElement(xPath).getAttribute("value");
    }

    public void waitElement(String xPath, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPath), text));
        } catch (Exception e) {
            Logger.debug(String.format("Не удалось дождаться загрузки страницы %s", xPath));
        }
    }

    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public byte[] takePageSours() {
        try {
            return  webDriver.getPageSource().getBytes();
        } catch (Exception e) {
            return new byte[0];
        }
    }
    public void exit(){
        webDriver.close();
    }
}
