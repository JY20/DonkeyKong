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
    int id = 0; // The id of the key tells the program which key was found 
    public void act() 
    {  // If the main player touch the key that increase of the number of keys found 
        // It also tells the background1 to not add this key because it's been found already
        if(isTouching(Mario.class)) {
            getWorld().removeObject(this);
            BackGround1.key ++;
            BackGround1.findOrnot[id] = false;
        }
    }
}
