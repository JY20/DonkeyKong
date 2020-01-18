import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class replayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class replayButton extends Actor
{
    /**
     * Act - do whatever the replayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { // when the replay button is been pressed it resets the whole game
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) {
            BackGround1.MarioSpot[0] = 125;
            BackGround1.MarioSpot[1] = 940;
            BackGround1.score = 0;
            BackGround1.key = 0;
            for(int i = 0; i < BackGround1.findOrnot.length; i++){
                BackGround1.findOrnot[i] = true;
            }
            BackGround1.foundP = false;
            Greenfoot.setWorld(new BackGround1());
        }
    }    
}
