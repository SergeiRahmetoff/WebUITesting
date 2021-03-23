package ru.rahmetoff.diary.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rahmetoff.diary.base.BaseView;
import ru.rahmetoff.diary.views.NavigationBar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BaseView {

    @FindBy(xpath = "/html/body/div[2]/div/ul[2]/li[9]/a")
    private WebElement userName;

    private NavigationBar navigationBar;


    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    @Step(value = "Проверка входа в аккаунт по имени пользователя {uName}")
    public void checkLogIN(String uName) { assertEquals(userName.getText(), uName);
    }


    public NavigationBar getPageNavigation() {
        return navigationBar;
    }
}
