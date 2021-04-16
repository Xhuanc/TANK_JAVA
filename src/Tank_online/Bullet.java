package Tank_online;

import java.awt.*;

public class Bullet {
    private static final int SPEED=10;
    private int x,y;
    private Dir dir;
    private static final int WIDTH=30,HEIGHT=30;
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
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);

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
