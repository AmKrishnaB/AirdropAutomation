package AirdropAutomation.Bungee;

import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.*;
import static Utility.LaunchBrowser.driver;

public class bungee {

    public static void loadBungee(){
        driver.get("https://balls.bungee.exchange/");
    }

    public static void joinWaitlist(String email){
        input("//*[@id=\"mce-EMAIL\"]", email);
        click("//*[@id=\"mc-embedded-subscribe\"]");
    }

    public static void getBalls() throws InterruptedException {
        jsClick("//button[text()=\"Connect Wallet\"]");
        waitTillVisible("//div[text()=\"MetaMask\"]", 10);
        jsClick("//div[text()=\"MetaMask\"]");


        Thread.sleep(2000);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");
        waitTillVisible("//*[@data-testid=\"page-container-footer-next\"]", 15);
        jsClick("//*[@data-testid=\"page-container-footer-next\"]");
        jsClick("//*[@data-testid=\"page-container-footer-next\"]");
        driver.switchTo().window(windowHandlesList.get(0));

        waitTillVisible("//*[text()=\"Drop Balls\"]", 15);
        jsClick("//*[text()=\"Drop Balls\"]");
        waitTillVisible("//*[text()=\"Congratulations\"]", 15);
    }

}