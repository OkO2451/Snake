import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    private static boolean isRunning = true;
    private static Window window = null;
    private static Scene currentScene;
    private static int currentState;
    private static Ml mouseListener = new Ml();
    static Kl keyListener = new Kl();

    private Window(int width, int height, String title) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(keyListener);
        addMouseListener(mouseListener);

        changeScene(0);
    }

    public static synchronized Window getInstance() {
        if (window == null) {
            window = new Window(Constants.WIDTH, Constants.HEIGHT, "Game");
        }
        return window;
    }

    public static void changeScene(int newState){
        currentState = newState;
        switch (currentState){
            case 0:
                currentScene = new MainMenuScene(keyListener, mouseListener);
                break;
            case 1:
                currentScene = new GameScene(keyListener, mouseListener);
                break;
            case 2:
                currentScene = new LoseScene(keyListener,mouseListener);
                break;
            default:
                currentScene = new MainMenuScene(keyListener, mouseListener);
                break;
        }
    }

    public static void close() {
        isRunning = false;
    }

    public  void update(double dt) {
        currentScene.update(dt);
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        draw(dbg);
        getGraphics().drawImage(dbImage, 0, 0, this);

    }

    public static void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        currentScene.draw(g);
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
        this.dispose();
    }
}