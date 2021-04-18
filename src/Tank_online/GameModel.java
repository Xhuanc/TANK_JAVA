package Tank_online;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank myTank = new Tank(100, 200, Dir.DOWN, this,1);
    //    Tank enemyTank=new Tank(400,310,Dir.DOWN,this);
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 720;
    List<GameObject> GameObjects=new ArrayList<>();
    Bullet_Hit_Tank bullet_hit_tank = new Bullet_Hit_Tank();
    Tank_Hit_Tank tank_hit_tank = new Tank_Hit_Tank();
    CollideChain collideChain =new CollideChain();
    public GameModel() {
    }
    public void add(GameObject go)
    {
        this.GameObjects.add(go);
    }
    public void remove(GameObject go)
    {
        this.GameObjects.remove(go);
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + Bullets.size(), 20, 50);
//        g.drawString("敌人的数量:" + enemyTank.size(), 20, 80);
        g.setColor(c);
        myTank.paint(g);//画笔给TANK
//        enemyTank.paint(g);
        //利用迭代器循环时，中间不可手动进行删除
        for (int i = 0; i < GameObjects.size(); i++) {//增强for循环遍历画子弹
            GameObjects.get(i).paint(g);//画笔给子弹
//            if(Bullets.get(i).getX()<enemyTank.getX()+50&&Bullets.get(i).getY()==enemyTank.getY())

//                Bullets.get(i).live=false;
//                enemyTank.live=false;
//            }
        }
//        for (int i = 0; i < enemyTank.size(); i++) {
//            enemyTank.get(i).paint(g);
//        }
//        for(int i=0;i<explodes.size();i++)
//        {
//            explodes.get(i).paint(g);
//        }
        //碰撞检测
//        for (int i = 0; i < Bullets.size(); i++) {
//            for (int j = 0; j < enemyTank.size(); j++) {
//                Bullets.get(i).isHit(enemyTank.get(j));//这个子弹是否打到了地方
//            }
//        }
        for (int i = 0; i < GameObjects.size(); i++) {
            for (int j = i+1; j < GameObjects.size(); j++) {
                GameObject o1=GameObjects.get(j);
                GameObject o2=GameObjects.get(i);
                //策略 比较器
               collideChain.collide(o1,o2);
            }
        }
    }
}


