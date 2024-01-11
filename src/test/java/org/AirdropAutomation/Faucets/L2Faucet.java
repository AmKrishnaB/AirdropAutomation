package org.AirdropAutomation.Faucets;

import static Utility.Actions.click;
import static Utility.Actions.input;
import static Utility.LaunchBrowser.driver;

public class L2Faucet {
    public static void claim(String address){
        driver.get("https://www.l2faucet.com/");
        click("//*[@class=\"framer-9ag8l5-container\"]");
        click("(//*[@class=\"framer-189a6yp\"])[1]");
        click("(//*[@class=\"framer-189a6yp\"])[5]");
        click("(//*[@class=\"framer-189a6yp\"])[6]");
        click("(//*[@class=\"framer-189a6yp\"])[7]");
        click("(//*[@class=\"framer-189a6yp\"])[8]");
        click("(//*[@class=\"framer-189a6yp\"])[9]");
        click("(//*[@class=\"framer-189a6yp\"])[10]");
        click("(//*[@class=\"framer-189a6yp\"])[11]");
        click("(//*[@class=\"framer-189a6yp\"])[12]");
        click("(//*[@class=\"framer-189a6yp\"])[13]");
        click("//*[@class=\"framer-16wnbb1\"]");
        input("//*[@placeholder=\"Enter your wallet address\"]", address);
        click("//*[text()=\"Get Tokens\"]");
    }
}
