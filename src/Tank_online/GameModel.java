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
    List<Bullet> Bullets = new ArrayList<Bullet>();//子弹容器用来存子弹
    List<Tank> enemyTank = new ArrayList<>();//敌人队列
    List<Explode> explodes=new ArrayList<>();

    public GameModel() {
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + Bullets.size(), 20, 50);
        g.drawString("敌人的数量:" + enemyTank.size(), 20, 80);
        g.setColor(c);
        myTank.paint(g);//画笔给TANK
//        enemyTank.paint(g);
        //利用迭代器循环时，中间不可手动进行删除
        for (int i = 0; i < Bullets.size(); i++) {//增强for循环遍历画子弹
            Bullets.get(i).paint(g);//画笔给子弹
//            if(Bullets.get(i).getX()<enemyTank.getX()+50&&Bullets.get(i).getY()==enemyTank.getY())
//            {
//                Bullets.get(i).live=false;
//                enemyTank.live=false;
//            }
        }
        for (int i = 0; i < enemyTank.size(); i++) {
            enemyTank.get(i).paint(g);
        }
        for(int i=0;i<explodes.size();i++)
        {
            explodes.get(i).paint(g);
        }
        //碰撞检测
        for (int i = 0; i < Bullets.size(); i++) {
            for (int j = 0; j < enemyTank.size(); j++) {
                Bullets.get(i).isHit(enemyTank.get(j));//这个子弹是否打到了地方
            }
        }
    }

}
