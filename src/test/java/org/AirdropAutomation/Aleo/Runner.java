package org.AirdropAutomation.Aleo;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedFlavorException {
        for (int i = 0; i < 100; i++) {
            PhraseCreator.createPhrase();
        }
    }
}
