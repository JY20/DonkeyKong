import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startScreen extends World
{

    /**
     * Constructor for objects of class Background2.
     * 
     */
    public startScreen()
    {    
        //When start button is pressed then go to background1
        super(BackGround1.width, BackGround1.height, 1);
        addObject(new startButton(), BackGround1.width/2, BackGround1.height/2 );
    }
}
