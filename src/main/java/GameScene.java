import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene{
    public Snake snake;
    public Fruit fruit;
    Rect foreground, background;
    public Kl keyListener ;
    public Ml mouseListener;
    public GameScene(Kl keyListener, Ml mouseListener) {
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;
        background = new Rect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        foreground = new Rect(24,48, 24*31, 24*22);
        snake = new Snake( 20, 48,48+24,24,24,background,foreground);
        fruit = new Fruit();
    }
    public void update(double dt) {
        if(keyListener.isPressed(KeyEvent.VK_2)){
            Window.changeScene(0);
        } else if (keyListener.isPressed(KeyEvent.VK_1)) {
            Window.changeScene(1);
        }
        if (Window.keyListener.isPressed(KeyEvent.VK_UP)) {
            snake.changeDirection(Direction.UP);
        } else if (Window.keyListener.isPressed(KeyEvent.VK_DOWN)) {
            snake.changeDirection(Direction.DOWN);
        } else if (Window.keyListener.isPressed(KeyEvent.VK_LEFT)) {
            snake.changeDirection(Direction.LEFT);
        } else if (Window.keyListener.isPressed(KeyEvent.VK_RIGHT)) {
            snake.changeDirection(Direction.RIGHT);
        }

        if (snake.body[snake.head].x <= fruit.rect.x && snake.body[snake.head].y <= fruit.rect.y + fruit.rect.h && snake.body[snake.head].y + snake.body[snake.head].h >= fruit.rect.y) {
            // snake.grow();
            fruit.spawn();
        }

        snake.update(dt);


    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fill(new Rectangle2D.Double(background.x, background.y, background.w, background.h));

        g2d.setColor(Color.WHITE);
        g2d.fill(new Rectangle2D.Double(foreground.x, foreground.y, foreground.w, foreground.h));
        snake.draw(g2d);


        fruit.dispose(g2d);
        fruit.draw(g2d);
    }
}
