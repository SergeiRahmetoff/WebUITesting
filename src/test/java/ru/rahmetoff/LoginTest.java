package ru.rahmetoff;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Log_in{

        public static final String LOGIN_PAGE_URL = "https://www.diary.ru";
        public static final String LOGIN = "test121212";
        public static final String PASSWORD = "a9e84a8a4";
        public static final WebDriver driver;

        static {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            driver = new ChromeDriver();
        }

    public static void main ( String[] args ) {

        login();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[9]/a"))));
        WebElement assertLogin = driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[9]/a"));
        if (assertLogin.getText().equals("test121212")){
            System.out.println("Login OK");
        } else {
            System.out.println("Login false");
        }

        driver.close();
    }

    public static void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement dropLogin = driver.findElement(By.id("drop-login"));
        dropLogin.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("usrlog2"))));
        WebElement loginTextInput = driver.findElement(By.id("usrlog2"));
        loginTextInput.click();
        loginTextInput.sendKeys(LOGIN);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("usrpass2"))));
        WebElement passInput = driver.findElement(By.id("usrpass2"));
        passInput.click();
        passInput.sendKeys(PASSWORD);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.id("signin_btn"))));
        WebElement signinBtn = driver.findElement(By.id("signin_btn"));
        signinBtn.click();
    }
}
