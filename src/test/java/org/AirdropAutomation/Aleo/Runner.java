package org.AirdropAutomation.Aleo;

import Utility.ExcelWriter;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static Utility.LaunchBrowser.driver;
import static Utility.LaunchBrowser.webdriverWithLeo;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedFlavorException {
        for (int i = 0; i < 50; i++) {
            driver = webdriverWithLeo();
            driver.manage().window().maximize();
            String[] wallet = PhraseCreator.createPhrase();
            AleoSwap.swapper();
            ExcelWriter.writeStringsToExcel(wallet, System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1");
            driver.quit();
        }
    }
}
