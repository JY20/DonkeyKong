import greenfoot.*;

/**
 * Write a description of class Princess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Princess extends Actor
{
    /**
     * Act - do whatever the Princess wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Mario.class) && BackGround1.key == 3) {
            getWorld().removeObject(this);
            BackGround1.score = BackGround1.score*2;
        }
    }    
}
