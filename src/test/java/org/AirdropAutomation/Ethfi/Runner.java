package org.AirdropAutomation.Ethfi;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import org.AirdropAutomation.Ethfi.AccountCreator;
import java.util.List;

import static Utility.LaunchBrowser.driver;

public class Runner {
    public static void main(String[] args){
        createAcc();
    }

    public static void normal(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("Account "+i);
            LaunchBrowser.driver =LaunchBrowser.webdriverWithMetamask();
            driver.manage().window().maximize();
            try {
                List<String> phrase = org.AirdropAutomation.Ethfi.AccountCreator.createPhrase();
                String address = org.AirdropAutomation.Ethfi.AccountCreator.createPhraseAndSignup();

                ethFi.ethFiCreate();

                ExcelWriter.writeListAndStringToExcel(phrase, address, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
            }
            catch (Exception e){
                System.out.println(e);
            }
            finally {
                driver.quit();
            }
        }
    }

    public static void createAcc(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("Account "+i);
            try {
                driver = LaunchBrowser.webdriverWithMetamask();
                driver.manage().window().maximize();
                List<String> phrase = org.AirdropAutomation.Ethfi.AccountCreator.createPhrase();
                String address = AccountCreator.createPhraseAndSignup();
                ExcelWriter.writeListAndStringToExcel(phrase, address, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }
}
