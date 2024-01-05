package org.AirdropAutomation.FirstDrop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        webdriverInstance();
    }
    public static void webdriverInstance() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(System.getProperty("user.dir")+"\\metamask.crx"));

        WebDriver driver = new ChromeDriver(options);

        driver.get("");


        //driver.quit();
    }
}
