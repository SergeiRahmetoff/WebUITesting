package ru.rahmetoff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.rahmetoff.LoginTest.driver;

public class VisibilityTest {

    @Test
    public void navigationTabsVisibilityTest () {
        LoginTest loginTest = new LoginTest();
        loginTest.login();
        ArrayList<String> mainMenuXpathSelectors = new ArrayList(Arrays.asList(
                ".//span[@class='alt' and text() = 'Мой дневник']",
                ".//span[@class='alt' and text() = 'Новая запись']",
                ".//span[@class='alt' and text() = 'Избранное']",
                ".//span[@class='alt' and text() = 'Дискуссии']",
                ".//span[@class='alt' and text() = 'Упоминания']",
                ".//span[@class='alt' and text() = 'U-mail']",
                ".//span[@class='alt' and text() = 'Настройки']"
        ));
        mainMenuXpathSelectors.forEach(menuItemXpathSelector -> {
            WebElement element = driver.findElement(By.xpath(menuItemXpathSelector));
            Assertions.assertTrue(element.isDisplayed());
        });

        driver.close();
    }
}
