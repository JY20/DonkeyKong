import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinField extends World
{

    /**
     * Constructor for objects of class CoinField.
     * 
     */
    long lT = System.currentTimeMillis();
    public static Mario mario = new Mario();
    
    public CoinField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(BackGround1.width, BackGround1.height, 1); 
        int [] xs = new int [] {BackGround1.width-830, BackGround1.width-530, BackGround1.width-230};
        int [] ys = new int [] {BackGround1.height-356, BackGround1.height-176, BackGround1.height-356};
        for(int i  = 0; i < 3; i++) {
            addObject(new Floor(), xs[i], ys[i]);
        }
        for(int i= 0; i < 6; i++) {
            addObject(new Floor(), 125 + (250*i), BackGround1.height);
        }
        mario.Lives = BackGround1.mainPlayer.Lives; 
        addObject(mario, 100, BackGround1.height-30);
        addObject(new leftArrow(), 50, ys[0]-50 );
        mario.JumpS = -(20);
    }
    public void act() {
        if (System.currentTimeMillis() - lT > 2000) {
            lT = System.currentTimeMillis();
            int y = (int)(Math.random() * ((BackGround1.height-30)+1)+30);
            int x = (int)(Math.random() * ((BackGround1.width-15)+1)+15);
            addObject(new Coin(),x ,y);
        }
    }
    
}