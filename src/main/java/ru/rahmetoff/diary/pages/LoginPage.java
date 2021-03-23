package ru.rahmetoff.diary.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rahmetoff.diary.base.BaseView;

public class LoginPage extends BaseView {

    @FindBy(id = "drop-login")
    private WebElement dropLogin;

    @FindBy(id = "usrlog2")
    private WebElement loginTextInput;

    @FindBy(id = "usrpass2")
    private WebElement passInput;

    @FindBy(id = "signin_btn")
    private WebElement signinBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Открытие меню авторизации")
    public LoginPage dropLoginMenu() {
        dropLogin.click();
        return this;
    }
    @Step(value = "Ввод логина {login}")
    public LoginPage enterLogin(String login) {
        loginTextInput.sendKeys(login);
        return this;
    }
    @Step(value = "Ввод пароля {password}")
    public LoginPage enterPassword(String password) {
        passInput.sendKeys(password);
        return this;
    }
    @Step(value = "Нажатие на кнопку подтверждения авторизации")
    public HomePage clickLoginButton() {
        signinBtn.click();
        return new HomePage(driver);
    }


    // Для использования в других тестах
    @Step(value = "Выполнение авторизации на сайте с логином {login} и паролем {password}")
    public HomePage authoriseScenario(String login, String password) {
        dropLogin.click();
        loginTextInput.sendKeys(login);
        passInput.sendKeys(password);
        signinBtn.click();
        return new HomePage(driver);
    }
}
