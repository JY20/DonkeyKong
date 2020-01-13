import greenfoot.*;
public class DK extends Actor
{
    long lastTime;
    public static int [] levels = new int [] {BackGround1.screenW-670, BackGround1.screenW-330, BackGround1.screenW};
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            //Greenfoot.setWorld(new Finish());
            //Greenfoot.setWorld(new Background2());
            //Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 4000)
        {
            
            lastTime = System.currentTimeMillis();
            setImage("Throwing.png");
            getWorld().addObject(new Barrel(), getX() + 50, getY());
        }else if(System.currentTimeMillis() - lastTime > 350)
        {
            setImage("donkey-kong_standing.png");
        }
       
    }    
}
