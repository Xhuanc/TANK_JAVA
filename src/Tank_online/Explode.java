package Tank_online;

import abstractfactory.BaseExplode;

import java.awt.*;
import java.lang.ref.PhantomReference;

public class Explode extends BaseExplode {
    public static final int WIDTH=ResourceMgr.Explode[0].getWidth();
    public static final int HEIGHT=ResourceMgr.Explode[0].getHeight();
    private int x,y;
    TankFrame tf=null;
    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }
    public void paint(Graphics g)
    {
        for (int i = 0; i < ResourceMgr.Explode.length; i++) {
            g.drawImage(ResourceMgr.Explode[i],x,y ,null);
        }
        new Audio("src\\Voice\\explode.wav").start();
        tf.explodes.remove(this);

    }
}
