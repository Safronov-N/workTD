package com.safronov.pages;


import com.safronov.Logger;

public class EmailPage extends AbstractPage {

    private String draftXpath = "//a[@title='Черновики']";
    private String inboxXpath = "//a[@title='Отправленные']";
    private String profileXpath = "//a[contains(@aria-label, 'Аккаунт Google')]";
    private String exitXpath = "//a[text()='Выйти']";
    private String createNewMessageXpath = "//*[text() = 'Написать']";
    private String sendMessageXpath = "//*[text()='Отправить']";

    public EmailPage() {waitForLoadFinished();}


    public String getCreateNewMessageXpath() {
        return createNewMessageXpath;
    }

    public void profileClick() {
        Logger.info(String.format("Нажимаем на элемент: %s",profileXpath));
        driver.click(profileXpath);
    }

    public void exitClick() {
        Logger.info(String.format("Нажимаем на элемент: %s",exitXpath));
        driver.click(exitXpath);
    }

    public EmailPage draftClick() {
        Logger.info(String.format("Нажимаем на элемент: %s",draftXpath));
        driver.click(draftXpath);
        return this;
    }

    public EmailPage inboxClick() {
        Logger.info(String.format("Нажимаем на элемент: %s",inboxXpath));
        driver.click(inboxXpath);
        return this;
    }

    public EmailPage sendMessageClick() {
        Logger.info(String.format("Нажимаем на элемент: %s",sendMessageXpath));
        driver.click(sendMessageXpath);
        return this;
    }

    @Override
    void waitForLoadFinished() {
        driver.waitElement("//span[@class='yP boq']", "Отправленные");
    }
}
