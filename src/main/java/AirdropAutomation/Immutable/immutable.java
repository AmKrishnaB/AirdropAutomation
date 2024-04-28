package AirdropAutomation.Immutable;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.LaunchBrowser.driver;
import static Utility.Actions.*;

public class immutable {
    public static void createWallet(String Email) throws InterruptedException {
        driver.get("https://passport.immutable.com/");
        click("//*[@data-testid=\"login-button\"]");

        Set<String> allWindows1 = driver.getWindowHandles();
        List<String> windowHandlesList1 = new ArrayList<>(allWindows1);
        driver.switchTo().window(windowHandlesList1.get(1));
        input("//*[@data-testid=\"TextInput__input\"]", Email);
        click("//*[@data-testid=\"TextInput__rightButtonsContainer__rightButtCon__icon\"]");
        Thread.sleep(3000);
        emailUtilities.readOtpAndDelete();
        input("//*[@data-testid=\"passwordless_passcode__TextInput--0__input\"]", email.otp);
        click("//*[text()=\"Yes\"]");

        driver.switchTo().window(windowHandlesList1.get(0));
        Thread.sleep(1000);
        driver.get("https://imx.community/gems");
        Thread.sleep(4000);
        click("//*[@data-testid=\"claim-gems__connect-btn\"]");
        waitTillVisible("//*[@data-testid=\"wallet-list-com.immutable.passport__label\"]", 20);
        try {
            click("//*[@data-testid=\"wallet-list-com.immutable.passport__label\"]");
        } catch (Exception e) {
            click("//*[@data-testid=\"close-button__icon\"]");
            click("//*[@data-testid=\"wallet-list-com.immutable.passport__label\"]");
        }

        Set<String> allWindows2 = driver.getWindowHandles();
        List<String> windowHandlesList2 = new ArrayList<>(allWindows2);
        driver.switchTo().window(windowHandlesList2.get(1));
        click("//*[text()=\"Yes\"]");

        Thread.sleep(5000);
        driver.switchTo().window(windowHandlesList2.get(0));
        waitUntilElementDisappears("//*[@data-testid=\"connect-wallet\"]", 20);
        Thread.sleep(1000);
        click("//*[@data-testid=\"claim-gems__get-gems-btn\"]");

        Set<String> allWindows3 = driver.getWindowHandles();
        List<String> windowHandlesList3 = new ArrayList<>(allWindows3);
        driver.switchTo().window(windowHandlesList3.get(1));
        waitTillVisible("//*[text()=\"Accept\"]", 10);
        click("//*[text()=\"Accept\"]");
        driver.switchTo().window(windowHandlesList3.get(0));
        waitTillVisible("//*[text()=\"Daily Gem Claimed\"]", 10);
    }

    public static void collectGem() throws InterruptedException {
        driver.get("https://imx.community/gems");
        Thread.sleep(2000);
        click("//*[@data-testid=\"claim-gems__connect-btn\"]");
        waitTillVisible("//*[@data-testid=\"wallet-list-com.immutable.passport__label\"]", 20);
        click("//*[@data-testid=\"wallet-list-com.immutable.passport__label\"]");

        Set<String> allWindows2 = driver.getWindowHandles();
        List<String> windowHandlesList2 = new ArrayList<>(allWindows2);
        driver.switchTo().window(windowHandlesList2.get(1));
        input("//*[@data-testid=\"TextInput__input\"]", email.address);
        click("//*[@data-testid=\"TextInput__rightButtonsContainer__rightButtCon__icon\"]");
        Thread.sleep(3000);
        emailUtilities.readOtpAndDelete();
        input("//*[@data-testid=\"passwordless_passcode__TextInput--0__input\"]", email.otp);

        driver.switchTo().window(windowHandlesList2.get(0));
        waitUntilElementDisappears("//*[@data-testid=\"connect-wallet\"]", 20);
        Thread.sleep(1000);

        if (driver.findElement(By.xpath("//*[@data-testid=\"claim-gems__get-gems-btn\"]")).isDisplayed()){
            click("//*[@data-testid=\"claim-gems__get-gems-btn\"]");

            Set<String> allWindows3 = driver.getWindowHandles();
            List<String> windowHandlesList3 = new ArrayList<>(allWindows3);
            driver.switchTo().window(windowHandlesList3.get(1));
            waitTillVisible("//*[text()=\"Accept\"]", 20);
            click("//*[text()=\"Accept\"]");
            driver.switchTo().window(windowHandlesList3.get(0));
            waitTillVisible("//*[text()=\"Daily Gem Claimed\"]", 10);
        } else {
            System.out.println("Gem already collected");
        }
    }
}