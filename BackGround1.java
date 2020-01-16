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
    public static int screenL = 1500;
    public static int screenW = 1200;
    public static int [] fx = new int [] {125, 625};
    public static int [] fy = new int [] {screenW-670, screenW-330, screenW};
    public static Lives [] limage = new Lives [3];
    public static shopButton shopB = new shopButton();
    public static int score = 0; 
    public static int [] MarioSpot = new int []{10, 10};
    public static int key = 0;
    public static key [] keys = new key []{new key(),new key(),new key()}; 
    public static boolean [] findOrnot = new boolean []{true, true, true};
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-300); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    public static Floor[] floors = new Floor[11];
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
        addObject(scrollActor, MarioSpot[0], MarioSpot[1]);

        addObject(new DK(), 200, fy[0]-60);
        if(findOrnot[0] == true) {
            addObject(keys[0], 200, fy[0]-60);
            keys[0].id = 0;
        }
        if(findOrnot[1] == true) {
            addObject(keys[1], screenL-120, 200);
            keys[1].id = 1;
        }
        addObject(new Princess(), 700, 400);
        //
        for(int i= 0; i < 4; i++) {
            floors[i+7] = new Floor();
            addObject(floors[i+7], fx[0] + 250*(i-1), fy[0]);
            addObject(new Floor2(), fx[1] + (250*i), fy[1]);
        } 
      
        floors[0] = new Floor();
        addObject(floors[0], fx[0] + 850, fy[0]);
        addObject(shopB, 0,0);
        for(int i= 0; i < 6; i++) {
            floors[i+1] = new Floor();
            addObject(floors[i+1], 125 + (250*i), fy[2]);
        }    
        for(int i= 0; i < 3; i++) {
            limage[i] = new Lives();
            addObject(limage[i], 50+(i*50), 50);
        }
        addObject(new rightArrow(), screenL-50, fy[2]-100 );
        addObject(new Ladder(), 800,fy[0]+150);
        setPaintOrder(Mario.class,Barrel.class, Ladder.class);
    }
    public void act() {
        scroll();
    }
    
    private void scroll () {
        for(int i = 0; i < 3; i++) {
            limage[i].setLocation(50+(i*50), 50);
        }
        shopB.setLocation(200, 150);
        int dsx, dsy;
            dsx = scrollActor.getX() - width/2;
            dsy = scrollActor.getY() - height/2;
        scroller.scroll(dsx, dsy);
        
    }
}
