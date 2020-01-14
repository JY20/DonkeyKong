import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rightArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rightArrow extends Actor
{
    /**
     * Act - do whatever the rightArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Mario.class)) {
            Greenfoot.setWorld(new CoinField());
        }
    }    
}