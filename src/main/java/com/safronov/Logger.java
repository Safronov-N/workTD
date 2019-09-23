package com.safronov;

import com.safronov.driver.Driver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public final class Logger {
    private static final org.slf4j.Logger logger;
    private static Supplier<WebDriver> getDriver;

    static {
        logger = LoggerFactory.getLogger(Logger.class);
    }

    @Step("{0}")
    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    @Step("Получена ошибка {0}")
    public static void warn(String message) {
        logger.warn(message);
        attachPageSource();
        attachScreenshot();
    }

    @Attachment(value = "Page source", type = "text/xml")
    public static byte[] attachPageSource() {
        return Driver.getInstance().takePageSours();
    }

    @Attachment(value = "Page screenshot", type = "image/jpg")
    public static byte[] attachScreenshot() {
        return Driver.getInstance().takeScreenshot();
    }
}
