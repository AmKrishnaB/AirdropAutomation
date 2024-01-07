package org.AirdropAutomation.Metamask;

import Utility.Actions;
import Utility.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Utility.Actions.*;

public class PhraseCreator {
    public static List<String> createPhrase() throws InterruptedException {
        WebDriver driver = LaunchBrowser.webdriverWithMetamask();

        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");

        Actions.wait(10);
        click("//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        input("(//input[@class=\"form-field__input\"])[1]", "D5ubvcqueviweu@");
        input("(//input[@class=\"form-field__input\"])[2]", "D5ubvcqueviweu@");
        click("//input[@class=\"check-box far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        click("//button[@data-testid=\"secure-wallet-recommended\"]");
        Thread.sleep(5000);
        click("//button[@class=\"button btn--rounded btn-primary recovery-phrase__footer--button\"]");
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@data-testid,\"recovery-phrase-chip-\")]"));

        List<String> orderedTextList = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText();
            orderedTextList.add(text);
        }

        driver.quit();
        return orderedTextList;
    }
}
