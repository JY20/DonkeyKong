import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Mario extends Actor
{
    int speed; // The speed of mario
    String Marioimage = "mariopixelCopy.png"; // Declare the images
    private GreenfootImage image = new GreenfootImage("mariopixel2.png");
    private GreenfootImage image2 = new GreenfootImage("marioleft.png");
    private GreenfootImage image3 = new GreenfootImage("mariopixel.png");
    private long lastTime; // Last time mario image got changed
    public static int Lives = 3; // The amount of lives
    int JumpS = - 29; // The jump speed
    public static int oldS = 0; // The previous high score
  
    public Mario() { // Set the images
        GreenfootImage image = getImage();
        GreenfootImage image2 = getImage();
        GreenfootImage image3 = getImage();
        setImage(image);
        setImage(image2);
        setImage(image3);
    }
    
    public void act() {
        speed = speed + 1;
        setLocation( getX(), getY() + speed); // Change the location the of mario 
        // The score and everything the player wants to know
        getWorld().showText( "Score "+BackGround1.score, BackGround1.width/2-100,100);
        getWorld().showText( "Number of keys    "+BackGround1.key, BackGround1.width/2, 50);
        try { // Find the previous high score
            findHighScore();
        } catch(IOException ioe) {
        }
        if(getX() < 15){ // making mario stay inside the world
            setLocation(getX()+15, getY());
        } else if (getX() > BackGround1.width-15) {
            setLocation(getX()-15, getY());
        } else if (getY() > BackGround1.height-15) {
            setLocation(getX(), getY()+15);
        }
        if(isTouching(Barrel.class)) // When it's touching the barrel class then remove the barrel and decrease the lives
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
            BackGround1.limage[Lives].remove();
        }
        else if(isTouching(Coin.class)){ // When it's touching the coin class then remove the coin and increase the live
            removeTouching(Coin.class);
            BackGround1.score += 10;
        }
        if(Lives == 0) // When lives is 0 then set the world to finish screen
        {
            Greenfoot.setWorld(new finishScreen());
        }
        if(speed > 0)
        { // When mario touch the floor no gravity will apply to it
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
        { // mario movement with the keys
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
            if(isTouching(Ladder.class)){ // Mario movement when keys are pressed and touching the ladder
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                    speed =- 5;
                }
                if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                    speed = 5;
                }
                if((Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w"))&& getY()< BackGround1.floors[0].getY()+3){
                    speed = JumpS;
                }
            }
               
    } 
    public void findHighScore() throws IOException{ // Find the high score and show it 
        FileReader fr = new FileReader("Score.txt");
        BufferedReader br = new BufferedReader(fr);
        String oldT = br.readLine();
        br.close();
        oldS = Integer.parseInt(oldT);
        getWorld().showText( "High Score "+oldS, BackGround1.width/2+100, 100);
    }
}
