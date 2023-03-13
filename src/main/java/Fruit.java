import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Fruit {
    public Rect rect;
    public BufferedImage icon;
    public Fruit() {
        rect = new Rect();
        try {
            BufferedImage spritesheet = ImageIO.read(new File("Assets/fruit.jpg"));
            icon = spritesheet.getSubimage(0, 0, 96, 98);
        }catch (Exception e) {
            e.printStackTrace();
        }
        spawn();
    }
    public void spawn() {
        rect.x = (int) (Math.random() * (Constants.F_WIDTH - 2*Constants.BLOCK_SIZE)) + Constants.BLOCK_SIZE;
        rect.y = (int) (Math.random() * (Constants.F_HEIGHT - 2*Constants.BLOCK_SIZE)) + Constants.BLOCK_SIZE;
        rect.w = (int) Constants.BLOCK_SIZE;
        rect.h = (int) Constants.BLOCK_SIZE;

    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(icon,(int) rect.x ,(int) rect.y,(int) rect.w, (int) rect.h, null);
    }

    public void dispose(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect((int) rect.x,(int) rect.y,(int) rect.w, (int) rect.h);
    }


}
