package com.safronov.td.stepdefinition;

import com.safronov.Logger;
import com.safronov.Utils.RandomText;
import com.safronov.pages.EmailPage;
import com.safronov.pages.MessagePage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MessageStep extends AbstractSteps {

    static final String bodyMessageText = RandomText.generateRandomWord(10);
    static final String themeText = RandomText.generateRandomWord(7);

    @Step("Выбирать письмо")
    public void selectMail() {
        Logger.info("Выбираем письмо коготоре было ранее написанное");
        new MessageStep().selectMessage(themeText);
    }

    @Step("Создаем новое письмо")
    @Допустим("Пользователь создает новое письмо")
    public void email() {
        Logger.info("Создаем новое письмо");
        new MessageStep().createNewMessage(themeText, bodyMessageText);
    }

    @Step("Проверка того что данные равны ранее написанным")
    @Допустим("Проверить, что данные равны ранее внесеным")
    public void check() {
        Logger.info("Проверка того что данные равны ранее написанным");
        checkInfo(new MessagePage().getWhomText(), themeText, bodyMessageText);
    }

    /**
     * Собирает лист с темой письма
     *
     * @return
     */
    public List<String> listThemeMessage() {
        return driver.findElements(new MessagePage().getThemeMessagesXpath()).stream().map(WebElement::getText)
                .map(o -> o.replaceFirst("- \n", "").trim()).collect(Collectors.toList());
    }

    /**
     * Собирает лист с текстом письма
     *
     * @return
     */
    public List<String> listBodyMessage() {
        return driver.findElements(new MessagePage().getBodyMessagesXpath()).stream().map(WebElement::getText)
                .map(o -> o.replaceFirst("- \n", "").trim()).collect(Collectors.toList());
    }

    public void selectMessage(String messageText) {
        driver.findElements(new MessagePage().getThemeMessagesXpath()).stream().filter(e -> e.getText().equalsIgnoreCase(messageText))
                .findFirst().get().click();
    }


    public void checkInfo(String email, String theme, String body) {
        MessagePage messagePage = new MessagePage();
        if (driver.findElement(messagePage.getEmailXpath()).getText().equals(email))
            Logger.info(String.format("Значение ожидаемо равно: %s", email));
        else
            Logger.warn(String.format("Значение не равно: %s", email));

        if (driver.getValue(messagePage.getThemeXpath()).equals(theme))
            Logger.info(String.format("Значение ожидаемо равно: %s", theme));
        else
            Logger.warn(String.format("Значение не равно: %s", theme));

        if (driver.findElement(messagePage.getMessageXpath()).getText().equals(body))
            Logger.info(String.format("Значение ожидаемо равно: %s", body));
        else
            Logger.warn(String.format("Значение не равно: %s", body));
    }

    public void createNewMessage(String themeText, String messageText) {
        MessagePage messagePage = new MessagePage();
        EmailPage emailPage = new EmailPage();
        driver.click(emailPage.getCreateNewMessageXpath());
        driver.setText(messagePage.getWhomXpath(), messagePage.getWhomText());
        driver.setText(messagePage.getThemeXpath(), themeText);
        driver.setText(messagePage.getMessageXpath(), messageText);
        driver.click(messagePage.getExitXpath());
    }
}
