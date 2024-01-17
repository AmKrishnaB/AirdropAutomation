package org.AirdropAutomation.Metamask;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import org.AirdropAutomation.Faucets.L2Faucet;

import java.util.List;

import static Utility.LaunchBrowser.driver;

public class Main {
    public static void main(String[] args){
        for (int i = 0; i < 1000; i++) {
            System.out.println("Account "+i);
            LaunchBrowser.driver =LaunchBrowser.webdriverWithMetamask();
            driver.manage().window().maximize();
            try {
                List<String> phrase = AccountCreator.createPhrase();
                String address = AccountCreator.createPhraseAndSignup();
                L2Faucet.claim(address);
                ExcelWriter.writeListAndStringToExcel(phrase, address, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }
}
