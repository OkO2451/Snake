import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ml extends MouseAdapter implements MouseMotionListener {
    public boolean isPressed = false;
    public int x, y;
    public Ml() {
        x = 0;
        y = 0;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public boolean isPressed(){
        return isPressed;
    }
}
