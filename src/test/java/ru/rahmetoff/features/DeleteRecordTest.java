package ru.rahmetoff.features;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.common.Configuration;
import ru.rahmetoff.diary.pages.LoginPage;
import ru.rahmetoff.diary.pages.MyDairyPage;

import static ru.rahmetoff.diary.enums.NavigationBarTabs.MY_DIARY;


public class DeleteRecordTest extends BaseUITest {

    @Disabled
    @Test
    public void deleteRecordWithoutCheckTest(){
        new LoginPage(driver)
                .authoriseScenario(Configuration.LOGIN, Configuration.PASSWORD)
                .getPageNavigation()
                .clickNavigationTab(MY_DIARY);
        new MyDairyPage(driver)
                .deletePostWithoutCheck();
    }

    @Test
    public void deleteRecordTest() {
        new LoginPage(driver)
                .authoriseScenario(Configuration.LOGIN, Configuration.PASSWORD)
                .getPageNavigation()
                .clickNavigationTab(MY_DIARY);
        String postTitle = new MyDairyPage(driver).getLastPostTitle();
        new MyDairyPage(driver)
                .deletePostWithoutCheck()
                .negativeCheckLastPostTitle(postTitle);
    }
}
