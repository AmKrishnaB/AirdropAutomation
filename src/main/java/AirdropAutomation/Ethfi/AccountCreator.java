package AirdropAutomation.Ethfi;

import Utility.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.*;

public class AccountCreator extends LaunchBrowser{
    public static List<String> createPhrase() throws InterruptedException {
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");
        Thread.sleep(4000);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowHandlesList.get(1));
        driver.close();
        driver.switchTo().window(windowHandlesList.get(0));
        click("//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large\"]");
        input("(//input[@class=\"form-field__input\"])[1]", "D5ubvcqueviweu@");
        input("(//input[@class=\"form-field__input\"])[2]", "D5ubvcqueviweu@");
        click("//input[@class=\"check-box far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        click("//button[@data-testid=\"secure-wallet-recommended\"]");
        click("//button[@class=\"button btn--rounded btn-primary recovery-phrase__footer--button\"]");
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@data-testid,\"recovery-phrase-chip-\")]"));

        List<String> orderedTextList = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText();
            orderedTextList.add(text);
        }
        return orderedTextList;
    }

    public static String createPhraseAndSignup(){
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/secure-your-wallet");
        click("//*[@data-testid=\"secure-wallet-later\"]");
        click("//*[@data-testid=\"skip-srp-backup-popover-checkbox\"]");
        click("//*[@data-testid=\"skip-srp-backup\"]");
        click("//*[@data-testid=\"onboarding-complete-done\"]");
        click("//*[@data-testid=\"pin-extension-next\"]");
        click("//*[@data-testid=\"pin-extension-done\"]");
        click("//*[@data-testid=\"popover-close\"]");
        click("//*[@data-testid=\"account-options-menu-button\"]");
        click("//*[@data-testid=\"account-list-menu-details\"]");
        String address = getTextToString("(//*[@class=\"mm-box mm-box--display-flex\"])[2]");

        return address;
    }
}
