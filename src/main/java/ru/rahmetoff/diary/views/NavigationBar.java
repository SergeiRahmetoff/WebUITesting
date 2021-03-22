package ru.rahmetoff.diary.views;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.rahmetoff.diary.base.BaseView;
import ru.rahmetoff.diary.enums.NavigationBarTabs;

public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void clickNavigationTab(NavigationBarTabs tab) {
        Actions actions = new Actions(driver);
        actions
            .moveToElement(driver.findElement(tab.getBy()))
            .click()
            .build()
            .perform();
    }

//  MY_DIARY
//  NEW_RECORD
//  FAVORITES
//  DISCUSSIONS
//  REFERENCES
//  U_MAIL
//  SETTINGS

    public NavigationBar checkTabVisibility(NavigationBarTabs tab) {
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}