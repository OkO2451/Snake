import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class WinScene extends MainMenuScene{
    public WinScene(Kl keyListener, Ml mouseListener) {
        super(keyListener, mouseListener);
        try {
            BufferedImage spritesheet = ImageIO.read(new File("Assets/you_win.jpg"));
            title = spritesheet.getSubimage(0, 0, 450, 180);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
