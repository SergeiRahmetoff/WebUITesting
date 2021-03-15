package ru.rahmetoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.rahmetoff.Log_in.driver;

public class CreateRecord {

    public static void main(String[] args) {
        Log_in log_in = new Log_in();
        log_in.login();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.cssSelector(".i-menu-newpost"))));
        driver.findElement(By.cssSelector(".i-menu-newpost")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("postTitle"))));
        WebElement recordTitle = driver.findElement(By.id("postTitle"));
        recordTitle.click();
        recordTitle.sendKeys("Тестовая запись 1");


        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("message"))));
        WebElement recordMessage = driver.findElement(By.id("message"));
        recordMessage.click();
        recordMessage.sendKeys("тест тест тест");

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("rewrite"))));
        driver.findElement(By.id("rewrite")).click();


        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        WebElement assertRecord = driver.findElement(By.className("title"));
        if (assertRecord.getText().equals("Тестовая запись 1")){
            System.out.println("Record OK");
        } else {
            System.out.println("Record false");
        }

        driver.close();
    }

}
