package org.AirdropAutomation.Drip;

import Utility.ExcelWriter;
import Utility.LaunchBrowser;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static Utility.LaunchBrowser.driver;

public class MultiThreadRunner {
    public static void main(String[] args) {
        // Number of threads you want to run concurrently
        int numberOfThreads = 5;

        // Create a thread pool with the desired number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // Submit tasks to the thread pool
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(new MyTask());
        }

        // Shutdown the executor service when all tasks are done
        executorService.shutdown();
    }

    // Runnable task to be executed in each thread
    static class MyTask implements Runnable {
        @Override
        public void run() {
            driver = null;
            try {
                // Create a new WebDriver instance for each thread
                driver = LaunchBrowser.webdriverWithPhantom();
                driver.manage().window().maximize();

                // Your existing code
                String[] phrase = PhraseCreator.copyPhrase();
                ExcelWriter.writePhraseArrayToExcel(phrase, System.getProperty("user.dir") + "\\Excel\\Phantom\\phrase.xlsx", "Sheet1");
            } catch (Exception e) {
                e.printStackTrace(); // Handle exceptions appropriately
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }
}
