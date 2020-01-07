import greenfoot.*;

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
    public int [] fy = new int [] {screenW-600, screenW-300, screenW+80};
    public static Lives [] limage = new Lives [3];
    public static int score = 0; 
    /**
     * Constructor for objects of class BackGround1.
     * 
d     */
    public BackGround1()
    {    
        super(screenL, screenW, 1); 
        addObject(new DK(), 200, fy[0]-60);
        addObject(new Princess(), 700, 400);
        //
        for(int i= 0; i < 4; i++) {
            addObject(new Floor(), fx[0] + (250*i), fy[0]);
            addObject(new Floor2(), fx[1] + (250*i), fy[1]);
        } 
        
        for(int i= 0; i < 6; i++) {
            addObject(new Floor(), 125+ (250*i), fy[2]);
        }    
        for(int i= 0; i < 3; i++) {
            limage[i] = new Lives();
            addObject(limage[i], 50+(i*50), 50);
        }
        addObject(new Coin(), 200, 200);
        addObject(new Mario(), 125, 940);
        //addObject(new Ladder(), 450,556);
        setPaintOrder(Mario.class, Ladder.class);
    }
}
