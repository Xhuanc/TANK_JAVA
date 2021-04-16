package Tank_online;

import java.awt.*;

public class Tank extends Frame{
    private int x,y;
    private Dir dir=Dir.STOP;
    private static final int SPEED=10;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x,y,50,50);
        switch (dir)
        {
            case LEFT:x-=SPEED;break;
            case RIGHT:x+=SPEED;break;
            case UP:y-=SPEED;break;
            case DOWN:y+=SPEED;break;
        }
    }
}
