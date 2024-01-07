package org.AirdropAutomation.Aleo;

import Utility.Actions;
import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static Utility.Actions.*;

public class PhraseCreator {
    public static void createPhrase() throws IOException, InterruptedException, UnsupportedFlavorException {
        WebDriver driver = LaunchBrowser.webdriverWithLeo();
        driver.get("chrome-extension://nebnhfamliijlghikdgcigoebonmoibm/fullpage.html");

        Actions.wait(driver, 10);
        click(driver, "(//*[@class=\"flex p-2\"])[1]");
        click(driver, "//*[@class=\"absolute bg-gray-800 rounded-lg flex items-center justify-center cursor-text\"]");
        String phrase= driver.findElement(By.xpath("//*[@id=\"backup-mnemonic\"]")).getText();
        System.out.println(phrase);
        click(driver, "//*[@class=\"h-5 w-auto\"]");
        click(driver, "//*[@id=\"import-link\"]");
        String[] phraseArray=phrase.split(" ");
        for (int i = 0; i < phraseArray.length; i++) {
            input(driver, "//input[@id=\""+i+"\"]",phraseArray[i]);
        }
        click(driver, "//button[text()=\"Next\"]");
        input(driver, "(//input[@type=\"password\"])[1]", "D5ubvcqueviweu@");
        input(driver, "(//input[@type=\"password\"])[2]", "D5ubvcqueviweu@");
        Thread.sleep(1000);
        click(driver, "//*[@class=\"h-6 w-6 flex-shrink-0 bg-black-40 border border-gray-400 rounded-sm overflow-hidden disable-outline-for-click transition ease-in-out duration-200 text-white flex justify-center items-center\"]");
        click(driver, "//button[text()=\"Import\"]");
        click(driver, "//*[@class=\"hover:bg-blue-100 text-black rounded-sm text-sm py-1 px-2 font-tnum leading-none select-none transition ease-in-out duration-300\"]");
        String address = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        System.out.println(address);
        click(driver, "//*[@style=\"cursor: pointer; margin-top: 8px; margin-left: 12px;\"]");
        click(driver, "//div[text()=\"Reveal View Key\"]");
        input(driver, "//input[@type=\"password\"]", "D5ubvcqueviweu@");
        click(driver, "//button[text()=\"Reveal\"]");
        String publicKey= driver.findElement(By.xpath("//*[@id=\"reveal-secret-secret\"]")).getText();
        System.out.println(publicKey);
        click(driver, "//button[@class=\"px-3 py-3 rounded flex text-black font-bold text-shadow-black hover:bg-black hover:bg-opacity-5 transition duration-300 ease-in-out opacity-90 hover:opacity-100\"]");
        click(driver, "//div[text()=\"Reveal Private Key\"]");
        input(driver, "//input[@type=\"password\"]", "D5ubvcqueviweu@");
        click(driver, "//button[text()=\"Reveal\"]");
        String privateKey= driver.findElement(By.xpath("//*[@id=\"reveal-secret-secret\"]")).getText();
        System.out.println(privateKey);
        ExcelWriter.writeStringsToExcel(phrase, address, publicKey, privateKey, System.getProperty("user.dir")+"\\Excel\\LeoWallet\\Phrases\\LeoWallets.xlsx", "Sheet1");
        driver.quit();
    }
}
