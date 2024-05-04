package AirdropAutomation.MetaEclipse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static AirdropAutomation.MetaEclipse.credentials.*;
import static Utility.Actions.*;
import static Utility.Actions.input;
import static Utility.LaunchBrowser.driver;

public class metamask {
    public static void createPhraseAndSignup() throws InterruptedException, IOException, UnsupportedFlavorException {
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
        input("(//input[@class=\"form-field__input\"])[1]", "Krishna@123");
        input("(//input[@class=\"form-field__input\"])[2]", "Krishna@123");
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

        credentials.phrase=orderedTextList;

        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/secure-your-wallet");
        click("//*[@data-testid=\"secure-wallet-later\"]");
        click("//*[@data-testid=\"skip-srp-backup-popover-checkbox\"]");
        click("//*[@data-testid=\"skip-srp-backup\"]");
        click("//*[@data-testid=\"onboarding-complete-done\"]");
        click("//*[@data-testid=\"pin-extension-next\"]");
        click("//*[@data-testid=\"pin-extension-done\"]");
        Thread.sleep(2000);
        click("//*[@data-testid=\"popover-close\"]");
        click("//*[@data-testid=\"account-options-menu-button\"]");
        click("//*[@data-testid=\"account-list-menu-details\"]");
        credentials.address = getTextToString("//*[@class=\"mm-box mm-box--display-flex\"]");
        click("//*[text()=\"Show private key\"]");

        input("//*[@id=\"account-details-authenticate\"]", "Krishna@123");
        click("//*[text()=\"Confirm\"]");

        waitTillVisible("(//*[@class=\"mm-box hold-to-reveal-button__absolute-fill\"])[1]", 2);

        WebElement clickable = driver.findElement(By.xpath("(//*[@class=\"mm-box hold-to-reveal-button__absolute-fill\"])[1]"));
        new Actions(driver)
                .clickAndHold(clickable)
                .perform();

        click("//*[@aria-label=\"Copy private key\"]");


        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        privateKey = (String) contents.getTransferData(DataFlavor.stringFlavor);


        System.out.println(privateKey);
        System.out.println(address);
        System.out.println(phrase);
    }
}
