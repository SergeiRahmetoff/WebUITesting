package ru.rahmetoff.features;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import ru.rahmetoff.base.BaseUITest;
import ru.rahmetoff.common.Configuration;
import ru.rahmetoff.diary.pages.LoginPage;
import ru.rahmetoff.diary.pages.MyDairyPage;
import ru.rahmetoff.diary.pages.NewPostPage;

import static ru.rahmetoff.diary.enums.NavigationBarTabs.MY_DIARY;


public class EditRecordTest extends BaseUITest {

    @Test
    public void editRecordTest() {

        new LoginPage(driver)
                .authoriseScenario(Configuration.LOGIN, Configuration.PASSWORD)
                .getPageNavigation()
                .clickNavigationTab(MY_DIARY);
        new MyDairyPage(driver)
                .editPost();
        Actions builder = new Actions(driver);
        builder
                .click(new NewPostPage(driver).getMessageArea())
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .pause(2000)
                .doubleClick()
                .click(new NewPostPage(driver).getBoldTextBtn())
                .build()
                .perform();
        new NewPostPage(driver)
                .rewritePost()
                .checkNewRecordText("тест тест");
        new MyDairyPage(driver)
                .checkNewRecordBoldText("тест");
    }
}
