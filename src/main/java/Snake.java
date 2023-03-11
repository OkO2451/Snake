import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Snake {
    public Rect[] body = new Rect[30];
    public double bodyWidth, bodyHeight;

    public int size;
    public int tail = 0;
    public int head = 0;





    public Rect background;

    public Snake(int size, double startX, double startY, double bodyWidth, double bodyHeight, Rect background) {
        if (size > 30 || size < 0) {
            this.size = 20;
        }else{
            this.size = size;
        }
        this.bodyWidth = bodyWidth;
        this.bodyHeight = bodyHeight;
        this.background = background;

        for (int i=0; i <= size; i++) {
            Rect bodyPiece = new Rect(startX + i * bodyWidth, startY, bodyWidth, bodyHeight);
            body[i] = bodyPiece;
            head++;
        }
        head--;
    }

    public void draw(Graphics2D g2) {
        for (int i = tail; i != head; i = (i + 1) % body.length) {
            Rect piece = body[i];
            double subWidth = (piece.w - 6.0) / 2.0;
            double subHeight = (piece.h - 6.0) / 2.0;

            g2.setColor(Color.BLACK);
            g2.fill(new Rectangle2D.Double(piece.x + 2.0, piece.y + 2.0, subWidth, subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 4.0 + subWidth, piece.y + 2.0, subWidth, subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 2.0, piece.y + 4.0 + subHeight, subWidth, subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 4.0 + subWidth, piece.y + 4.0 + subHeight, subWidth, subHeight));
        }
    }
}