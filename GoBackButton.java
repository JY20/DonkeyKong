import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoBackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoBackButton extends shopButton
{
    /**
     * Act - do whatever the GoBackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new BackGround1());
        }   
    }    
}
