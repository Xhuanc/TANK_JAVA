package abstractfactory;

import Tank_online.*;

public class DefaultFactory extends GameFactory{

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, TankFrame tankFrame, int team) {
        return new Bullet(x,y,dir,tankFrame,team);
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, TankFrame tf, int team) {
        return new Tank(x,y,dir,tf,team);
    }
}
