package Tank_online;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x=200,y=200;
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
        g.setColor(Color.black);
        g.fillRect(x,y,50,50);
    }
    //键盘监听器
    class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            char key=e.getKeyChar();
            switch (key)
            {
                case 'w':y-=20;break;
                case 'a':x-=20;break;
                case 's':y+=10;break;
                case 'd':x+=10;break;
            }
            repaint();
            char lastkey=key;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key=e.getKeyCode();
            if(key=='A')
            {
                repaint();
            }
        }
    }
}
