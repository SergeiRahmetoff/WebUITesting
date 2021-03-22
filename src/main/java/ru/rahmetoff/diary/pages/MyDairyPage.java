package ru.rahmetoff.diary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rahmetoff.diary.base.BaseView;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyDairyPage extends BaseView {

    @FindBy(className = "title")
    private WebElement lastPostTitle;

    @FindBy(className = "delPostLink")
    private WebElement deletePostLink;

    @FindBy(className = "submit")
    private WebElement submitDeletePostLink;

    @FindBy(className = "editPostLink")
    private WebElement editPostLink;

    @FindBy(className = "post-inner")
    private WebElement assertNewRecordText;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/b")
    private WebElement assertNewRecordBoldText;

    public MyDairyPage(WebDriver driver) { super(driver); }

    public MyDairyPage deletePost() {
        deletePostLink.click();
        return this;
    }

    public MyDairyPage submitDeletePost() {
        submitDeletePostLink.click();
        return this;
    }

    public NewPostPage editPost() {
        editPostLink.click();
        return new NewPostPage(driver);
    }

    public String getLastPostTitle(){
        return lastPostTitle.getText();
    }

    public void checkLastPostTitle(String title) { assertEquals(lastPostTitle.getText(), title);
    }
    public void negativeCheckLastPostTitle(String title) { assertNotEquals(lastPostTitle.getText(), title);
    }
    public void checkNewRecordText(String text) { assertEquals(assertNewRecordText.getText(), text);
    }
    public void checkNewRecordBoldText(String text) { assertEquals(assertNewRecordBoldText.getText(), text);
    }

    public MyDairyPage deletePostWithoutCheck(){
        new MyDairyPage(driver)
                .deletePost()
                .submitDeletePost();
        return this;
    }
}


