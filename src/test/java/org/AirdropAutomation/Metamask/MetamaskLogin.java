package org.AirdropAutomation.Metamask;

import Utility.LaunchBrowser;
import Utility.PhraseEntry;

import java.util.List;

import static Utility.Actions.click;
import static Utility.Actions.input;

public class MetamaskLogin extends LaunchBrowser{
    public static void loginWithPhrase(List<String> phrase){
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");

        click("//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-secondary\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        PhraseEntry.enterPhrase(phrase);
        click("//button[@class=\"button btn--rounded btn-primary btn--large import-srp__confirm-button\"]");
        input("(//input[@class=\"form-field__input\"])[1]", "dubvcquevibuwvubqiweu");
        input("(//input[@class=\"form-field__input\"])[2]", "dubvcquevibuwvubqiweu");
        click("//input[@class=\"check-box far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("(//span[@class=\"mm-box mm-icon mm-icon--size-sm mm-box--display-inline-block mm-box--color-inherit\"])[2]");
    }
}
