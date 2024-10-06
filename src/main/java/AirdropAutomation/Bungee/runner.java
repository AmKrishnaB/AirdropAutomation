package AirdropAutomation.Bungee;

import Utility.emailUtilities;
import Utility.emailVariableStorage;
import AirdropAutomation.Metamask.AccountCreator;
import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import static Utility.LaunchBrowser.driver;

public class runner {
    public static void main(String[] args) {
        int count=1;
        for (int i = 1; i <= 500; i++) {
            LaunchBrowser.driver =LaunchBrowser.webdriverWithMetamask();
            driver.manage().window().maximize();
            try {
                emailUtilities.randomEmailGen();
                emailUtilities.createAccount();
                emailUtilities.createToken();
                String phrase= AccountCreator.createStringPhrase();
                String address = AccountCreator.createPhraseAndSignup();
                bungee.loadBungee();
                bungee.joinWaitlist(emailVariableStorage.address);
                bungee.getBalls();
                ExcelWriter.writeFourStringsToExcel(emailVariableStorage.address, emailVariableStorage.token, phrase, address, System.getProperty("user.dir") + "\\Excel\\Bungee\\balls.xlsx", "Sheet1");
                System.out.println("Current count: "+i);
                System.out.println("Current success count: "+count);
                count++;
            } catch (Exception e) {
                System.out.println("An error occurred: "+e);
            } finally {
                driver.quit();
            }
        }
        System.exit(0);
    }

}