package abstractfactory;

import Tank_online.Dir;
import Tank_online.TankFrame;

public abstract class GameFactory {
  public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);
  public abstract BaseBullet createBullet(int x, int y, Dir dir,TankFrame tankFrame,int team);
  public abstract BaseTank createTank(int x, int y, Dir dir, TankFrame tf, int team);
}
