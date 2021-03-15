package ru.rahmetoff;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.rahmetoff.Log_in.driver;

public class EditRecord {

    public static void main(String[] args) {
        Log_in log_in = new Log_in();
        log_in.login();

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


        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.className(".post-inner/b")));
        WebElement assertRecord = driver.findElement(By.className(".post-inner/b"));
        System.out.println(assertRecord);
//        if (assertRecord.getText().equals("Тестовая запись 1")){
//            System.out.println("Record OK");
//        } else {
//            System.out.println("Record false");
//        }

        driver.close();
    }
}
