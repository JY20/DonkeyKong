import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * Write a description of class BackGround1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround1 extends World
{
    public static int screenL = 1200;
    public static int screenW = 900;
    private int [] fx = new int [] {125, 625};
    public int [] fy = new int [] {screenW-680, screenW-330, screenW};
    public static Lives [] limage = new Lives [3];
    public static int score = 0; 
    
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-300); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    
    private static int floorDist = 75;
    private Scroller scroller;
    private Actor scrollActor;
    private int backHeight, backWidth;
    public BackGround1()
    {    
        super(width, height, 1, false);
        GreenfootImage backImage = new GreenfootImage("board.jpg");
        backHeight = backImage.getHeight();
        backWidth = backImage.getWidth();
        scroller = new Scroller(this, backImage, screenL, screenW);
        scrollActor = new Mario();
        // Adding actor
        addObject(scrollActor, 125, 940);

        addObject(new DK(), 200, fy[0]-60);
        addObject(new Princess(), 700, 400);
        //
        for(int i= 0; i < 4; i++) {
            addObject(new Floor(), fx[0] + 250*(i-1), fy[0]);
            addObject(new Floor2(), fx[1] + (250*i), fy[1]);
        } 
        addObject(new Floor(), fx[0] + 850, fy[0]);
        for(int i= 0; i < 6; i++) {
            addObject(new Floor(), 125+ (250*i), fy[2]);
        }    
        for(int i= 0; i < 3; i++) {
            limage[i] = new Lives();
            addObject(limage[i], 50+(i*50), 50);
        }
        addObject(new Coin(), 200, 200);
        //addObject(new Mario(), 125, 940);
        addObject(new Ladder(), 800,375);
        setPaintOrder(Mario.class,Barrel.class, Ladder.class);
    }
    public void act() {
        scroll();
    }
    
    private void scroll () {
        int dsx, dsy;
            dsx = scrollActor.getX() - 200;
            dsy = scrollActor.getY() - 200;
        scroller.scroll(dsx, dsy);
        
    }
}
