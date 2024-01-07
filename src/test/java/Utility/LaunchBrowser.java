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

        return new ChromeDriver(options);
    }
    public static WebDriver webdriverWithLeo() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(System.getProperty("user.dir")+"\\LeoWallet.crx"));

        return new ChromeDriver(options);
    }
    public static WebDriver driver;
}
