import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoseScene extends MainMenuScene {
    public LoseScene(Kl keyListener, Ml mouseListener) {
        super(keyListener, mouseListener);
        try {
            BufferedImage spritesheet = ImageIO.read(new File("Assets/you_win.jpg"));
            title = spritesheet.getSubimage(0, 0, 450, 180);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void update(double dt) {
        super.update(dt);

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
