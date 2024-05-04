package AirdropAutomation.Immutable;

import Utility.ExcelReader;
import Utility.LaunchBrowser;

import java.io.IOException;

import static Utility.LaunchBrowser.driver;

public class dailyRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[][] emailArray = ExcelReader.readExcelAsArray(System.getProperty("user.dir") + "\\Excel\\Immutable\\immutabler.xlsx");
        int rowSize = emailArray.length;

        for (int i = 670; i < emailArray.length; i++) {
            LaunchBrowser.driver = LaunchBrowser.webdriver();
            driver.manage().window().maximize();
            String[] strings = emailArray[i];
            try {
                email.address = strings[0];
                email.token = strings[1];
                immutable.collectGem();
                System.out.println("Gem collected in account no: "+ i +", with email id: "+email.address);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("_______________________Error in account no: "+ i +", with email id: "+email.address);
                i--;
            } finally {
                driver.quit();
            }
        }
        System.exit(0);
    }
}
