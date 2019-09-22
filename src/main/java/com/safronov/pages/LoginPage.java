package com.safronov.pages;

import com.safronov.Logger;

public class LoginPage extends AbstractPage {

    private String login = "safrontestat";
    private String password = "Qazxc12345";

    private String emailXpath = "//input[@type='email']";
    private String nextBtnXpath = "//*[@id='identifierNext' or @id='passwordNext']";
    private String passwordXpath = "//input[@type='password']";


    public void setLogin() {
        Logger.debug("Ввод логина");
        driver.setText(emailXpath, login);
        Logger.debug("Нажатие на клавишу: Далее");
        driver.click(nextBtnXpath);
        Logger.debug("Ввод пароля");
        driver.setText(passwordXpath, password);
        Logger.debug("Нажатие на клавишу: Далее");
        driver.click(nextBtnXpath);
    }

    @Override
    void waitForLoadFinished() {

    }
}
