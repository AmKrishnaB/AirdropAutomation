package org.AirdropAutomation.Aleo;

import Utility.ExcelReader;
import Utility.ExcelWriter;

import static Utility.LaunchBrowser.driver;
import static Utility.LaunchBrowser.webdriverWithLeo;

public class Runner {

    public static void generate() {
        for (int i = 0; i < 50; i++) {
            driver = webdriverWithLeo();
            driver.manage().window().maximize();
            try {
                String[] wallet = PhraseCreator.createPhrase();
                ExcelWriter.writeStringsToExcel(wallet, System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }


//    public static void generate() {
//        driver = webdriverWithLeo();
//        driver.manage().window().maximize();
//        try {
//            String[] wallet = PhraseCreator.createPhrase();
//            ExcelWriter.writeStringsToExcel(wallet, System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1");
//        }
//        catch (Exception ignored){}
//        finally {
//            driver.quit();
//        }
//    }

    public static Runnable generateMultiThread() {
        for (int i = 0; i < 50; i++) {
            driver = webdriverWithLeo();
            driver.manage().window().maximize();
            try {
                String[] wallet = PhraseCreator.createPhrase();
                ExcelWriter.writeStringsToExcel(wallet, System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
        return null;
    }

    public static void generateAndClaim() {
        for (int i = 0; i < 50; i++) {
            driver = webdriverWithLeo();
            driver.manage().window().maximize();
            try {
                String[] wallet = PhraseCreator.createPhrase();
                AleoSwap.claim();
                ExcelWriter.writeStringsToExcel(wallet, System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1");
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }

    public static void loginAndClaim(){
        for (int i = 1; i < 5; i++) {
            int currentRow=i;
            driver = webdriverWithLeo();
            driver.manage().window().maximize();
            try {
                String phrase = ExcelReader.readOneCellPhrase(System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1",currentRow);
                System.out.println(phrase);
                LeoLogin.enterPhrase(phrase);
                AleoSwap.claim();
                ExcelWriter.writeDoneToExcel(System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1",currentRow,4);
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }
    public static void loginAndClaimMultiThread(int sheetNumber){
        for (int i = 1; i < 5; i++) {
            int currentRow=i;
            driver = webdriverWithLeo();
            driver.manage().window().maximize();
            try {
                String phrase = ExcelReader.readOneCellPhrase(System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet"+sheetNumber ,currentRow);
                System.out.println(phrase);
                LeoLogin.enterPhrase(phrase);
                AleoSwap.claim();
                ExcelWriter.writeDoneToExcel(System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet"+sheetNumber ,currentRow,4);
            }
            catch (Exception ignored){}
            finally {
                driver.quit();
            }
        }
    }
}
