package AirdropAutomation.Ethfi;

import Utility.LaunchBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.click;

public class ethFi extends LaunchBrowser {
    public static void ethFiCreate(){
        driver.get("https://app.ether.fi/eeth?address=0x71924dE6B96Dd6508e5EdDD076C2cb956Ce1c199");
        click("//*[@class=\"chakra-button css-mnibci\"]");
        click("//*[@class=\"chakra-button css-1kwxdgo\"]");
        click("//*[text()=\"MetaMask\"]");

        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowHandlesList.get(1));








//        driver.close();
//        driver.switchTo().window(windowHandlesList.get(0));
    }
}
