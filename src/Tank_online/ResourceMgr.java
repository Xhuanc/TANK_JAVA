package Tank_online;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD,tankLD,tankLU,tankRD,tankRU,
                                BulletL,BulletU,BulletR,BulletD,
                                GoodTankU,GoodTankL,GoodTankR,GoodTankD,
                                BadTankU,BadTankL,BadTankR,BadTankD,RedWall,BlueWall;
                                                        ;
    public static BufferedImage[] Explode=new BufferedImage[16];
    static {
        try {
            BlueWall=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\square2.jpg"));
            GoodTankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1U.png"));
            GoodTankL=ImageUtil.rotateImage(GoodTankU,-90);
            GoodTankR=ImageUtil.rotateImage(GoodTankU,90);
            GoodTankD=ImageUtil.rotateImage(GoodTankU,180);
            BadTankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\BadTank1.png"));
            BadTankL=ImageUtil.rotateImage(BadTankU,-90);
            BadTankR=ImageUtil.rotateImage(BadTankU,90);
            BadTankD=ImageUtil.rotateImage(BadTankU,180);
//            tankD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1D.png"));
//            tankLD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankLD.gif"));
//            tankLU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankLU.gif"));
//            tankRD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankRD.gif"));
//            tankRU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankRU.gif"));
            BulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\bulletU.gif"));
            BulletL=ImageUtil.rotateImage(BulletU,-90);
            BulletR=ImageUtil.rotateImage(BulletU,90);
            BulletD=ImageUtil.rotateImage(BulletU,180);
            for (int i = 0; i < 16; i++) {
                Explode[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\e"+(i+1)+".gif"));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
