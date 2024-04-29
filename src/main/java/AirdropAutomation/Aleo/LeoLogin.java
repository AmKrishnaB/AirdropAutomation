package AirdropAutomation.Aleo;

import Utility.Actions;
import Utility.LaunchBrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.click;
import static Utility.Actions.input;

public class LeoLogin extends LaunchBrowser {
    public static void enterPhrase(String phrase) throws InterruptedException {
        driver.get("chrome-extension://nebnhfamliijlghikdgcigoebonmoibm/fullpage.html");

        Actions.wait(10);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowHandlesList.get(1));
        driver.close();
        driver.switchTo().window(windowHandlesList.get(0));
        click("//*[@id=\"import-link\"]");
        String[] phraseArray=phrase.split(" ");
        for (int i = 0; i < phraseArray.length; i++) {
            input("//input[@id=\""+i+"\"]",phraseArray[i]);
        }
        click("//button[text()=\"Next\"]");
        input("(//input[@type=\"password\"])[1]", "D5ubvcqueviweu@");
        input("(//input[@type=\"password\"])[2]", "D5ubvcqueviweu@");
        Thread.sleep(1000);
        click("//*[@class=\"h-6 w-6 flex-shrink-0 bg-black-40 border border-gray-400 rounded-sm overflow-hidden disable-outline-for-click transition ease-in-out duration-200 text-white flex justify-center items-center\"]");
        click("//button[text()=\"Import\"]");
    }
}
