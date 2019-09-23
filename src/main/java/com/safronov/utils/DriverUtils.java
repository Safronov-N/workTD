package com.safronov.utils;

import com.safronov.Logger;
import com.safronov.driver.Driver;
import com.safronov.pages.EmailPage;
import com.safronov.pages.MessagePage;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class DriverUtils {

    /**
     * Собирает лист с темой письма
     */
    public static List<String> listThemeMessage() {
        return Driver.driver.findElements(new MessagePage().getThemeMessagesXpath()).stream().map(WebElement::getText)
            .map(o -> o.replaceFirst("- \n", "").trim()).collect(Collectors.toList());
    }

    /**
     * Собирает лист с текстом письма
     */
    public static List<String> listBodyMessage() {
        return Driver.driver.findElements(new MessagePage().getBodyMessagesXpath()).stream().map(WebElement::getText)
            .map(o -> o.replaceFirst("- \n", "").trim()).collect(Collectors.toList());
    }

    public static void noMessageInDraft(String theme, String body){
       boolean themeMessage = listThemeMessage().stream().anyMatch(o->o.equalsIgnoreCase(theme));
       boolean bodyMessage = listBodyMessage().stream().anyMatch(o->o.equalsIgnoreCase(body));
        if (!themeMessage & !bodyMessage) {
            Logger.info(String.format("Сообщение с темой %s ожидаемо отсутствует", theme));
        } else {
            Logger.warn(String.format("Сообщение с темой %s присутствует", theme));
        }

    }

    public static void selectMessage(String messageText) {
        Driver.driver.findElements(new MessagePage().getThemeMessagesXpath()).stream()
            .filter(o -> o.getText().equalsIgnoreCase(messageText))
            .findFirst().get().click();
    }


    public static void checkInfo(String email, String theme, String body) {
        MessagePage messagePage = new MessagePage();
        if (Driver.driver.findElement(messagePage.getEmailXpath()).getText().equals(email)) {
            Logger.info(String.format("Значение ожидаемо равно: %s", email));
        } else {
            Logger.warn(String.format("Значение не равно: %s", email));
        }

        if (Driver.driver.getValue(messagePage.getThemeXpath()).equals(theme)) {
            Logger.info(String.format("Значение ожидаемо равно: %s", theme));
        } else {
            Logger.warn(String.format("Значение не равно: %s", theme));
        }

        if (Driver.driver.findElement(messagePage.getMessageXpath()).getText().equals(body)) {
            Logger.info(String.format("Значение ожидаемо равно: %s", body));
        } else {
            Logger.warn(String.format("Значение не равно: %s", body));
        }
    }

    public static void createNewMessage(String themeText, String messageText) {
        MessagePage messagePage = new MessagePage();
        EmailPage emailPage = new EmailPage();
        Driver.driver.click(emailPage.getCreateNewMessageXpath());
        Driver.driver.setText(messagePage.getWhomXpath(), messagePage.getWhomText());
        Driver.driver.setText(messagePage.getThemeXpath(), themeText);
        Driver.driver.setText(messagePage.getMessageXpath(), messageText);
        Driver.driver.click(messagePage.getExitXpath());
    }
}