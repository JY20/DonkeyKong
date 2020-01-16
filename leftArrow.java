import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class leftArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class leftArrow extends Actor
{
    /**
     * Act - do whatever the leftArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (isTouching(Mario.class)) {
            BackGround1.MarioSpot[0] = BackGround1.screenL-200;
            BackGround1.MarioSpot[1] = BackGround1.fy[1]-100;
            //BackGround1.onetime = 0;
            BackGround1.mainPlayer.Lives = CoinField.mario.Lives;
            Greenfoot.setWorld(new BackGround1());
        }
    }    
}

