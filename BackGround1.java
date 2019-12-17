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
    public static int screenW = 700;
    int [] fx = new int [] {125, 625};
    int [] fy = new int [] {200, 430};
    /**
     * Constructor for objects of class BackGround1.
     * 
d     */
    public BackGround1()
    {    
        super(screenL, screenW, 1); 
        addObject(new DK(), 200, fy[0]-60);
        
        //
        for(int i= 0; i < 4; i++) {
            addObject(new Floor(), fx[0] + (250*i), fy[0]);
            addObject(new Floor2(), fx[1] + (250*i), fy[1]);
        } 
        
        for(int i= 0; i < 6; i++) {
            addObject(new Floor(), 125+ (250*i), 781);
        }    
        addObject(new Mario(), 125, 940);
    }
}
