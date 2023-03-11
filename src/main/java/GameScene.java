import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene{

    Rect foreground, background;
    public Kl keyListener ;
    public Ml mouseListener;
    public GameScene(Kl keyListener, Ml mouseListener) {
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;
        background = new Rect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        foreground = new Rect(24,48, 24*31, 24*22);
    }
    public void update(double dt) {
        if(keyListener.isPressed(KeyEvent.VK_UP)){
            Window.changeScene(0);
        } else if (keyListener.isPressed(KeyEvent.VK_SPACE)) {
            Window.changeScene(1);
        }
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fill(new Rectangle2D.Double(background.x, background.y, background.w, background.h));

        g2d.setColor(Color.BLUE);
        g2d.fill(new Rectangle2D.Double(foreground.x, foreground.y, foreground.w, foreground.h));

    }
}
