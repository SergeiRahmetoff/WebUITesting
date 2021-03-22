package ru.rahmetoff.diary.pages;

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

    public LoginPage dropLoginMenu() {
        dropLogin.click();
        return this;
    }

    public LoginPage enterLogin(String login) {
        loginTextInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passInput.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        signinBtn.click();
        return new HomePage(driver);
    }


    // Для использования в других тестах
    public HomePage authoriseScenario(String login, String password) {
        dropLogin.click();
        loginTextInput.sendKeys(login);
        passInput.sendKeys(password);
        signinBtn.click();
        return new HomePage(driver);
    }
}
