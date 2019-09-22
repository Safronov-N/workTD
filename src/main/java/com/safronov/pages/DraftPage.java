package com.safronov.pages;

import java.util.List;

public class DraftPage extends AbstractPage {
    public DraftPage() {
        waitForLoadFinished();
    }

    @Override
    void waitForLoadFinished() {
        driver.waitElement("//span[@class='yP boq']", "Черновик");
    }

    /**
     * Выполняет проверку на присутствие по теме письма
     *
     * @param themeText
     * @param findText
     * @return
     */
    public String checkThemeText(List<String> themeText, String findText) {
        return themeText.stream().filter(o -> o.equalsIgnoreCase(findText)).findFirst().get();
    }

    /**
     * Выполняет проверку на присутствие по содержимому письма
     *
     * @param bodyMessage
     * @param findText
     * @return
     */
    public String checkBodyText(List<String> bodyMessage, String findText) {
        return bodyMessage.stream().filter(o -> o.equalsIgnoreCase(findText)).findFirst().get();
    }
}
