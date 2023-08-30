package src.enemies;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import src.Constants;
import src.Window;


public class BasicEnemy extends JLabel implements Enemy{

    private int x = 0, y = 0;
    private int width = 20, height = 20;

    private int speed = 2;

    private boolean isAlive = true;

    private Rectangle hitBox = new Rectangle(x, y, width, height);

    private ArrayList<String> sidesSpawnable = new ArrayList<String>(4);

    private boolean
        leftSpawnable = true,
        rightSpawnable = true,
        topSpawnable = true,
        bottomSpawnable = true;

    private String
        left = "left",
        right = "right",
        top = "top",
        bottom = "bottom";




    public BasicEnemy(int x, int y) {
        this.x = x;
        this.y = y;
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


    public void resetEnemy() {

        //getting a new random number different from last time
        double side = Math.random();
        double location = Math.random();

        //if the number is outside our JFrame keep looking until we find one that fits
        while ((side > .6) ||
        ((side <= .15) && !topSpawnable) ||//TOP SIDE
        (((side <= .3) && (side > .15)) && !leftSpawnable) ||//LEFT SIDE
        (((side <= .45) && (side > .3)) && !bottomSpawnable) ||//BOTTOM SIDE
        ((side >.45) && !rightSpawnable))//RIGHT SIDE
        {
            side = Math.random();
        }

        //if the number is outside our JFrame keep looking until we find one that fits
        while (location > .6) {
            location = Math.random();
        }

        location = Math.round(location * 1000);

        //TOP SIDE
        if((side <= .15) && topSpawnable) {
            topSpawnable = false;
            sidesSpawnable.add(top);
            this.setLocation(0, (int)location);
        }

        //LEFT SIDE
        else if (((side <= .3) && (side > .15)) && leftSpawnable) {
            leftSpawnable = false;
            sidesSpawnable.add(left);
            this.setLocation((int)location, 0);
        }

        //BOTTOM SIDE
        else if (((side <= .45) && (side > .3)) && bottomSpawnable) {
            bottomSpawnable = false;
            sidesSpawnable.add(bottom);
            this.setLocation((int)location, Constants.gameSize);
        }

        //RIGHT SIDE
        else if ((side >.45) && rightSpawnable) {
            rightSpawnable = false;
            sidesSpawnable.add(right);
            this.setLocation(Constants.gameSize, (int)location);
        } else {
            System.out.println("randomizing the enemies location went wrong");
            Window.playing = false;
        }

        resetSpawnableSides();

        this.setIsAlive(true);
    }

    private void resetSpawnableSides() {

        String removedSide;

        if(sidesSpawnable.size() == 3) {
            removedSide = sidesSpawnable.get(0);
            sidesSpawnable.remove(0);
            if(removedSide == "top") {
                topSpawnable = true;
            } else if(removedSide == "left") {
                leftSpawnable = true;
            } else if (removedSide == "bottom") {
                bottomSpawnable = true;
            } else if (removedSide == "right") {
                rightSpawnable = true;
            }
        }
    }
}
