import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    public static Random rand = new Random();
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here
        
    }    
    public static void changeLocation(){
        int [] min = new int [] {30 ,30 ,30};
        int [] max = new int []{BackGround1.screenW-30,50,50};
        int y = (int)(Math.random() * ((2-0)+1));
        int x = (int)(Math.random() * ((max[y]-min[y])+1)+min[y]);
    }
}
