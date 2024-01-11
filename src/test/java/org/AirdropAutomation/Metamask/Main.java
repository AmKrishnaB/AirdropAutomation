package org.AirdropAutomation.Metamask;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import org.AirdropAutomation.Faucets.L2Faucet;

import java.awt.*;
import java.util.List;

import static Utility.LaunchBrowser.driver;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        LaunchBrowser.driver =LaunchBrowser.webdriverWithMetamask();
        driver.manage().window().maximize();
        List<String> phrase = AccountCreator.createPhrase();
        String address = AccountCreator.createPhraseAndSignup();
        L2Faucet.claim(address);
        ExcelWriter.writeListAndStringToExcel(phrase, address, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
        driver.quit();
    }
}
