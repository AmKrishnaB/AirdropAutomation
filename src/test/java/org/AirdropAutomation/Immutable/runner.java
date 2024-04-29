package org.AirdropAutomation.Immutable;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;

import static Utility.LaunchBrowser.driver;

public class runner {
    public static void main(String[] args) {
        int count=0;
        for (int i = 0; i < 500; i++) {
            LaunchBrowser.driver =LaunchBrowser.webdriver();
            driver.manage().window().maximize();
            try {
                emailUtilities.randomEmailGen();
                emailUtilities.createAccount();
                emailUtilities.createToken();
                immutable.claimWithCreateWallet();
                ExcelWriter.writeAddressAndTokenToExcel(email.address, email.token, System.getProperty("user.dir") + "\\Excel\\Immutable\\immutable.xlsx", "Sheet1");
                System.out.println("Current count: "+i);
                System.out.println("Current success count: "+count);
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
        System.exit(0);
    }
}