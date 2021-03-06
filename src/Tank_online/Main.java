package Tank_online;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        int initTankCount=Integer.parseInt(String.valueOf(PropertyMgr.get("initTankCount")));
        for(int i=0;i<initTankCount;i++)
        {
            tankFrame.enemyTank.add(new Tank(50+i*80,200,Dir.DOWN,tankFrame,0));
        }
        new Thread(()->new Audio("audio/war1.wav")).start();
        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();

        }
    }
}
