package AirdropAutomation.Immutable;

import Utility.ExcelReader;
import Utility.LaunchBrowser;
import Utility.emailVariableStorage;

import java.io.IOException;

import static Utility.LaunchBrowser.driver;

public class dailyRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[][] emailArray = ExcelReader.readExcelAsArray(System.getProperty("user.dir") + "\\Excel\\Immutable\\immutabler.xlsx");
        int rowSize = emailArray.length;

        for (int i = 0; i < emailArray.length; i++) {
            LaunchBrowser.driver = LaunchBrowser.webdriver();
            driver.manage().window().maximize();
            String[] strings = emailArray[i];
            try {
                emailVariableStorage.address = strings[0];
                emailVariableStorage.token = strings[1];
                immutable.collectGem();
                System.out.println("Gem collected in account no: "+ i +", with emailVariableStorage id: "+ emailVariableStorage.address);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("_______________________Error in account no: "+ i +", with emailVariableStorage id: "+ emailVariableStorage.address);
                i--;
            } finally {
                driver.quit();
            }
        }
        System.exit(0);
    }
}
