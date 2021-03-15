package ru.rahmetoff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.rahmetoff.LoginTest.driver;

public class EditRecordTest {

    public void editRecord() {


        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//span[@class='alt' and text() = 'Мой дневник']")));
        driver.findElement(By.xpath(".//span[@class='alt' and text() = 'Мой дневник']")).click();


        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.className("editPostLink")));
        driver.findElement(By.className("editPostLink")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("message")));
        WebElement messageTextArea = driver.findElement(By.id("message"));
        WebElement boldText = driver.findElement(By.className("i-b-b"));

        Actions builder = new Actions(driver);
        builder
                .click(messageTextArea)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .pause(2000)
                .doubleClick()
                .click(boldText)
                .build()
                .perform();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("rewrite"))));
        driver.findElement(By.id("rewrite")).click();
    }

    @Test
    public void editRecordTest() {
        CreateRecordTest createRecordTest = new CreateRecordTest();
        createRecordTest.createRecord();
        editRecord();

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.className("post-inner")));
        WebElement assertRecord = driver.findElement(By.className("post-inner"));
        WebElement assert2Record = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/b"));

        Assertions.assertEquals("тест тест", assertRecord.getText());
        Assertions.assertEquals("тест", assert2Record.getText());

        driver.close();
        driver.quit();
    }
}
