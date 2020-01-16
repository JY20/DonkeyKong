import greenfoot.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a description of class Finish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class finishScreen extends World
{   

    /**
     * Constructor for objects of class Finish.
     * 
     */
    public finishScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(BackGround1.width, BackGround1.height, 1); 
        int userScore = BackGround1.score;
        int oldS = Mario.oldS;
        showText( ""+oldS, BackGround1.width/2+50, 100);
        showText( ""+userScore, BackGround1.width/2-50, 100);
        addObject(new replayButton(), BackGround1.width/2, BackGround1.height/2);
        if (userScore >= oldS) {
            try {
                writeHighscore(userScore);
            } catch(IOException ioe) {
            }
        }
        BackGround1.mainPlayer.Lives = 3;
    }
    public void writeHighscore(int score) throws IOException{
        FileWriter fw = new FileWriter("Score.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Integer.toString(score));
        bw.close();
    }
}
