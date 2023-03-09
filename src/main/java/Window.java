import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    public boolean isRunning ;
    public Window(int width, int height, String title) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isRunning = true;
    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        getGraphics().drawImage(dbImage, 0, 0, this);
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (isRunning){
            try{
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;
                update(deltaTime);
            }catch (Exception e){
                System.out.println("An error is printing");
                e.printStackTrace();
            }
        }
    }
}
