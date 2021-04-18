package Tank_online;

import abstractfactory.BaseBullet;

import java.awt.*;

public class Bullet extends BaseBullet {
    private static final int SPEED = 10;
    private int x, y;
    int team = 0;//0为bad 1为good
    private Dir dir;
    public static int WIDTH = ResourceMgr.BulletL.getWidth();
    public static int HEIGHT = ResourceMgr.BulletL.getHeight();
    Rectangle rec=new Rectangle();
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    private TankFrame tf = null;//存窗口引用
    boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame, int team) {
        this.x = x;
        this.y = y;
        rec.x=x;
        rec.y=y;
        rec.height=HEIGHT;
        rec.width=WIDTH;
        this.dir = dir;
        this.tf = tankFrame;
        this.team = team;
        live = true;
    }
@Override
    public void paint(Graphics g) {
        if (this.live == false)//子弹死亡则把他remove掉
        {
            tf.Bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.BulletL, x - 30, y + 5, null);
                ;
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BulletR, x + 35, y + 5, null);
                ;
                break;
            case UP:
                g.drawImage(ResourceMgr.BulletU, x + 5, y - 30, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BulletD, x + 5, y + 30, null);
                break;
        }

        move();
    }

    void die() {
        live = !live;
    }

    protected void isHit(Tank tank) {
//        这是需要较大内存
//        if (new Rectangle(this.x, this.y, WIDTH, HEIGHT).intersects(new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT)) && this.team != tank.team) {
//            this.die();
//            tank.die();
//            int eX=tank.getX()+tank.WIDTH/2-Explode.WIDTH/2;
//            int eY=tank.getY()+tank.HEIGHT/2-Explode.HEIGHT/2;
//            tf.explodes.add(new Explode(eX,eY,this.tf));
//        }
            rec.x=this.x;
            rec.y=this.y;
            tank.rec.x=tank.getX();
            tank.rec.y=tank.getY();
        if (rec.intersects(tank.rec)&&this.team != tank.team) {
            this.die();
            tank.die();
            int eX=tank.getX()+tank.WIDTH/2-Explode.WIDTH/2;
            int eY=tank.getY()+tank.HEIGHT/2-Explode.HEIGHT/2;
            tf.explodes.add(new Explode(eX,eY,this.tf));
        }
    }

    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }


}
