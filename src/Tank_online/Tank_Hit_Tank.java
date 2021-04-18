package Tank_online;

import java.awt.*;

public class Tank_Hit_Tank implements Compare{
    @Override
    public void TouchEach(GameObject o1, GameObject o2) {
        if(o1 instanceof  Tank && o2 instanceof  Tank)
        {
           Tank t1=(Tank)o1;
           Tank t2=(Tank)o2;
           if(new Rectangle(t1.getX(),t1.getY()).intersects(new Rectangle(t2.getX(),t2.getY()))) {
               Dir dir = t1.getDir();
               t1.setDir(t2.getDir());
               t2.setDir(dir);
           }
        }
    }
}
