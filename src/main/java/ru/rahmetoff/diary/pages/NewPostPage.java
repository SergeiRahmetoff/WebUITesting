package ru.rahmetoff.diary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rahmetoff.diary.base.BaseView;


public class NewPostPage extends BaseView {

    @FindBy(id = "postTitle")
    private WebElement recordTitleArea;

    @FindBy(id = "message")
    private WebElement messageArea;

    @FindBy(id = "rewrite")
    private WebElement rewriteBtn;

    @FindBy(xpath = ".//span[@title = 'Жирный (Ctrl+B)']")
    private WebElement boldTextBtn;

    public WebElement getBoldTextBtn() { return boldTextBtn; }

    public WebElement getMessageArea() { return messageArea; }

    public NewPostPage(WebDriver driver) { super(driver); }

    public NewPostPage clickRecordTitle() {
        recordTitleArea.click();
        return this;
    }

    public NewPostPage recordTitle(String title) {
        recordTitleArea.sendKeys(title);
        return this;
    }

    public NewPostPage clickMessageArea() {
        messageArea.click();
        return this;
    }

    public NewPostPage recordMessage(String message) {
        messageArea.sendKeys(message);
        return this;
    }

    public MyDairyPage rewritePost() {
        rewriteBtn.click();
        return new MyDairyPage(driver);
    }

    public NewPostPage clickBoldTextBtn() {
        boldTextBtn.click();
        return this;
    }

}
