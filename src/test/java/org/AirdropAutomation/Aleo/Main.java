package org.AirdropAutomation.Aleo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Void>> futures = new ArrayList<>();

        for (int rowNumber = 1; rowNumber <= 100; rowNumber++) {
            final int currentRow = rowNumber; // Need to be effectively final for lambda expression
            Future<Void> future = (Future<Void>) executor.submit(() -> {
                Runner.generate(currentRow);
            });

            futures.add(future);
        }

        for (Future<Void> future : futures) {
            try {
                future.get(); // Blocking call to wait for completion
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
