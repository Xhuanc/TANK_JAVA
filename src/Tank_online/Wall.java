package Tank_online;

import java.awt.*;

public class Wall extends GameObject{
    int x,y;
    final int Width=ResourceMgr.BlueWall.getWidth();
    final int Height=ResourceMgr.BlueWall.getHeight();
    Rectangle rec=new Rectangle();
    GameModel gameModel=null;
    public Wall(int x,int y,GameModel gameModel) {
        this.gameModel=gameModel;
        this.x = x;
        this.y=y;
        rec.x=x;
        rec.y=y;
        rec.width=Width+20;
        rec.height=Height+20;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.BlueWall,x,y,Width,Height,null);
    }
}
