
import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Mario extends Actor
{
    int speed;
    String Marioimage = "mariopixelCopy.png";
    private GreenfootImage image = new GreenfootImage("mariopixel2.png");
    private GreenfootImage image2 = new GreenfootImage("marioleft.png");
    private GreenfootImage image3 = new GreenfootImage("mariopixel.png");
    long lastTime;
    public static int Lives = 3;
    int textLX = 750;
    int textLY = 600;
    int JumpS = - 29;
    public static int oldS = 0;
  
    public Mario() {
        GreenfootImage image = getImage();
        GreenfootImage image2 = getImage();
        GreenfootImage image3 = getImage();
        setImage(image);
        setImage(image2);
        setImage(image3);
    }
    
    public void act() {
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        getWorld().showText( "Score "+BackGround1.score, BackGround1.width/2-100,100);
        getWorld().showText( "Number of keys    "+BackGround1.key, BackGround1.width/2, 50);
        BackGround1.MarioSpot[0] = getX();
        BackGround1.MarioSpot[1] = getY();
        try {
            findHighScore();
        } catch(IOException ioe) {
        }
        if(getX() < 15){
            setLocation(getX()+15, getY());
        } else if (getX() > BackGround1.width-15) {
            setLocation(getX()-15, getY());
        } else if (getY() > BackGround1.height-15) {
            setLocation(getX(), getY()+15);
        }
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
            BackGround1.limage[Lives].remove();
        }
        else if(isTouching(Coin.class)){
            removeTouching(Coin.class);
            BackGround1.score += 10;
        }
        if(Lives == 0)
        {
            Greenfoot.setWorld(new finishScreen());
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
                {
                    speed = JumpS;
                }
            }
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        }    
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
                move(-5);
            
                if(System.currentTimeMillis() - lastTime > 900)
                {
            
                    lastTime = System.currentTimeMillis();
                    setImage(image2);
                    image2.scale(76,65);
            
             }else if(System.currentTimeMillis() - lastTime > 500)
             {
                 setImage("mariopixelCopy.png");
              }
        } else {
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
            {
               move(5);
               if(System.currentTimeMillis() - lastTime > 900)
                {
            
                    lastTime = System.currentTimeMillis();
                    setImage(image);
                    image.scale(76,65);
            
                }else if(System.currentTimeMillis() - lastTime > 500)
                {
                setImage(image3);
                image3.scale(76,65);
                }
           } else{
                setImage("mario-big.png");
            }
        }
            if(isTouching(Ladder.class)){
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                    speed =- 5;
                }
                if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                    speed = 5;
                }
            }
               
    } 
    public void findHighScore() throws IOException{
        FileReader fr = new FileReader("Score.txt");
        BufferedReader br = new BufferedReader(fr);
        String oldT = br.readLine();
        br.close();
        oldS = Integer.parseInt(oldT);
        getWorld().showText( "High Score "+oldS, BackGround1.width/2+100, 100);
    }
}
