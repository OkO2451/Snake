import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Snake {
    public Rect[] body = new Rect[30];
    public double bodyWidth, bodyHeight;

    public int size;
    public int tail = 0;
    public int head = 0;

    public Direction direction = Direction.RIGHT;
    public double ogWaitTime = 0.4f;
    public double waitTime = ogWaitTime;


    public Rect background;
    public Rect foreground;

    public void update(double dt) {
            if (waitTime > 0) {
                waitTime -= dt;
            return;
        }

        waitTime = ogWaitTime;
        double newX = 0;
        double newY = 0;

        // using a switch statement here would be better
        switch (direction) {
            case RIGHT:
                System.out.println("right");
                newX = body[head].x + bodyWidth;
                newY = body[head].y;
                break;
            case LEFT:
                System.out.println("left");
                newX = body[head].x - bodyWidth;
                newY = body[head].y;
                break;
            case UP:
                System.out.println("up");
                newX = body[head].x;
                newY = body[head].y - bodyHeight;
                break;
            case DOWN:
                System.out.println("down");
                newX = body[head].x;
                newY = body[head].y + bodyHeight;
                break;
        }

        if (newX < foreground.x) {
            newX = foreground.x + foreground.w - bodyWidth;
        } else if (newX + bodyWidth > foreground.x + foreground.w) {
            newX = foreground.x;
        }
        if(newY < foreground.y) {
            newY = foreground.y + foreground.h - bodyHeight;
        } else if (newY + bodyHeight > foreground.y + foreground.h) {
            newY = foreground.y;
        }

        body[(head + 1) % body.length] = body[tail];
        body[tail] = null;
        head = (head + 1) % body.length;
        tail = (tail + 1) % body.length;

        body[head].x = newX;
        body[head].y = newY;

    }
    public void changeDirection(Direction direction) {
        this.direction = direction;

    }

    public Snake(int size, double startX, double startY, double bodyWidth, double bodyHeight, Rect background, Rect foreground) {
        if (size > 30 || size < 0) {
            this.size = 20;
        }else{
            this.size = size;
        }
        this.bodyWidth = bodyWidth;
        this.bodyHeight = bodyHeight;
        this.background = background;
        this.foreground = foreground;

        for (int i=0; i <= size; i++) {
            Rect bodyPiece = new Rect(startX + i * bodyWidth, startY, bodyWidth, bodyHeight);
            body[i] = bodyPiece;
            head++;
        }
        head--;
    }



    public void draw(Graphics2D g2) {


        double subWidth = (body[head].w - 6.0) / 2.0;
        double subHeight = (body[head].h - 6.0) / 2.0;
        for (int i = tail; i != head; i = (i + 1) % body.length) {
            Rect piece = body[i];



            g2.setColor(Color.BLACK);
            g2.fill(new Rectangle2D.Double(piece.x + 2.0, piece.y + 2.0, subWidth, subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 4.0 + subWidth, piece.y + 2.0, subWidth, subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 2.0, piece.y + 4.0 + subHeight, subWidth, subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 4.0 + subWidth, piece.y + 4.0 + subHeight, subWidth, subHeight));

        }
        g2.setColor(Color.RED);
        g2.fill(new Rectangle2D.Double(body[head].x + 2.0, body[head].y + 2.0, subWidth, subHeight));
        g2.fill(new Rectangle2D.Double(body[head].x + 4.0 + subWidth, body[head].y + 2.0, subWidth, subHeight));
        g2.fill(new Rectangle2D.Double(body[head].x + 2.0, body[head].y + 4.0 + subHeight, subWidth, subHeight));
        g2.fill(new Rectangle2D.Double(body[head].x + 4.0 + subWidth, body[head].y + 4.0 + subHeight, subWidth, subHeight));
       }
}