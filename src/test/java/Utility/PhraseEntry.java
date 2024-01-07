package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PhraseEntry {
    public static void enterPhrase(WebDriver driver, List<String> phrase){
        List<WebElement> textBoxes= driver.findElements(By.xpath("//input[@class=\"MuiInputBase-input MuiInput-input\"]"));
        for (int i = 0; i < textBoxes.size(); i++) {
            textBoxes.get(i).sendKeys(phrase.get(i));
        }
    }
}
