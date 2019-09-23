package com.safronov.pages;

import com.safronov.Logger;

public class LoginPage extends AbstractPage {

    private String login = "safrontestat";
    private String password = "Qazxc12345";

    private String emailXpath = "//input[@type='email']";
    private String nextBtnXpath = "//*[@id='identifierNext' or @id='passwordNext']";
    private String passwordXpath = "//input[@type='password']";


    public void setLogin() {
        Logger.info(String.format("Ввод логина в поле: %s", emailXpath));
        driver.setText(emailXpath, login);
        Logger.info(String.format("Нажатие на клавишу: %s",nextBtnXpath));
        driver.click(nextBtnXpath);
        Logger.info(String.format("Ввод пароля в поле: %s",passwordXpath));
        driver.setText(passwordXpath, password);
        Logger.info(String.format("Нажатие на клавишу: %s",nextBtnXpath));
        driver.click(nextBtnXpath);
    }

    @Override
    void waitForLoadFinished() {

    }
}
