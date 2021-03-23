package ru.rahmetoff.diary.pages;

import io.qameta.allure.Step;
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

    @Step(value = "Клик на поле заголовка поста")
    public NewPostPage clickRecordTitle() {
        recordTitleArea.click();
        return this;
    }
    @Step(value = "Добавление заголовка {title} поста")
    public NewPostPage recordTitle(String title) {
        recordTitleArea.sendKeys(title);
        return this;
    }
    @Step(value = "Клик на текстовом поле")
    public NewPostPage clickMessageArea() {
        messageArea.click();
        return this;
    }
    @Step(value = "Внесение записи {message} в текстовое поле")
    public NewPostPage recordMessage(String message) {
        messageArea.sendKeys(message);
        return this;
    }
    @Step(value = "Нажатие на кнопку сохранения изменений в посте")
    public MyDairyPage rewritePost() {
        rewriteBtn.click();
        return new MyDairyPage(driver);
    }
    @Step(value = "Нажатие на кнопку выделения жирным шрифтом")
    public NewPostPage clickBoldTextBtn() {
        boldTextBtn.click();
        return this;
    }

}
