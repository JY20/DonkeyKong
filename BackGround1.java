import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

/*
 * Jimmy Yan
 * Quincy
 * Bilal
 * The auto scroll code is from Muizz
 * 1/17/2020
 */
public class BackGround1 extends World
{
    public static int screenW = 1500; // The world's width
    public static int screenH = 1200; // World's height
    public static int [] fx = new int [] {125, 625}; // The x values for the floors
    public static int [] fy = new int [] {screenH-670, screenH-330, screenH}; // The y values for the floors
    public static Lives [] limage = new Lives [3]; // Declare the objects for the lives
    public static int score = 0; // The score
    public static int [] MarioSpot = new int []{10, 10}; // The mario spot in the begining
    public static int key = 0; // The number of keys been found
    public static Mario mainPlayer = new Mario(); // Declare the main player
    public static key [] keys = new key []{new key(),new key(),new key()}; // Object for the keys
    public static boolean [] findOrnot = new boolean []{true, true, true}; // Boolean that tells the computer if the key is been found or not
    public static boolean foundP = false; // Tells the program if the princess is been saved or not
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-300); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    public static Floor[] floors = new Floor[11];
    private static int floorDist = 75;
    private Scroller scroller;
    private Actor scrollActor;
    private int backHeight, backWidth;
    GreenfootSound backgroundMusic = new GreenfootSound("Donkey Kong Theme song.mp3");
     
    public BackGround1()
    {    // Add the objects 
        super(width, height, 1, false);
        backgroundMusic.playLoop();
        GreenfootImage backImage = new GreenfootImage("board.jpg");
        backHeight = backImage.getHeight();
        backWidth = backImage.getWidth();
        scroller = new Scroller(this, backImage, screenW, screenH);
        scrollActor = mainPlayer;
        addObject(scrollActor, MarioSpot[0], MarioSpot[1]);

        addObject(new DK(), 200, fy[0]-60);
        
        if (foundP == false){
            addObject(new Princess(), 70, fy[0]-60);
        }
        if(findOrnot[0] == true) {
            addObject(keys[0], 200, fy[0]-60);
            keys[0].id = 0;
        }
        if(findOrnot[1] == true) {
            addObject(keys[1], screenW-120, 200);
            keys[1].id = 1;
        }
        if(findOrnot[2] == true && score >= 1000) {
            addObject(keys[2], 125, 900);
            keys[2].id = 2;
        }
        for(int i= 0; i < 4; i++) {
            floors[i+7] = new Floor();
            addObject(floors[i+7], fx[0] + 250*(i-1), fy[0]);
            addObject(new Floor2(), fx[1] + (250*i), fy[1]);
        } 
      
        floors[0] = new Floor();
        addObject(floors[0], fx[0] + 850, fy[0]);
        for(int i= 0; i < 6; i++) {
            floors[i+1] = new Floor();
            addObject(floors[i+1], 125 + (250*i), fy[2]);
        }    
        for(int i= 0; i < mainPlayer.Lives; i++) {
            limage[i] = new Lives();
            addObject(limage[i], 50+(i*50), 50);
        }
        addObject(new rightArrow(), screenW-50, fy[2]-100 );
        addObject(new Ladder(), 800,fy[0]+150);
        setPaintOrder(Mario.class,Barrel.class, Ladder.class);
    }
    public void act() { // Keep auto scroll when the main players moves
        scroll();
    }
    
    private void scroll () { // Functions that auto scroll 
        for(int i = 0; i < 3; i++) {
            limage[i].setLocation(50+(i*50), 50);
        }
        int dsx, dsy;
            dsx = scrollActor.getX() - width/2;
            dsy = scrollActor.getY() - height/2;
        scroller.scroll(dsx, dsy);
        
    }
}
