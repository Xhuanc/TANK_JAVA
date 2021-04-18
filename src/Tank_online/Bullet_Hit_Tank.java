package Tank_online;

public class Bullet_Hit_Tank implements Compare{
    @Override
    public void TouchEach(GameObject o1, GameObject o2) {
        if((o1 instanceof  Bullet && o2 instanceof Tank))
        {
            Bullet bullet=(Bullet) o1;
            Tank tank=(Tank) o2;
            bullet.isHit(tank);
        }
        else if((o1 instanceof  Tank && o2 instanceof Bullet))
        {
            TouchEach(o2,o1);
        }
        else return;
    }
}
