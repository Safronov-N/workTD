package com.safronov.pages;


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

    public void ProfileClick() {
        driver.click(profileXpath);
    }

    public void ExitClick() {
        driver.click(exitXpath);
    }

    public EmailPage draftClick() {
        driver.click(draftXpath);
        return this;
    }

    public EmailPage inboxClick() {
        driver.click(inboxXpath);
        return this;
    }

    public EmailPage sendMessageClick() {
        driver.click(sendMessageXpath);
        return this;
    }

    @Override
    void waitForLoadFinished() {
        driver.waitElement("//span[@class='yP boq']", "Отправленные");
    }
}
