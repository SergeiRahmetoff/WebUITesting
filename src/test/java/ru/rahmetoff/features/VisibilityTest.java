package ru.rahmetoff.features;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.common.Configuration;
import ru.rahmetoff.diary.enums.NavigationBarTabs;
import ru.rahmetoff.diary.pages.LoginPage;


public class VisibilityTest extends BaseUITest {

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
