package org.AirdropAutomation.Immutable;

import Utility.LaunchBrowser;

import static Utility.LaunchBrowser.driver;

public class runner {
    public static void main(String[] args) throws InterruptedException {
        LaunchBrowser.driver =LaunchBrowser.webdriver();
        driver.manage().window().maximize();
        emailUtilities.randomEmailGen();
        emailUtilities.createAccount();
        emailUtilities.createToken();
        immutable.createWallet(email.address);
        driver.quit();
        System.exit(0);
    }
}
