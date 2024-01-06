package org.AirdropAutomation;

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

        Actions.wait(driver, 10);
        click(driver, "//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        input(driver, "(//input[@class=\"form-field__input\"])[1]", "dubvcquevibuwvubqiweu");
        input(driver, "(//input[@class=\"form-field__input\"])[2]", "dubvcquevibuwvubqiweu");
        click(driver, "//input[@class=\"check-box far fa-square\"]");
        click(driver, "//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        click(driver, "//button[@data-testid=\"secure-wallet-recommended\"]");
        Thread.sleep(5000);
        click(driver, "//button[@class=\"button btn--rounded btn-primary recovery-phrase__footer--button\"]");
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
