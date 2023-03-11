import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;


public class MainMenuScene extends Scene {


    public Kl keyListener ;
    public Ml mouseListener ;
    public BufferedImage title, play, playPressed, exit, exitPressed;
    public static Rect startRect, exitRect, titleRect;
    public BufferedImage playCurrent, exitCurrent;

    public MainMenuScene(Kl keyListener,Ml mouseListener) {
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;
        try{
            BufferedImage spritesheet = ImageIO.read( new File("Assets/menuSprite.png"));
            title = spritesheet.getSubimage(0, 242, 960, 240);
            play = spritesheet.getSubimage(0, 121, 261, 121);
            playPressed = spritesheet.getSubimage(264 , 121, 261, 121);
            exit = spritesheet.getSubimage(0, 0, 233, 93);
            exitPressed = spritesheet.getSubimage(264, 0, 233, 93);

        }catch (Exception e){
            e.printStackTrace();
        }
        startRect = new Rect(310, 280, 150,70);
        exitRect = new Rect(318, 355, 130,55);
        titleRect = new Rect(240, 100, 300,100);
        playCurrent = play;
        exitCurrent = exit;

    }


    public void update(double dt) {
        // java code to update the mouse coordinates using the mouse listener
        // and the mouseMoved method that takes in a MouseEvent e
        // possible values of MouseEvent e are getX() and getY()
        // you can use the getX() and getY() methods to get the x and y coordinates
        // of the mouse



        if(keyListener.isPressed(KeyEvent.VK_2)){
            Window.changeScene(0);
        } else if (keyListener.isPressed(KeyEvent.VK_1)) {
            Window.changeScene(1);
        }
        if(startRect.contains(mouseListener.getX(), mouseListener.getY())){
            playCurrent = playPressed;

            if(mouseListener.isPressed()){
                Window.changeScene(1);
            }
        }else {
            playCurrent = play;
        }
        if(exitRect.contains(mouseListener.getX(), mouseListener.getY())){
            exitCurrent = exitPressed;

            if(mouseListener.isPressed()){
                Window.close();
            }
        }else {
            exitCurrent = exit;
        }





    }
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        g.drawImage(title, (int) titleRect.x, (int) titleRect.y, (int) titleRect.w, (int) titleRect.h, null);
        g.drawImage(playCurrent, (int) startRect.x, (int) startRect.y, (int) startRect.w, (int) startRect.h, null);
        g.drawImage(exitCurrent, (int) exitRect.x, (int) exitRect.y, (int) exitRect.w, (int) exitRect.h, null);


    }
}

