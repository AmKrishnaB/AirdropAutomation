package org.AirdropAutomation.Aleo;

import Utility.Actions;
import Utility.LaunchBrowser;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utility.Actions.*;

public class PhraseCreator extends LaunchBrowser{

    public static String[] createPhrase() throws IOException, InterruptedException, UnsupportedFlavorException {
        driver.get("chrome-extension://nebnhfamliijlghikdgcigoebonmoibm/fullpage.html");

        Actions.wait(10);
        click("(//*[@class=\"flex p-2\"])[1]");
        click("//*[@class=\"absolute bg-gray-800 rounded-lg flex items-center justify-center cursor-text\"]");
        Set<String> allWindows = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);
        driver.switchTo().window(windowHandlesList.get(1));
        driver.close();
        driver.switchTo().window(windowHandlesList.get(0));
        String phrase= driver.findElement(By.xpath("//*[@id=\"backup-mnemonic\"]")).getText();
        System.out.println(phrase);
        click("//*[@class=\"h-5 w-auto\"]");
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
        click("//*[@class=\"hover:bg-blue-100 text-black rounded-sm text-sm py-1 px-2 font-tnum leading-none select-none transition ease-in-out duration-300\"]");
        String address = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        System.out.println(address);
        click("//*[@style=\"cursor: pointer; margin-top: 8px; margin-left: 12px;\"]");
        click("//div[text()=\"Reveal View Key\"]");
        input("//input[@type=\"password\"]", "D5ubvcqueviweu@");
        click("//button[text()=\"Reveal\"]");
        String publicKey= driver.findElement(By.xpath("//*[@id=\"reveal-secret-secret\"]")).getText();
        System.out.println(publicKey);
        click("//button[@class=\"px-3 py-3 rounded flex text-black font-bold text-shadow-black hover:bg-black hover:bg-opacity-5 transition duration-300 ease-in-out opacity-90 hover:opacity-100\"]");
        click("//div[text()=\"Reveal Private Key\"]");
        input("//input[@type=\"password\"]", "D5ubvcqueviweu@");
        click("//button[text()=\"Reveal\"]");
        String privateKey= driver.findElement(By.xpath("//*[@id=\"reveal-secret-secret\"]")).getText();
        System.out.println(privateKey);
        String[] result = new String[4];
        result[0]=phrase;
        result[1]=address;
        result[2]=publicKey;
        result[3]=privateKey;
        return result;
    }
}
