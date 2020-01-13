
import greenfoot.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
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
    int Lives = 3;
    int textLX = 750;
    int textLY = 600;
    public static int score = 0;
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
        getWorld().showText( ""+score, BackGround1.width/2-50, 100);
        try {
            findHighScore();
        } catch(IOException ioe) {
        }
        if(getX() < 15){
            setLocation(getX()+15, getY());
        } else if (getX() > BackGround1.width-15) {
            setLocation(getX()-15, getY());
        }
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
            BackGround1.limage[Lives].remove();
        }
        if(isTouching(Coin.class)){
            removeTouching(Coin.class);
            score += 10;
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
                    speed = - 29;
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
        getWorld().showText( ""+oldS, BackGround1.width/2+50, 100);
    }
    public void writeHighscore() throws IOException{
        FileWriter fw = new FileWriter("Score.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
    }
}
