import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoseScene extends MainMenuScene {
    public LoseScene(Kl keyListener, Ml mouseListener) {
        super(keyListener, mouseListener);
        try {
            BufferedImage spritesheet = ImageIO.read(new File("Assets/lost.png"));
            title = spritesheet.getSubimage(0, 0, 860, 333);
        }catch (Exception e) {
            e.printStackTrace();
        }
        titleRect = new Rect(180, 100, 400,150);
    }




}
