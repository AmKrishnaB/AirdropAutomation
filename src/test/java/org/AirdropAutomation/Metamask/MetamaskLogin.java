package org.AirdropAutomation.Metamask;

import Utility.LaunchBrowser;
import Utility.PhraseEntry;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static Utility.Actions.click;
import static Utility.Actions.input;

public class MetamaskLogin {
    public static void loginWithPhrase() throws InterruptedException {
        WebDriver driver = LaunchBrowser.webdriverWithMetamask();
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");

        Thread.sleep(5000);
        click("//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-secondary\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        List<String> phrase= List.of("ostrich","gauge","distance","venue","cheap","chronic","pioneer","awake","pink","quantum","gift","fault");
        PhraseEntry.enterPhrase(phrase);
        click("//button[@class=\"button btn--rounded btn-primary btn--large import-srp__confirm-button\"]");
        input("(//input[@class=\"form-field__input\"])[1]", "dubvcquevibuwvubqiweu");
        input("(//input[@class=\"form-field__input\"])[2]", "dubvcquevibuwvubqiweu");
        click("//input[@class=\"check-box far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        Thread.sleep(2000);
        click("//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("(//span[@class=\"mm-box mm-icon mm-icon--size-sm mm-box--display-inline-block mm-box--color-inherit\"])[2]");
        driver.quit();
    }
}
