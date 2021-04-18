package Tank_online;

public class Bullet_Hit_Tank implements Compare{
    @Override
    public boolean TouchEach(GameObject o1, GameObject o2) {
        if((o1 instanceof  Bullet && o2 instanceof Tank))
        {
            Bullet bullet=(Bullet) o1;
            Tank tank=(Tank) o2;
            if(bullet.isHit(tank))
                return true;
            else
                return false;
        }
        else if((o1 instanceof  Tank && o2 instanceof Bullet))
        {
            if(TouchEach(o2,o1))
                return true;
            else return false;
        }
        else return false;
    }
}
