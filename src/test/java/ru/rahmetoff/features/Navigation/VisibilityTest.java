package ru.rahmetoff.features.Navigation;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.common.Configuration;
import ru.rahmetoff.diary.enums.NavigationBarTabs;
import ru.rahmetoff.diary.pages.LoginPage;


public class VisibilityTest extends BaseUITest {
    @DisplayName("Проверка поля {barTab} главного меню")
    @Feature("Главное меню")
//    @Disabled
    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    public void navigationTabsVisibilityTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configuration.LOGIN, Configuration.PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);

    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

}
