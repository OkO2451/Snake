import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class GameScene extends Scene{
    public Kl keyListener = new Kl();
    public GameScene(Kl keyListener) {
        this.keyListener = keyListener;
    }
    public void update(double dt) {
        if(keyListener.isPressed(KeyEvent.VK_UP)){
            Window.changeScene(0);
        } else if (keyListener.isPressed(KeyEvent.VK_SPACE)) {
            Window.changeScene(1);
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
    }
}
