package Tank_online;

import java.awt.*;
import java.util.Random;

public class Tank extends Frame {
    private int x, y;
    int team;//0为bad 1为good

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    boolean live = true;
    private Random random=new Random();
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    private Dir dir;
    private static final int SPEED = 5;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private boolean moving = true;
    private TankFrame tf = null;//存窗口引用

    public Tank(int x, int y, Dir dir, TankFrame tf,int team) {
        this.x = x;
        this.tf = tf;
        this.y = y;
        this.dir = dir;
        this.team=team;
    }

    public void Move(boolean flag) {
        moving = flag;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    void die() {
        live = !live;
    }

    @Override
    public void paint(Graphics g) {
        if (!live) tf.enemyTank.remove(this);//敌人死了
        Color c = g.getColor();
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);

                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);

                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

        if (moving)
            switch (dir) {
                case LEFT:
                    x -= SPEED;
                    break;
                case RIGHT:
                    x += SPEED;
                    break;
                case UP:
                    y -= SPEED;
                    break;
                case DOWN:
                    y += SPEED;
                    break;
            }
        if(random.nextInt()%5==0&&team==0)
        {
            fric(team);
        }
    }

    public void fric(int team) {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.Bullets.add(new Bullet(bX, bY, this.dir, this.tf,team));
        //画子弹是再Frame上画的所以需要利用窗口的引用
    }
}
