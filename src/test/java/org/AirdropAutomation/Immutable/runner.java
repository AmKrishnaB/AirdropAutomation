package org.AirdropAutomation.Immutable;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;

import static Utility.LaunchBrowser.driver;

public class runner {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            LaunchBrowser.driver = LaunchBrowser.webdriver();
            driver.manage().window().maximize();
            try {
                emailUtilities.randomEmailGen();
                emailUtilities.createAccount();
                emailUtilities.createToken();
                immutable.createWallet(email.address);
                ExcelWriter.writeAddressAndTokenToExcel(email.address, email.token, System.getProperty("user.dir") + "\\Excel\\Immutable\\immutable.xlsx", "Sheet1");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
        System.exit(0);
    }
}