import greenfoot.*;
public class DK extends Actor
{
    private long lastTime; // Last time donkey kong rolls a barrel
   
    public void act() 
    {// Rolls the barrel
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
