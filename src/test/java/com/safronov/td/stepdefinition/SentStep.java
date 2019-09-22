package com.safronov.td.stepdefinition;

import com.safronov.pages.DraftPage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;

public class SentStep extends AbstractSteps {

    @Step("Проверка того что письмо в папке Отправленные")
    @Допустим("Проверяет, есть ли его письмо в Отправленные")
    public void checkInbox() {
        DraftPage draftPage = new DraftPage();
        MessageStep messageStep = new MessageStep();
        draftPage.checkThemeText(messageStep.listThemeMessage(), MessageStep.themeText);
        draftPage.checkBodyText(messageStep.listBodyMessage(), MessageStep.bodyMessageText);
    }
}
