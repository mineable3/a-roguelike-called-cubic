package src.enemies;

import java.awt.Rectangle;
import javax.swing.JLabel;


public class BasicEnemy extends JLabel implements Enemy{

    private int x, y;
    private int width = 20, height = 20;

    private int speed = 2;
    private int hp = 10;

    private boolean isAlive = true;

    private Rectangle hitBox = new Rectangle(x, y, width, height);




    public BasicEnemy() {
        this.setLocation(x, y);
        this.setBounds(x, y, 20, 20);
        this.setOpaque(false);
    }



    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }




    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }


    public Rectangle getHitBox() {
        hitBox.setLocation(x, y);
        return hitBox;
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

    public int getXValue() {
        return x;
    }

    public void setX(int inX) {
        x = inX;
    }

    public int getYValue() {
        return y;
    }

    public void setY(int inY) {
        y = inY;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
