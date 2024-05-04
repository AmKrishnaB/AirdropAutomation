package AirdropAutomation.Immutable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import Utility.ExcelWriter;
import Utility.LaunchBrowser;

public class multiThreadRunner {
    public static void main(String[] args) throws InterruptedException {
        int totalTasks = 1000;
        int threadPoolSize = 2; // You can adjust this based on your requirements

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        try {
            for (int i = 0; i < totalTasks; i++) {
                executorService.submit(new Task(i));
            }
        } finally {
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }

        System.exit(0);
    }

    static class Task implements Callable<Void> {
        private final int taskId;

        Task(int taskId) {
            this.taskId = taskId;
        }


        @Override
        public Void call() throws Exception {
            LaunchBrowser.driver = LaunchBrowser.webdriver();
            LaunchBrowser.driver.manage().window().maximize();
            try {
                System.out.println("Current count: " + taskId);
                emailUtilities.randomEmailGen();
                emailUtilities.createAccount();
                emailUtilities.createToken();
                immutable.createWallet(email.address);
                ExcelWriter.writeAddressAndTokenToExcel(email.address, email.token, System.getProperty("user.dir") + "\\Excel\\Immutable\\immutable.xlsx", "Sheet1");
                System.out.println("Current success count: " + (taskId + 1));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LaunchBrowser.driver.quit();
            }
            return null;
        }
    }
}
