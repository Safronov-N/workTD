package com.safronov.td.stepdefinition;

import com.safronov.Driver.DriverUtils;
import com.safronov.Logger;
import com.safronov.Utils.RandomText;
import com.safronov.pages.MessagePage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;


public class MessageStep {

    static final String bodyMessageText = RandomText.generateRandomWord(10);
    static final String themeText = RandomText.generateRandomWord(7);

    @Step("Выбирать письмо")
    public void selectMail() {
        Logger.info("Выбираем письмо коготоре было ранее написанное");
        DriverUtils.selectMessage(themeText);
    }

    @Step("Создаем новое письмо")
    @Допустим("Пользователь создает новое письмо")
    public void email() {
        Logger.info("Создаем новое письмо");
        DriverUtils.createNewMessage(themeText, bodyMessageText);
    }

    @Step("Проверка того что данные равны ранее написанным")
    @Допустим("Проверить, что данные равны ранее внесеным")
    public void check() {
        Logger.info("Проверка того что данные равны ранее написанным");
        DriverUtils.checkInfo(new MessagePage().getWhomText(), themeText, bodyMessageText);
    }


}

