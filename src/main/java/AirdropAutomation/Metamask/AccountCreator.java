package AirdropAutomation.Metamask;

import Utility.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.*;

public class AccountCreator extends LaunchBrowser{

    public static final Logger log = LoggerFactory.getLogger(AccountCreator.class);


    public static List<String> createPhraseList() throws InterruptedException {
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");
        Thread.sleep(2000);
        waitTillVisible("//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]", 10);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        if (windowHandlesList.size() > 1) {
            driver.switchTo().window(windowHandlesList.get(1)).close();
            driver.switchTo().window(windowHandlesList.get(0));
        }
        click("//input[@class=\"check-box onboarding__terms-checkbox far fa-square\"]");
        click("//button[@class=\"button btn--rounded btn-primary\"]");
        click("//button[@data-testid=\"metametrics-no-thanks\"]");
        input("(//input[@class=\"form-field__input\"])[1]", "D5ubvcqueviweu@");
        input("(//input[@class=\"form-field__input\"])[2]", "D5ubvcqueviweu@");
        click("//input[@data-testid=\"create-password-terms\"]");
        click("//button[@class=\"button btn--rounded btn-primary btn--large create-password__form--submit-button\"]");
        click("//button[@data-testid=\"secure-wallet-recommended\"]");
        click("//button[@class=\"button btn--rounded btn-primary recovery-phrase__footer--button\"]");
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@data-testid,\"recovery-phrase-chip-\")]"));

        List<String> orderedTextList = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText();
            orderedTextList.add(text);
        }

        System.out.println(orderedTextList);

        return orderedTextList;
    }

    public static String createStringPhrase() throws InterruptedException {
        List<String> orderedTextList = createPhraseList();

        return orderedTextList.toString();
    }



    public static String createPhraseAndSignup(){
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/secure-your-wallet");
        click("//*[@data-testid=\"secure-wallet-later\"]");
        click("//*[@data-testid=\"skip-srp-backup-popover-checkbox\"]");
        click("//*[@data-testid=\"skip-srp-backup\"]");
        click("//*[@data-testid=\"onboarding-complete-done\"]");
        click("//*[@data-testid=\"pin-extension-next\"]");
        click("//*[@data-testid=\"pin-extension-done\"]");
        waitTillVisible("//*[@data-testid=\"account-options-menu-button\"]", 30);
        waitTillClickable("//*[@data-testid=\"account-options-menu-button\"]", 30);
        jsClick("//*[@data-testid=\"account-options-menu-button\"]");
        jsClick("//*[@data-testid=\"account-list-menu-details\"]");
        String address = getTextToString("(//*[@class=\"mm-box mm-box--display-flex\"])[3]");

        System.out.println(address);

        return address;
    }
}
