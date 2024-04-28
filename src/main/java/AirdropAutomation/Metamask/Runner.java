package AirdropAutomation.Metamask;

import AirdropAutomation.setter.Setter;
import Utility.ExcelReader;
import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import AirdropAutomation.Faucets.L2Faucet;

import java.util.List;

import static Utility.LaunchBrowser.driver;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        setter();
    }

    public static void normal(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("Account "+i);
            LaunchBrowser.driver =LaunchBrowser.webdriverWithMetamask();
            driver.manage().window().maximize();
            try {
                List<String> phrase = AccountCreator.createPhrase();
                String address = AccountCreator.createPhraseAndSignup();
                L2Faucet.claim(address);
                ExcelWriter.writeListAndStringToExcel(phrase, address, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
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
                List<String> phrase = AccountCreator.createPhrase();
                String address = AccountCreator.createPhraseAndSignup();
                ExcelWriter.writeListAndStringToExcel(phrase, address, System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }

    public static void setter() throws InterruptedException {
        driver = LaunchBrowser.webdriverWithMetamask();
        driver.manage().window().maximize();
        List<String> phrase = ExcelReader.undonePhrase(System.getProperty("user.dir")+"\\Excel\\Metamask\\phrase.xlsx", "Sheet1");
        MetamaskLogin.loginWithPhrase(phrase);
        Setter.getSetter();
        driver.quit();
    }
}
