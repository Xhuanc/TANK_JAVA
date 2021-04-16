package Tank_online;

import java.awt.*;

public class Bullet {
    private static final int SPEED=10;
    private int x,y;
    private Dir dir;
    public static int WIDTH=ResourceMgr.BulletL.getWidth();
    public static int HEIGHT=ResourceMgr.BulletL.getHeight();
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    private TankFrame tf=null;//存窗口引用
    boolean live=true;
    public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tankFrame;
        live=true;
    }
    public void paint(Graphics g) {
        if(this.live==false)//子弹死亡则把他remove掉
        {
            tf.Bullets.remove(this);
        }
        switch (dir)
        {
            case LEFT: g.drawImage(ResourceMgr.BulletL,x-30,y+5,null);;break;
            case RIGHT: g.drawImage(ResourceMgr.BulletR,x+35,y+5,null);;break;
            case UP: g.drawImage(ResourceMgr.BulletU,x+5,y-30,null);break;
            case DOWN: g.drawImage(ResourceMgr.BulletD,x+5,y+30,null);break;
        }

        move();
    }
    private void move(){

        switch (dir)
        {
            case LEFT:x-=SPEED;break;
            case UP:y-=SPEED;break;
            case RIGHT:x+=SPEED;break;
            case DOWN:y+=SPEED;break;
        }
        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT)
        {
            live=false;
        }
    }


}
