import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends Actor
{
    /**
     * Act - do whatever the Shop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("pixelshop.png");
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new ShopBackground());
        }
    }    
}
