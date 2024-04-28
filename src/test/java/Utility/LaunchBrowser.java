package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class LaunchBrowser {
    public static WebDriver webdriverWithMetamask() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(System.getProperty("user.dir")+"\\metamask.crx"));
        //options.addArguments("--headless=new");

        return new ChromeDriver(options);
    }

    public static WebDriver webdriverWithLeo() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(System.getProperty("user.dir")+"\\LeoWallet.crx"));

        return new ChromeDriver(options);
    }

    public static WebDriver webdriverWithPhantom() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(System.getProperty("user.dir")+"\\phantom.crx"));
        options.addArguments("--headless=new");
//        options.addArguments("--user-data-dir=C:/Users/Krishna/AppData/Local/Google/Chrome/User Data/Default");
//        options.addArguments("--profile-directory=Profile "+Thread.currentThread().getId());
        return new ChromeDriver(options);
    }

    public static WebDriver webdriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        return new ChromeDriver(options);
    }

    public static WebDriver driver;
}
