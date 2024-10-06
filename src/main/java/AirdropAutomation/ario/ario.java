package AirdropAutomation.ario;

import org.openqa.selenium.By;

import static Utility.Actions.*;
import static Utility.LaunchBrowser.driver;

public class ario {
    public static void subscribe(){
        driver.get("https://ar.io/newsletter");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src=\"https://pds-inc.typeform.com/newsletter\"]")));
        waitTillVisible("//*[@type=\"emailVariableStorage\"]", 20);
        input("//*[@type=\"emailVariableStorage\"]", email.address);
        click("//*[@data-qa=\"submit-button deep-purple-submit-button\"]");
        waitTillVisible("//*[text()=\"Success! Keep an eye on that inbox.\"]", 10);
    }
}
