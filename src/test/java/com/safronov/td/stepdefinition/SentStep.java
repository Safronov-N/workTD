package com.safronov.td.stepdefinition;

import com.safronov.Driver.DriverUtils;
import com.safronov.pages.DraftPage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;

public class SentStep {

    @Step("Проверка того что письмо в папке Отправленные")
    @Допустим("Проверяет, есть ли его письмо в Отправленные")
    public void checkInbox() {
        DraftPage draftPage = new DraftPage();
        draftPage.checkThemeText(DriverUtils.listThemeMessage(), MessageStep.themeText);
        draftPage.checkBodyText(DriverUtils.listBodyMessage(), MessageStep.bodyMessageText);
    }
}
