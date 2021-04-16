package Tank_online;

import java.awt.*;

public class Tank extends Frame{
    private int x,y;
    private Dir dir;
    private static final int SPEED=10;
    private boolean moving=false;
    private TankFrame tf=null;//存窗口引用
    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.tf=tf;
        this.y = y;
        this.dir = dir;
    }
    public void Move(boolean flag)
    {
        moving=flag;
    }
    public void setDir(Dir dir) {
        this.dir = dir;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0,100,255));
        g.fillRect(x,y,50,50);
        if(moving)
        switch (dir)
        {
            case LEFT:x-=SPEED;break;
            case RIGHT:x+=SPEED;break;
            case UP:y-=SPEED;break;
            case DOWN:y+=SPEED;break;
        }
    }

    public void fric() {
       tf.Bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));
       //画子弹是再Frame上画的所以需要利用窗口的引用
    }
}
