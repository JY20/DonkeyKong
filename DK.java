import greenfoot.*;
public class DK extends Actor
{
    long lastTime;
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            //Greenfoot.setWorld(new Finish());
            Greenfoot.setWorld(new Background2());
            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 4000)
        {
            setImage("Throwing.png");
            lastTime = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
        }
    }    
}
