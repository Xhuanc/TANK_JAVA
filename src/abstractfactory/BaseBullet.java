package abstractfactory;

import Tank_online.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void isHit(Tank tank);
}
