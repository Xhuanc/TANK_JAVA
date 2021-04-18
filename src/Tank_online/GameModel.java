package Tank_online;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank myTank = new Tank(100, 200, Dir.DOWN, this,1);

    //    Tank enemyTank=new Tank(400,310,Dir.DOWN,this);
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 720;
    List<Bullet> Bullets = new ArrayList<Bullet>();//子弹容器用来存子弹
    List<Tank> enemyTank = new ArrayList<>();//敌人队列
    List<Explode> explodes=new ArrayList<>();
}
