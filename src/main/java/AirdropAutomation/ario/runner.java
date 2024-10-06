package AirdropAutomation.ario;


import Utility.ExcelReader;
import Utility.LaunchBrowser;

import java.io.IOException;

import static Utility.LaunchBrowser.driver;

public class runner {
    public static void main(String[] args) throws IOException {
        String[][] emailArray = ExcelReader.readExcelAsArray(System.getProperty("user.dir") + "\\Excel\\Immutable\\immutabler.xlsx");
        int rowSize = emailArray.length;

        for (int i = 0; i < emailArray.length; i++) {
            LaunchBrowser.driver = LaunchBrowser.webdriver();
            driver.manage().window().maximize();
            String[] strings = emailArray[i];
            try {
                email.address = strings[0];
                ario.subscribe();
                System.out.println("Ario Subscribed in acc no: "+ i +", with emailVariableStorage id: "+email.address);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("_______________________Error in account no: "+ i +", with emailVariableStorage id: "+email.address);
                i--;
            } finally {
                driver.quit();
            }
        }
    }
}
