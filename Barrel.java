import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{
    public void act() 
    {
        setImage("barrel60.png");
        if(this.getX() == BackGround1.width)
        {
            getWorld().removeObject(this);
        } else{
          
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor2.class))
          {
            setLocation(getX() - 3, getY() - 3);
            turn(-20);
          }
          while((isTouching(Floor.class)||isTouching(Ladder.class)) && getY()< BackGround1.floors[0].getY()+3)
          {
            setLocation(getX() + 3, getY() - 3);
            turn(8);
          }
         
          if(isTouching(Hammer.class)){
              getWorld().removeObject(this);
              BackGround1.score += 50;
            }
          turn(8);
       }
    }
}
 

