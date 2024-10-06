package AirdropAutomation.Immutable;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import Utility.emailVariableStorage;
import Utility.emailUtilities;

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
                ExcelWriter.writeAddressAndTokenToExcel(emailVariableStorage.address, emailVariableStorage.token, System.getProperty("user.dir") + "\\Excel\\Immutable\\immutable.xlsx", "Sheet2");
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