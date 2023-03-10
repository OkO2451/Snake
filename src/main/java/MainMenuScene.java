import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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
        if(keyListener.isPressed(KeyEvent.VK_UP)){
            Window.changeScene(0);
        } else if (keyListener.isPressed(KeyEvent.VK_SPACE)) {
            Window.changeScene(1);
        }
        if(startRect.contains(mouseListener.x, mouseListener.y)){
            playCurrent = playPressed;
            if(mouseListener.isPressed()){
                Window.changeScene(1);
            }
        }else {
            playCurrent = play;
        }
        if(exitRect.contains(mouseListener.x, mouseListener.y)){
            exitCurrent = exitPressed;
            if(mouseListener.isPressed()){
                System.exit(0);
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

