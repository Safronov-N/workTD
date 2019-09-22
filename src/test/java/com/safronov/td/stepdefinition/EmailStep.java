package com.safronov.td.stepdefinition;

import com.safronov.Logger;
import com.safronov.pages.EmailPage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;

public class EmailStep extends AbstractSteps {
    @Step("Переходим в пункт Черновики")
    public void goToDraft() {
        Logger.info("Нажатие на кнопку Черновики");
        new EmailPage().draftClick();
    }

    @Step("Нажатие на элемент Отправить")
    public void sendMessage() {
        Logger.info("Нажатие на кнопку Отправить");
        new EmailPage().sendMessageClick();
    }

    @Step("Нажатие на элемент Входящие")
    public void goInbox() {
        Logger.info("Нажатие на кнопку Входящие");
        new EmailPage().inboxClick();
    }

    @Step("Нажатие на элемент Профиль")
    public void goProfile() {
        Logger.info("Нажатие на кнопку Профиль");
        new EmailPage().ProfileClick();
    }

    @Step("Нажатие на элемент Выход")
    public void goExit() {
        Logger.info("Нажатие на кнопку Выход");
        new EmailPage().ExitClick();
    }

    @Допустим("Ожидание в секундах {int}")
    public void sleep(int i) throws InterruptedException {
        Thread.sleep(i * 1000);
    }

    @Допустим("Нажать на элемент {string}")
    public void press(String button) {
        switch (button) {
            case "Черновики":
                goToDraft();
                break;
            case "Отправить":
                sendMessage();
                break;
            case "Входящие":
                goInbox();
                break;
            case "Профиль":
                goProfile();
                break;
            case "Выход":
                goExit();
                break;
            case "Письмо":
                new MessageStep().selectMail();
                break;
        }
    }
}
