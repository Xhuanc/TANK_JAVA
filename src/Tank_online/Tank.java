package Tank_online;

import java.awt.*;

public class Tank extends Frame{
    private int x,y;
    boolean live=true;
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    private Dir dir;
    private static final int SPEED=10;
    public static final int WIDTH=50;
    public static final int HEIGHT=50;
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
        if(!live)return;
        Color c=g.getColor();
        switch (dir)
        {
            case LEFT: g.drawImage(ResourceMgr.tankL,x,y,null);;break;
            case RIGHT: g.drawImage(ResourceMgr.tankR,x,y,null);;break;
            case UP: g.drawImage(ResourceMgr.tankU,x,y,null);break;
            case DOWN: g.drawImage(ResourceMgr.tankD,x,y,null);break;
        }

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
        int bX=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        tf.Bullets.add(new Bullet(bX,bY,this.dir,this.tf));
       //画子弹是再Frame上画的所以需要利用窗口的引用
    }
}
