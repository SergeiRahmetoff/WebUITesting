package ru.rahmetoff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.rahmetoff.LoginTest.driver;

public class DeleteRecordTest {

    public void deleteRecord() {
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//span[@class='alt' and text() = 'Мой дневник']")));
        driver.findElement(By.xpath(".//span[@class='alt' and text() = 'Мой дневник']")).click();


        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.className("delPostLink")));
        driver.findElement(By.className("delPostLink")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.className("submit")));
        driver.findElement(By.className("submit")).click();
    }

    @Test
    public void deleteRecordTest() {
        CreateRecordTest createRecordTest = new CreateRecordTest();
        createRecordTest.createRecord();
        deleteRecord();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.className("title")));
        WebElement assertRecord = driver.findElement(By.className("title"));
        System.out.println(assertRecord.getText());
        System.out.println(createRecordTest.getTitle());
        Assertions.assertNotEquals(createRecordTest.getTitle(), assertRecord.getText());

        driver.close();
        driver.quit();
    }
}
