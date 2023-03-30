
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Test1 {
    
    String nameFile;
    AudioInputStream inGame;
    Clip clip;
    
    public Test1(String nameFile) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        setNameFile(nameFile);
        File file = new File(getNameFile());
        inGame  = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
    }

    Scanner scanner = new Scanner(System.in);

    
    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void commencer(Test1 audio1) throws LineUnavailableException, IOException {
        
        
        clip.open(inGame);
        clip.start();
        scanner.nextLine();
    }
    public void recommencer(int ou) {
        scanner.nextLine();
        clip.setMicrosecondPosition(ou); //restart
    }

    public void end () {
        clip.stop();
        scanner.nextLine();
    }


}


