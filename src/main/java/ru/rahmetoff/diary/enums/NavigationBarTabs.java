package ru.rahmetoff.diary.enums;

import org.openqa.selenium.By;

public enum NavigationBarTabs {
    MY_DIARY(".//span[@class='alt' and text() = 'Мой дневник']"),
    NEW_RECORD(".//span[@class='alt' and text() = 'Новая запись']"),
    FAVORITES(".//span[@class='alt' and text() = 'Избранное']"),
    DISCUSSIONS(".//span[@class='alt' and text() = 'Дискуссии']"),
    REFERENCES(".//span[@class='alt' and text() = 'Упоминания']"),
    U_MAIL(".//span[@class='alt' and text() = 'U-mail']"),
    SETTINGS(".//span[@class='alt' and text() = 'Настройки']");

    private final By by;
    NavigationBarTabs(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
