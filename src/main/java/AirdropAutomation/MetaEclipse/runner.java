package AirdropAutomation.MetaEclipse;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import static Utility.LaunchBrowser.driver;

public class runner {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            LaunchBrowser.driver =LaunchBrowser.webdriverWithMetamask();
            try {
                driver.manage().window().maximize();
                metamask.createPhraseAndSignup();
                ExcelWriter.writePhraseAddressKeyToExcel(credentials.phrase, credentials.address, credentials.privateKey, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
        System.exit(0);
    }
}
