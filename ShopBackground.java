import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopBackground extends World
{
    /**
     * Constructor for objects of class ShopBackground.
     * 
     */
    public ShopBackground()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(BackGround1.width, BackGround1.height, 1); 
        addObject(new GoBackButton(), BackGround1.width/2, BackGround1.height/2);
    }
}
