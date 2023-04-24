package src.enemies;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class BasicEnemy extends JLabel implements Enemy{

    private int x, y;

    private int speed = 1;
    private int hp = 10;

    private Rectangle bounds = new Rectangle(20, 20);

    
    //public static Player p = new Player(Constants.playerStartingX, Constants.playerStartingY);



    public BasicEnemy() {
        this.setLocation(x, y);
        this.setBounds(x, y, 20, 20);
        //this.setLayout(null);
        //this.add(p);
        this.setOpaque(false);

    }

    


    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }

    
    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void setHP(int newHP) {
        hp = newHP;
    }

    @Override
    public void changeHP(int hpToAdd) {
        hp += hpToAdd;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int inSpeed) {
        speed = inSpeed;
    }
}
