import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class leftArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class leftArrow extends Arrow
{
    /**
     * Act - do whatever the leftArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Mario.class)) { // When it touch mario it goes back to background1
            BackGround1.MarioSpot[0] = BackGround1.screenW-200;
            BackGround1.MarioSpot[1] = BackGround1.fy[1]-100;
            BackGround1.mainPlayer.Lives = CoinField.mario.Lives;
            Greenfoot.setWorld(new BackGround1());
        }
    }    
}
