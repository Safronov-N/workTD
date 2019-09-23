package com.safronov.td.stepdefinition;

import com.safronov.pages.LoginPage;
import cucumber.api.java.ru.Допустим;
import io.qameta.allure.Step;

public class LoginStep {

    @Step("Пользователь входит в почту")
    @Допустим("Пользователь вошел на почту")
    public void setLogin() {
        new LoginPage().setLogin();
    }


}
