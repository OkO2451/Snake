import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    public boolean isRunning ;
    public static Scene currentScene;
    public static int currentState;
    public static Ml mouseListener = new Ml();
    public static Kl keyListener = new Kl();

    public Window(int width, int height, String title) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        isRunning = true;
        addKeyListener(keyListener);
        addMouseListener(mouseListener);

        Window.changeScene(0);

    }
    public void start(){
        new Thread(this).start();
    }
    // scene builder

    public static void changeScene(int newState){
        Window.currentState = newState;
        switch (Window.currentState){
            case 0:
                Window.currentScene = new MainMenuScene(Window.keyListener, Window.mouseListener);
                break;
            case 1:
                Window.currentScene = new GameScene(Window.keyListener, Window.mouseListener);
                break;
            default:
                Window.currentScene = new MainMenuScene(Window.keyListener, Window.mouseListener);
                break;
        }
    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        getGraphics().drawImage(dbImage, 0, 0, this);
        Window.currentScene.update(dt);
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Window.currentScene.draw(g);
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
