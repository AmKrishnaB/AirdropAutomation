package org.AirdropAutomation.Immutable;

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
//        Awaitility.await().atLeast(Duration.ofSeconds(2));
        Thread.sleep(2000);
        emailUtilities.readOtpAndDelete();
        input("//*[@data-testid=\"passwordless_passcode__TextInput--0__input\"]", email.otp);
        click("//*[text()=\"Yes\"]");

        driver.switchTo().window(windowHandlesList1.get(0));
        driver.get("https://imx.community/gems");
        Thread.sleep(2000);
        click("//*[@data-testid=\"claim-gems__connect-btn\"]");
        click("//*[@data-testid=\"wallet-list-com.immutable.passport__label\"]");

        Set<String> allWindows2 = driver.getWindowHandles();
        List<String> windowHandlesList2 = new ArrayList<>(allWindows2);
        driver.switchTo().window(windowHandlesList2.get(1));
        click("//*[text()=\"Yes\"]");

        Thread.sleep(5000);
        driver.switchTo().window(windowHandlesList2.get(0));
        waitUntilElementDisappears("//*[@data-testid=\"connect-wallet\"]", 20);
        waitTillClickable("//*[@data-testid=\"claim-gems__get-gems-btn\"]", 10);
        click("//*[@data-testid=\"claim-gems__get-gems-btn\"]");

        Set<String> allWindows3 = driver.getWindowHandles();
        List<String> windowHandlesList3 = new ArrayList<>(allWindows3);
        driver.switchTo().window(windowHandlesList3.get(1));
        click("//*[text()=\"Accept\"]");
        driver.switchTo().window(windowHandlesList3.get(0));
        waitTillVisible("//*[@data-testid=\"claimed__next-in\"]", 10);
        
    }

}
