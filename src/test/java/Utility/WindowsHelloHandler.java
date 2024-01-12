package Utility;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WindowsHelloHandler {
    public static void enterPin() throws AWTException, InterruptedException {
        // Create Robot class instance
        Robot robot = new Robot();

        // Simulate typing your PIN
        typePin(robot, "abcd");
        robot.keyPress(KeyEvent.VK_ENTER);


    }

    private static void typePin(Robot robot, String pin) {
        // Convert PIN string to char array
        char[] pinChars = pin.toCharArray();

        // Type each character
        for (char pinChar : pinChars) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(pinChar);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            // Add a short delay between key presses to avoid issues
            robot.delay(100);
        }
    }
}
