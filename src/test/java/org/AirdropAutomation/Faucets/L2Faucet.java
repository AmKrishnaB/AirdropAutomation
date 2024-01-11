package org.AirdropAutomation.Faucets;

import Utility.WindowsHelloHandler;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Utility.Actions.*;
import static Utility.LaunchBrowser.driver;

public class L2Faucet {
    public static void claim(String address) throws AWTException, InterruptedException {
        driver.get("https://www.l2faucet.com/");
        click("//*[@class=\"framer-9ag8l5-container\"]");
        click("(//*[@class=\"framer-189a6yp\"])[1]");
        click("(//*[@class=\"framer-189a6yp\"])[2]");
        click("(//*[@class=\"framer-189a6yp\"])[4]");
        click("(//*[@class=\"framer-189a6yp\"])[6]");
        click("(//*[@class=\"framer-189a6yp\"])[8]");
        click("(//*[@class=\"framer-189a6yp\"])[9]");
        click("(//*[@class=\"framer-189a6yp\"])[10]");
        click("(//*[@class=\"framer-189a6yp\"])[11]");
        click("(//*[@class=\"framer-189a6yp\"])[13]");
        click("(//*[@class=\"framer-189a6yp\"])[15]");
        click("//*[@class=\"framer-16wnbb1\"]");
        input("//*[@placeholder=\"Enter your wallet address\"]", address);
        click("//*[text()=\"Get Tokens\"]");
        Thread.sleep(2000);
        WindowsHelloHandler.enterPin();
        Thread.sleep(10000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyPress(KeyEvent.VK_ENTER);
        isDisplayed("//*[text()=\"Tokens in transit\"]");
    }
}
