package Tank_online;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        new Thread(()->new Audio("audio/war1.wav")).start();
        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();

        }
    }
}
