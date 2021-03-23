package ru.rahmetoff.features.Login;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.diary.pages.LoginPage;

import static ru.rahmetoff.common.Configuration.LOGIN;
import static ru.rahmetoff.common.Configuration.PASSWORD;


public class LoginTest extends BaseUITest {
    @DisplayName("Авторизация с корректным логином и паролем")
    @Feature("Авторизация с корректным логином и паролем")
    @Test
    public void loginTest() {

        new LoginPage(driver)
                .dropLoginMenu()
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkLogIN(LOGIN);

    }
}
