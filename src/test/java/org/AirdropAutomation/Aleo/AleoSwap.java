package org.AirdropAutomation.Aleo;

import Utility.LaunchBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.*;

public class AleoSwap extends LaunchBrowser {
    public static void swapper() throws InterruptedException {
        driver.navigate().to("https://app.aleoswap.org/swap/public");
        click("//span[@class=\"text-xs lg:text-sm\"]");
        click("(//span[@class=\"text-base font-semibold\"])[1]");
        Thread.sleep(3000);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowHandlesList.get(1));
        click("//div[@class=\"h-6 w-6 flex-shrink-0 bg-black-40 border border-gray-400 rounded-sm overflow-hidden disable-outline-for-click transition ease-in-out duration-200 text-white flex justify-center items-center\"]");
        click("//button[@class=\"relative px-8 rounded-lg bg-blue-400 flex items-center text-white text-sm font-semibold transition duration-200 ease-in-out hover:opacity-90 focus:opacity-90 hover:bg-gradient-to-r hover:from-#472AA0 hover:from-0% hover:to-10% w-full justify-center justify-center rounded-lg py-3\"]");
        driver.switchTo().window(windowHandlesList.get(0));
        //click("//*[@class=\"text-lg lg:hidden\"]");//small window hamburger button
        click("//*[@class=\"inner\"  and text()=\"Faucet\"]");
        click("(//button[@class=\"text-primary-500 hover:underline\"])[1]");
        Thread.sleep(10000);
        Set<String> allWindows1 = driver.getWindowHandles();
        List<String> windowHandlesList1 = new ArrayList<>(allWindows1);
        driver.switchTo().window(windowHandlesList1.get(1));
        click("//Button[text()=\"Confirm\"]");
        driver.switchTo().window(windowHandlesList1.get(0));
        waitTillVisible("//span[text()=\"Completed\"]", 60000);
        click("//*[@transform=\"translate(-593 -779.5)\"]");

        click("(//button[@class=\"text-primary-500 hover:underline\"])[2]");
        Thread.sleep(10000);
        Set<String> allWindows2 = driver.getWindowHandles();
        List<String> windowHandlesList2 = new ArrayList<>(allWindows2);
        driver.switchTo().window(windowHandlesList2.get(2));
        click("//Button[text()=\"Confirm\"]");
        driver.switchTo().window(windowHandlesList2.get(0));
        waitTillVisible("//span[text()=\"Completed\"]", 60000);
        click("//*[@transform=\"translate(-593 -779.5)\"]");

        click("(//button[@class=\"text-primary-500 hover:underline\"])[3]");
        Thread.sleep(10000);
        Set<String> allWindows3 = driver.getWindowHandles();
        List<String> windowHandlesList3 = new ArrayList<>(allWindows3);
        driver.switchTo().window(windowHandlesList3.get(2));
        click("//Button[text()=\"Confirm\"]");
        driver.switchTo().window(windowHandlesList3.get(0));
        waitTillVisible("//span[text()=\"Completed\"]", 60000);
        click("//*[@transform=\"translate(-593 -779.5)\"]");
    }
}
