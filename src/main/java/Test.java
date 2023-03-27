import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Test {
    
    public String nameFile;

    public Test(String nameFile) throws LineUnavailableException, IOException {
        this.nameFile = nameFile;
        clip.open(inGame);
        clip.start();
        scanner.nextLine();
    }

    Scanner scanner = new Scanner(System.in);

    File file = new File(nameFile);
    AudioInputStream inGame  = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();

    @Override
    public String toString() {
        return "Test [nameFile=" + nameFile + ", scanner=" + scanner + ", file=" + file + ", inGame=" + inGame
                + ", clip=" + clip + "]";
    }
    

    
    
    
}