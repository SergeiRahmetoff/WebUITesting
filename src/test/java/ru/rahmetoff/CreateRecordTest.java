package ru.rahmetoff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.rahmetoff.LoginTest.driver;

public class CreateRecordTest {

    private String title = createTitle();

    public String getTitle() {
        return title;
    }

    public String createTitle(){
        int a = (int)(Math.random() * 100);
        return "Тестовая запись " + a;
    }

    public void createRecord() {
        LoginTest loginTest = new LoginTest();
        loginTest.login();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.cssSelector(".i-menu-newpost"))));
        driver.findElement(By.cssSelector(".i-menu-newpost")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("postTitle"))));
        WebElement recordTitle = driver.findElement(By.id("postTitle"));
        recordTitle.click();
        recordTitle.sendKeys(title);


        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("message"))));
        WebElement recordMessage = driver.findElement(By.id("message"));
        recordMessage.click();
        recordMessage.sendKeys("тест тест тест");

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("rewrite"))));
        driver.findElement(By.id("rewrite")).click();
    }

    @Test
    public void createRecordTest(){
        createRecord();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        WebElement assertRecord = driver.findElement(By.className("title"));
        Assertions.assertEquals(title, assertRecord.getText());

        driver.close();
        driver.quit();
    }

}
