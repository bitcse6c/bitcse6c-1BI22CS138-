package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();

        // Wait to allow the popup to load (basic sleep, replace with WebDriverWait for production)
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Enter username and password
        WebElement username = driver.findElement(By.cssSelector("input._2IX_2-"));
        WebElement password = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));

        username.sendKeys("your_email_or_phone");
        password.sendKeys("your_password");
        loginBtn.click();

        // Optional: Wait and close
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        driver.quit();
    }
}

