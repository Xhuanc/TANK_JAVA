package Tank_online;

import java.awt.*;
import java.util.Random;

public class Tank  extends GameObject{
    private int x, y;
    int team;//0为bad 1为good
    Rectangle rec=new Rectangle();
    public int getTeam() {
        return team;
    }
    public Dir getDir(){return  this.dir;}
    public void randomDir() {
        if (team == 0 && random.nextInt(10) > 8)
            this.dir = Dir.values()[random.nextInt(4)];
    }

    public void setTeam(int team) {
        this.team = team;
    }

    boolean live = true;
    private Random random = new Random();


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    private Dir dir;
    private static final int SPEED = 5;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private boolean moving = true;
    private TankFrame tf = null;//存窗口引用
    private GameModel gameModel = null;//存窗口引用

    public Tank(int x, int y, Dir dir,GameModel gameModel, int team) {
        this.x = x;
        this.gameModel = gameModel;
        this.y = y;
        this.dir = dir;
        this.team = team;
        rec.x=x;
        rec.y=y;
        rec.height=Tank.HEIGHT;
        rec.width=Tank.WIDTH;
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

    void move(Graphics g) {
        if (!live) gameModel.remove(this);//敌人死了
        Color c = g.getColor();
        switch (dir) {
            case LEFT:
                if (team == 1)
                    g.drawImage(ResourceMgr.GoodTankL, x, y, null);
                else
                    g.drawImage(ResourceMgr.BadTankL, x, y, null);
                break;
            case RIGHT:
                if (team == 1)
                    g.drawImage(ResourceMgr.GoodTankR, x, y, null);
                else
                    g.drawImage(ResourceMgr.BadTankR, x, y, null);
                break;
            case UP:
                if (team == 1)
                    g.drawImage(ResourceMgr.GoodTankU, x, y, null);
                else
                    g.drawImage(ResourceMgr.BadTankU, x, y, null);
                break;
            case DOWN:
                if (team == 1)
                    g.drawImage(ResourceMgr.GoodTankD, x, y, null);
                else
                    g.drawImage(ResourceMgr.BadTankD, x, y, null);
                break;
        }
        randomDir();
        if (moving) {
            switch (dir) {
                case LEFT:
                    if (x > 0)
                        x -= SPEED;
                    break;
                case RIGHT:
                    if (x < 1080)
                        x += SPEED;
                    break;
                case UP:
                    if (y > 40)
                        y -= SPEED;
                    break;
                case DOWN:
                    if (y < gameModel.GAME_HEIGHT - 70)
                        y += SPEED;
                    break;
            }
        }

    }


    public void paint(Graphics g) {
        move(g);
        if (random.nextInt(100) > 90 && team == 0) {
            fric(team);
        }
    }

    public void fric(int team) {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        gameModel.add(new Bullet(bX, bY, this.dir, gameModel, team));
        //画子弹是再Frame上画的所以需要利用窗口的引用
    }
}
