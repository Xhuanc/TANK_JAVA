package Tank_online;

import java.awt.*;

public class Bullet_Hit_Wall implements Compare{

    @Override
    public boolean TouchEach(GameObject o1,GameObject o2) {
        if((o1 instanceof  Bullet && o2 instanceof Wall))
        {

            Bullet bullet =(Bullet) o1;
            Wall wall= (Wall) o2;
            if(bullet.isHit(wall))
            return true;
        }
        else if((o1 instanceof  Wall && o2 instanceof Bullet))
        {
            if(TouchEach(o2,o1))
                return true;

        }
        return false;
    }
}

