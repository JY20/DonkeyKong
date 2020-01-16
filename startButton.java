import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startButton extends Actor
{
    /**
     * Act - do whatever the startButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) {
            BackGround1.MarioSpot[0] = 125;
            BackGround1.MarioSpot[1] = 940;
            Greenfoot.setWorld(new BackGround1());
        }
    }    
}
