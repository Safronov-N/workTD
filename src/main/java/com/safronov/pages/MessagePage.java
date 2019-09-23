package com.safronov.pages;

/**
 * Страница по созданию письма
 */
public class MessagePage extends AbstractPage {

    private String whomText = "Freeway1991@outlook.com";

    private String whomXpath = "//textarea[@aria-label='Кому']";
    private String emailXpath = "//div[@class='oL aDm az9']//span[@email]";
    private String themeXpath = "//input[@name='subjectbox']";
    private String messageXpath = "//div[@aria-label='Тело письма']";
    private String exitXpath = "//img[@aria-label='Сохранить и закрыть']";
    private String themeMessagesXpath = "//tr[@class='zA yO']//div[@class='y6']//span[@data-thread-id]";
    private String bodyMessagesXpath = "//tr[@class='zA yO']//span[@class='y2']";

    /**
     * Геттеры
     */
    public String getWhomText() {
        return whomText;
    }

    public String getEmailXpath() {
        return emailXpath;
    }

    public String getThemeXpath() {
        return themeXpath;
    }

    public String getMessageXpath() {
        return messageXpath;
    }

    public String getThemeMessagesXpath() {
        return themeMessagesXpath;
    }

    public String getBodyMessagesXpath() {
        return bodyMessagesXpath;
    }

    public String getWhomXpath() {
        return whomXpath;
    }

    public String getExitXpath() {
        return exitXpath;
    }

    @Override
    void waitForLoadFinished() {

    }
}
