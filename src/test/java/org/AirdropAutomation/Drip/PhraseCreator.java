package org.AirdropAutomation.Drip;


import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.*;
import static Utility.LaunchBrowser.driver;

public class PhraseCreator {
    public static String[] copyPhrase(){
        driver.get("chrome-extension://bfnaelmomeimhlpmgjnjophhpkkoljpa/onboarding.html");
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowHandlesList.get(1));
        driver.close();
        driver.switchTo().window(windowHandlesList.get(0));
        click("//*[@data-testid=\"create-wallet-button\"]");
        input("//*[@data-testid=\"onboarding-form-password-input\"]", "D5ubvcqueviweu@");
        input("//*[@data-testid=\"onboarding-form-confirm-password-input\"]", "D5ubvcqueviweu@");
        click("//*[@data-testid=\"onboarding-form-terms-of-service-checkbox\"]/..");
        click("//*[@data-testid=\"onboarding-form-submit-button\"]");
        click("(//*[@fill=\"white\"])[3]");
        String[] phrase = new String[12];
        for (int i = 0; i <= 11; i++) {
            String word = driver.findElement(By.xpath("//*[@data-testid=\"secret-recovery-phrase-word-input-" + i + "\"]")).getAttribute("value");
            phrase[i]=word;
        }
//
//        click("//*[@data-testid=\"onboarding-form-saved-secret-recovery-phrase-checkbox\"]/..");
//        click("//*[@data-testid=\"onboarding-form-submit-button\"]");
//        driver.get("chrome-extension://bfnaelmomeimhlpmgjnjophhpkkoljpa/popup.html");
        return phrase;
    }

    public static String[] getAddress(){
        driver.get("chrome-extension://bfnaelmomeimhlpmgjnjophhpkkoljpa/popup.html");
        click("//*[@class=\"sc-hUpaCq sc-fDMmqs VINUJ fNhcqD\"]");
        click("//p[text()=\"Account Addresses\"]");
        click("(//*[@class=\"sc-jrQzAO fzOokz sc-iaUyqC gvIgqC\"])[1]");
        String solana = getTextToString("//*[@class=\"sc-jNhWkn iVvvvm\"]/textarea");
        click("//button[text()=\"Close\"]");
        click("(//*[@class=\"sc-jrQzAO fzOokz sc-iaUyqC gvIgqC\"])[2]");
        String eth = getTextToString("//*[@class=\"sc-jNhWkn iVvvvm\"]/textarea");
        click("//button[text()=\"Close\"]");
        click("(//*[@class=\"sc-jrQzAO fzOokz sc-iaUyqC gvIgqC\"])[3]");
        String polygon = getTextToString("//*[@class=\"sc-jNhWkn iVvvvm\"]/textarea");
        click("//button[text()=\"Close\"]");

        waitTillVisible("(//*[@class=\"sc-jrQzAO fzOokz sc-iaUyqC gvIgqC\"])[1]",5);

        click("//button[text()=\"Close\"]");

        click("//p[text()=\"Show Private Key\"]");
        input("//*[@placeholder=\"Password\"]", "D5ubvcqueviweu@");
        click("//*[@type=\"checkbox\"]/..");
        click("//*[@data-testid=\"primary-button\"]");

        click("(//*[@class=\"sc-jounMn kGsrJs\"])[1]");
        String solKey = getTextToString("//*[@class=\"sc-jJoQJp sc-hiCibw sc-ctKHVw jAKFEW hHrFfF dMgbvK\"]");
        click("//*[@data-testid=\"header--back\"]");

        click("(//*[@class=\"sc-jounMn kGsrJs\"])[2]");
        String ethKey = getTextToString("//*[@class=\"sc-jJoQJp sc-hiCibw sc-ctKHVw jAKFEW hHrFfF dMgbvK\"]");
        click("//*[@data-testid=\"header--back\"]");

        click("(//*[@class=\"sc-jounMn kGsrJs\"])[3]");
        String polKey = getTextToString("//*[@class=\"sc-jJoQJp sc-hiCibw sc-ctKHVw jAKFEW hHrFfF dMgbvK\"]");
        click("//*[@data-testid=\"header--back\"]");


        return new String[]{solana, eth, polygon, solKey, ethKey, polKey};
    }
}
