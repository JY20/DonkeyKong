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
    long lT = System.currentTimeMillis();;
    public CoinField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(BackGround1.width, BackGround1.height, 1); 
        int [] xs = new int [] {150, 450, 750};
        int [] ys = new int [] {220, 400, 220};
        for(int i  = 0; i < 3; i++) {
            addObject(new Floor(), xs[i], ys[i]);
        }
        for(int i= 0; i < 6; i++) {
            addObject(new Floor(), 125 + (250*i), BackGround1.height);
        }  
        Mario mario = new Mario();
        addObject(mario, 30, BackGround1.height-30);
        mario.JumpS = -20;
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