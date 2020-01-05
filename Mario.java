
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
    long lastTime;
    int Lives = 3;
    int textLX = 750;
    int textLY = 600;
    public int score = 100;
    String test = "12";
    public void act() {
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        try {
            findHighScore();
            getWorld().showText(test, BackGround1.screenL/2, 100);
        } catch(IOException ioe) {
        }
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
            BackGround1.limage[Lives].remove();
        }
        if(Lives == 0)
        {
            getWorld().showText("GAME OVER", BackGround1.screenL/2, BackGround1.screenW/2);
            Greenfoot.stop();
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
                {
                    speed = - 24;
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
           
           setImage("mariopixelCopy.png");
            
            while(isTouching(Floor.class))
            {
               move(1);
            } 
        } else {
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
            {
               move(5);
               setImage("mariopixel.png");
                while(isTouching(Floor.class))
                {
                  move(-1);
               }
            } else{
                setImage("mario-big.png");
            }
        }
              while(isTouching(Ladder.class) && (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))){
            
                speed = -23;
                 if(getY() > 555){
                    setLocation(getX(), getY() - 1);
                }
            }
          
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            speed = 50;
        }
    } 
    public void findHighScore() throws IOException{
        FileReader fr = new FileReader("Score.txt");
        FileWriter fw = new FileWriter("Score.txt", true);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        String oldT = br.readLine();
        br.close();
        test = oldT;
        //int oldS = Integer.parseInt(oldT);
        
        /*if (score >= oldS) {
            bw.write(score);
        }else {
            bw.write(oldS);
        }
        bw.close();*/
    }
    
}
