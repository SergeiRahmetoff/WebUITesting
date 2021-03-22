package ru.rahmetoff.features;

import org.junit.jupiter.api.RepeatedTest;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.common.Configuration;
import ru.rahmetoff.diary.pages.LoginPage;
import ru.rahmetoff.diary.pages.NewPostPage;

import static ru.rahmetoff.diary.enums.NavigationBarTabs.NEW_RECORD;

public class CreateRecordTest extends BaseUITest {

    private String title = createTitle();

    public String getTitle() {
        return title;
    }

    public String createTitle(){
        int a = (int)(Math.random() * 100);
        return "Тестовая запись " + a;
    }


    @RepeatedTest(2)
    public void createRecordTest(){
        new LoginPage(driver)
                .authoriseScenario(Configuration.LOGIN, Configuration.PASSWORD)
                .getPageNavigation()
                .clickNavigationTab(NEW_RECORD);
        new NewPostPage(driver)
                .clickRecordTitle()
                .recordTitle(title)
                .clickMessageArea()
                .recordMessage("тест тест тест")
                .rewritePost()
                .checkLastPostTitle(title);

    }

}
