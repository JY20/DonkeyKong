import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shopButton extends Actor
{
    private GreenfootImage image = new GreenfootImage("shopimage.png");
    public void act() 
    {
        // Add your action code here.
        setImage(image);
        image.scale(120,120);
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new ShopBackground());
    }    
}
}
