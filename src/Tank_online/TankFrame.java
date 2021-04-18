package Tank_online;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    GameModel gameModel =new GameModel();
    public TankFrame() {

        setSize(gameModel.GAME_WIDTH, gameModel.GAME_HEIGHT);
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
//        for (int i = 0; i < 5; i++) {
//            enemyTank.add(new Tank(80 + i * 30, 80 + i * 30, Dir.DOWN, this,0));
//        }
    }


    @Override
    public void paint(Graphics g) {
      gameModel.paint(g);
    }


    //键盘监听器
    //先在内存里面画，画完再一次性画到屏幕上，内存上的图片也有一只画笔
    //双缓冲
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(gameModel.GAME_WIDTH, gameModel.GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, gameModel.GAME_WIDTH, gameModel.GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    class MyKeyListener implements KeyListener {
        boolean BL = false;
        boolean BR = false;
        boolean BU = false;
        boolean BD = false;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = true;
                    break;
                case KeyEvent.VK_SPACE:
            }
            setMainTankDir();
            setEnemyTankDir();

            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = false;
                    break;
                case KeyEvent.VK_J:
                    gameModel.myTank.fric(gameModel.myTank.team);
                    new Audio("src\\Voice\\tank_fire.wav").start();
                    break;//发射子弹
            }
            setMainTankDir();
            setEnemyTankDir();

        }

        private void setEnemyTankDir() {
//            if(enemyTank.getY()>60)
//            enemyTank.setDir(Dir.UP);
//            else
//            enemyTank.setDir(Dir.DOWN);
//
//            enemyTank.Move(true);
        }

        private void setMainTankDir() {
            if (!BR && !BD && !BL && !BU) gameModel.myTank.Move(false);
            else {
                gameModel.myTank.Move(true);
                if (BR) gameModel.myTank.setDir(Dir.RIGHT);
                if (BD) gameModel.myTank.setDir(Dir.DOWN);
                if (BL) gameModel.myTank.setDir(Dir.LEFT);
                if (BU) gameModel.myTank.setDir(Dir.UP);
            }
        }

    }
}
