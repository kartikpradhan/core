package core;

import java.awt.Robot;
import java.util.Random;

public class Mover {
    public static final int TWENTY_SECONDS = 20000;
    public static final int MAX_Y = 500;
    public static final int MAX_X = 900;

    public static void main(String... args) throws Exception {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(TWENTY_SECONDS);
        }
    }
}