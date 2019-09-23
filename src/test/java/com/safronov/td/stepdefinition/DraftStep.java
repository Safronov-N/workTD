package com.safronov.td.stepdefinition;

import com.safronov.utils.DriverUtils;
import com.safronov.Logger;
import com.safronov.pages.DraftPage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;

public class DraftStep {

    @Step("Проверяем что письмо отображается в черновиках")
    @Допустим("Проверяет, есть ли его письмо в черновиках")
    public void checkDraft() {
        DraftPage draftPage = new DraftPage();
        Logger.info("Проверка присутствия письма по его теме и содержанию");
        draftPage.checkThemeText(DriverUtils.listThemeMessage(), MessageStep.themeText);
        draftPage.checkBodyText(DriverUtils.listBodyMessage(), MessageStep.bodyMessageText);

    }

    @Step("Проверка на отсутствие письма в черновиках")
    @Допустим("Проверить, что письма нет в черновике")
    public void checkNotDraft() {
        DriverUtils.noMessageInDraft(MessageStep.themeText,MessageStep.bodyMessageText);
    }
}
