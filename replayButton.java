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
    {
        setImage("Replaybutton.png");
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new BackGround1());
        }
    }    
}
