import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class key extends Actor
{
    /**
     * Act - do whatever the key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int id = 0;
    public void act() 
    {
        if(isTouching(Mario.class)) {
            getWorld().removeObject(this);
            BackGround1.key ++;
            BackGround1.findOrnot[id] = false;
        }
    }
}
