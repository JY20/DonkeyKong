import greenfoot.*;  
/**
 * Write a description of class rightArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rightArrow extends Arrow
{
    boolean transfer;
    /**
     * Act - do whatever the rightArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { // When it touch mario then it go to the coin field world
        if (isTouching(Mario.class)) {
            Greenfoot.setWorld(new CoinField());
            
        }
    }    
    
}
