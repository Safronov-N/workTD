package com.safronov.pages;

import com.safronov.Logger;
import com.safronov.utils.CommandLine;

public class LoginPage extends AbstractPage {

//    private String login = "safrontestat";
//    private String password = "Qazxc12345";

    private String emailXpath = "//input[@type='email']";
    private String nextBtnXpath = "//*[@id='identifierNext' or @id='passwordNext']";
    private String passwordXpath = "//input[@type='password']";


    public void setLogin() {
        String login = CommandLine.getInstance().getLogin();
        String password = CommandLine.getInstance().getPassword();
        Logger.info(String.format("Ввод логина: %s , в поле:  %s", login, emailXpath));
        driver.setText(emailXpath, login);
        Logger.info(String.format("Нажатие на клавишу: %s", nextBtnXpath));
        driver.click(nextBtnXpath);
        Logger.info(String.format("Ввод пароля: %s , в поле: %s", password, passwordXpath));
        driver.setText(passwordXpath, password);
        Logger.info(String.format("Нажатие на клавишу: %s", nextBtnXpath));
        driver.click(nextBtnXpath);
    }

    @Override
    void waitForLoadFinished() {

    }
}
