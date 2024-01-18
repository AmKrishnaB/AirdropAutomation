package org.AirdropAutomation.Drip;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;

import static Utility.LaunchBrowser.driver;

public class Runner {
    public static void main(String[] args) {
        int j=0;
        for (int i = 0; i < 5000; i++) {
            System.out.println("Count-"+j+"/"+i);
            try {
                driver = LaunchBrowser.webdriverWithPhantom();
                driver.manage().window().maximize();
                String[] phrase = PhraseCreator.copyPhrase();
                ExcelWriter.writePhraseArrayToExcel(phrase,System.getProperty("user.dir")+"\\Excel\\Phantom\\phrase.xlsx", "Sheet1");
                j++;
            } catch (Exception ignored) {
            }
            finally {
                driver.quit();
            }
        }
    }
}
