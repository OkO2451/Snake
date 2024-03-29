import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene{
    int score ;
    public Snake snake;
    public static boolean PAUSE = false;
    public Fruit fruit;
    Rect foreground, background;

    public Kl keyListener ;
    public Ml mouseListener;
    public GameScene(Kl keyListener, Ml mouseListener) {
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;
        background = new Rect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        foreground = new Rect(24,48, 24*31, 24*22);
        score = 0;
        snake = new Snake( score , 48,48+24,24,24,background,foreground);
        fruit = new Fruit();
    }
    public void update(double dt) {
        if(keyListener.isPressed(KeyEvent.VK_P)){
            PAUSE = !PAUSE;
            //time sleep for half a second
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (PAUSE) {
            return;
        }

        if(keyListener.isPressed(KeyEvent.VK_2)){
            Window.changeScene(0);
        } else if (keyListener.isPressed(KeyEvent.VK_1)) {
            Window.changeScene(1);
        }
        if (Window.keyListener.isPressed(KeyEvent.VK_UP)) {
            if(snake.direction != Direction.DOWN)
                snake.changeDirection(Direction.UP);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (Window.keyListener.isPressed(KeyEvent.VK_DOWN)) {
            if(snake.direction != Direction.UP)
                snake.changeDirection(Direction.DOWN);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (Window.keyListener.isPressed(KeyEvent.VK_LEFT)) {
            if(snake.direction != Direction.RIGHT)
                snake.changeDirection(Direction.LEFT);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (Window.keyListener.isPressed(KeyEvent.VK_RIGHT)) {
            if(snake.direction != Direction.LEFT)
                snake.changeDirection(Direction.RIGHT);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (snake.body[snake.head].contains(fruit.rect) || snake.body[snake.tail].contains(fruit.rect.x + 24, fruit.rect.y + 24)) {
            snake.grow();
            score++;
            fruit.spawn();
        }

        if( keyListener.isPressed(KeyEvent.VK_SPACE)){
            try {
                fruit.spawn();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        // code to draw the score
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Score: " + score, 12, 588);

        String s = "Press P to pause";
        s = PAUSE ? "Press P to resume" : s;
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString(s, 12+320, 588);
    }
}
