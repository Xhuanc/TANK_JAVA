package Tank_online;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    Tank myTank=new Tank(100,200,Dir.DOWN,this);
    static final int GAME_WIDTH=800,GAME_HEIGHT=600;
    List<Tank_online.Bullet> Bullets=new ArrayList<Bullet>();//子弹容器用来存子弹
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
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:"+Bullets.size(),20,50);
        g.setColor(c);
        myTank.paint(g);//画笔给TANK
        //利用迭代器循环时，中间不可手动进行删除
        for(int i=0;i<Bullets.size();i++) {//增强for循环遍历画子弹
            Bullets.get(i).paint(g);//画笔给子弹
        }

        }
    //键盘监听器
    //先在内存里面画，画完再一次性画到屏幕上，内存上的图片也有一只画笔
    //双缓冲
    Image offScreenImage=null;
    @Override
    public void update(Graphics g)
    {
        if(offScreenImage==null)
        {
            offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen=offScreenImage.getGraphics();
        Color c=gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }
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
                case KeyEvent.VK_SPACE:
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
                case KeyEvent.VK_J:myTank.fric();//发射子弹
            }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if(!BR&&!BD&&!BL&&!BU)myTank.Move(false);
            else {
                myTank.Move(true);
                if (BR) myTank.setDir(Dir.RIGHT);
                if (BD) myTank.setDir(Dir.DOWN);
                if (BL) myTank.setDir(Dir.LEFT);
                if (BU) myTank.setDir(Dir.UP);
            }
        }

    }
}
