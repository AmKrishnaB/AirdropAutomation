package org.AirdropAutomation.setter;

import Utility.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.click;
import static Utility.Actions.input;
import static Utility.LaunchBrowser.driver;

public class Setter {
    public static void getSetter() throws InterruptedException {
        driver.get("https://www.setter.co/reserve");
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@src=\"https://setter-web-app.onrender.com/reserve?embed=true\"])[1]")));
        click("//*[@data-testid=\"rk-connect-button\"]");
        Thread.sleep(2000);
        click("//div[@class=\"iekbcc0\" and text()=\"MetaMask\"]/../..");
        Thread.sleep(2000);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");
        click("//*[@data-testid=\"page-container-footer-next\"]");
        click("//*[@data-testid=\"page-container-footer-next\"]");
        driver.switchTo().window(windowHandlesList.get(0));
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@src=\"https://setter-web-app.onrender.com/reserve?embed=true\"])[1]")));
        input("//*[@name=\"username\"]", Username.random(10));
        click("//button[text()=\"Reserve\"]");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");
        click("//button[text()=\"Sign\"]");
    }
}
