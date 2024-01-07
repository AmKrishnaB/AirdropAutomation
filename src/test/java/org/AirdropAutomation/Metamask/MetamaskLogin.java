package org.AirdropAutomation.Metamask;

import Utility.Actions;
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
        click(driver, "//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-secondary\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        List<String> phrase= List.of("ostrich","gauge","distance","venue","cheap","chronic","pioneer","awake","pink","quantum","gift","fault");
        PhraseEntry.enterPhrase(driver, phrase);
        click(driver, "//button[@class=\"button btn--rounded btn-primary btn--large import-srp__confirm-button\"]");
        input(driver, "(//input[@class=\"form-field__input\"])[1]", "dubvcquevibuwvubqiweu");
        input(driver, "(//input[@class=\"form-field__input\"])[2]", "dubvcquevibuwvubqiweu");
        click(driver, "//input[@class=\"check-box far fa-square\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        Thread.sleep(2000);
        click(driver, "//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary\"]");
        click(driver, "(//span[@class=\"mm-box mm-icon mm-icon--size-sm mm-box--display-inline-block mm-box--color-inherit\"])[2]");
        driver.quit();
    }
}
