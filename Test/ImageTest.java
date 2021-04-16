package Test;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {

    BufferedImage image;

    {
        try {
            image = ImageIO.read(new File("C:\\Users\\xhuanc\\pictures\\9b6b42dc833963d7d86db157febcc02.jpg"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
