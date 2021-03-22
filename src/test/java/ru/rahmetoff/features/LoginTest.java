package ru.rahmetoff.features;

import org.junit.jupiter.api.Test;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.diary.pages.LoginPage;

import static ru.rahmetoff.common.Configuration.LOGIN;
import static ru.rahmetoff.common.Configuration.PASSWORD;


public class LoginTest extends BaseUITest {

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
