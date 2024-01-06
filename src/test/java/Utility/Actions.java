package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions extends LaunchBrowser{
    public static void click(WebDriver driver, String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void wait(WebDriver driver, int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
//
//    public static void waitTillClickable(WebDriver driver, String xpath, int timeout){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
//    }
//
//    public static void waitTillVisible(WebDriver driver, String xpath, int timeout){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//    }

    public static void input(WebDriver driver, String xpath, String input){
        driver.findElement(By.xpath(xpath)).sendKeys(input);
    }


}
