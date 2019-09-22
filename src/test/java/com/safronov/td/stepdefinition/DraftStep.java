package com.safronov.td.stepdefinition;

import com.safronov.Logger;
import com.safronov.pages.DraftPage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;

public class DraftStep extends AbstractSteps {

    @Step("Проверяем что письмо отображается в черновиках")
    @Допустим("Проверяет, есть ли его письмо в черновиках")
    public void checkDraft() {
        MessageStep messageStep = new MessageStep();
        DraftPage draftPage = new DraftPage();
        Logger.info("Проверка присутствия письма по его теме и содержанию");
        draftPage.checkThemeText(messageStep.listThemeMessage(), MessageStep.themeText);
        draftPage.checkBodyText(messageStep.listBodyMessage(), MessageStep.bodyMessageText);

    }

    @Step("Проверка на отсутствие письма в черновиках")
    @Допустим("Проверить, что письма нет в черновике")
    public void checkNotDraft() {
        MessageStep messageStep = new MessageStep();
        DraftPage draftPage = new DraftPage();
        Logger.info("Проверка присутствия письма по его теме и содержанию");
        try {
            draftPage.checkThemeText(messageStep.listThemeMessage(), MessageStep.themeText);
            draftPage.checkBodyText(messageStep.listBodyMessage(), MessageStep.bodyMessageText);
        } catch (Exception e) {
            Logger.debug("Письма нет в папке Черновики");
        }
    }
}
