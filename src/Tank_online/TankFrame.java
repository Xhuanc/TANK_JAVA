package Tank_online;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank=new Tank(100,200,Dir.DOWN);
    private static final int SPEED = 10;
    public TankFrame()
    {
        setSize(800,600);
        setResizable(false);
        setTitle("tank_war");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
       myTank.paint(g);
    }
    //键盘监听器
    class MyKeyListener implements KeyListener{
        boolean BL=false;
        boolean BR=false;
        boolean BU=false;
        boolean BD=false;
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:BU=true;break;
                case KeyEvent.VK_LEFT:BL=true;break;
                case KeyEvent.VK_DOWN:BD=true;break;
                case KeyEvent.VK_RIGHT:BR=true;break;
            }
            setMainTankDir();
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:BU=false;break;
                case KeyEvent.VK_LEFT:BL=false;break;
                case KeyEvent.VK_DOWN:BD=false;break;
                case KeyEvent.VK_RIGHT:BR=false;break;
            }
            setMainTankDir();
        }
        private void setMainTankDir(){
            if(BR)myTank.setDir( Dir.RIGHT);
            if(BD)myTank.setDir(Dir.DOWN);
            if(BL)myTank.setDir(Dir.LEFT);
            if(BU)myTank.setDir(Dir.UP);
            if(!BR&&!BD&&!BL&&!BU)myTank.setDir(Dir.STOP);
        }

    }
}
