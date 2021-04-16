package Tank_online;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD,tankLD,tankLU,tankRD,tankRU,
                                BulletL,BulletU,BulletR,BulletD;
    public static BufferedImage[] Explode=new BufferedImage[16];

    static {
        try {
            tankL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1L.png"));
            tankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1U.png"));
            tankR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1R.png"));
            tankD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1D.png"));
            tankLD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankLD.gif"));
            tankLU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankLU.gif"));
            tankRD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankRD.gif"));
            tankRU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\tankRU.gif"));
            BulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\bulletL.gif"));
            BulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\bulletU.gif"));
            BulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\bulletR.gif"));
            BulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\bulletD.gif"));
            for (int i = 0; i < 16; i++) {
                Explode[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images\\e"+(i+1)+".gif"));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
