package org.AirdropAutomation.Drip;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;

import static Utility.LaunchBrowser.driver;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            driver = LaunchBrowser.webdriverWithPhantom();
            driver.manage().window().maximize();
            try {
                String[] phrase = PhraseCreator.copyPhrase();
                ExcelWriter.writePhraseArrayToExcel(phrase,System.getProperty("user.dir")+"\\Excel\\Phantom\\phrase.xlsx", "Sheet1");
            } catch (Exception ignored) {
            }
            finally {
                driver.quit();
            }
        }
    }
}
