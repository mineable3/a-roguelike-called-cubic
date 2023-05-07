package src;
//this class is the player graphic


import java.awt.Point;
import java.util.ArrayList;

import javax.swing.*;

public class Player extends JLabel{


    private int x = 100;
    private int y = 100;

    private int playerSpeed = 4;

    public final Sword s = new Sword(x, y);

    public ArrayList<Point> playerCollisionPoints = new ArrayList<Point>(2);


//==============================Constructors=====================================================================================
    public Player() {}

    public Player(int startingX, int startingY) {
        x = startingX;
        y = startingY;

        playerCollisionPoints.add(new Point(startingX, startingY));
        playerCollisionPoints.add(new Point(startingX + 20, startingY));
        playerCollisionPoints.add(new Point(startingX, startingY + 20));
        playerCollisionPoints.add(new Point(startingX + 20, startingY + 20));

        setCollisionPoints();
        this.setLayout(null);
        s.setOpaque(false);
        this.add(s);
        this.setOpaque(false);
    }

    public void setCollisionPoints() {

        hitPointsTrack(x, y, 1, playerCollisionPoints.get(0));
        hitPointsTrack(x, y, 2, playerCollisionPoints.get(1));
        hitPointsTrack(x, y, 3, playerCollisionPoints.get(2));
        hitPointsTrack(x, y, 4, playerCollisionPoints.get(3));
    }


    private void hitPointsTrack(int px, int py, int corner, Point point) {

        //top left corner
         if(corner == 1) {
            point.setLocation(px, py);
        }
        //top right corner
        else if (corner == 2) {
            point.setLocation(px + 20, py);
        }
        //bottom right corner
        else if (corner == 3) {
            point.setLocation(px + 20, py + 20);
        }
        //bottom left corner
        else if (corner == 4) {
            point.setLocation(px, py + 20);
        }
    }

    public Point getPlayerHitPoints(int index) {
        setCollisionPoints();
        return playerCollisionPoints.get(index);
    }



    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }




    public String soutCoords() {
        return ("( " + getXValue() + ", " + getYValue() + ")");
    }



//==============================Getter methods=====================================================================================


    public int getXValue() {
        return x;
    }

    public int getYValue() {
        return y;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }








//===============================Setter methods=========================================================================================


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPlayerSpeed(int newSpeed) {
        playerSpeed = newSpeed;
    }



//=================================Moving the character around======================================================================

    public void changeX(int amount) {
        x += amount;
    }

    public void changeY(int amount) {
        y += amount;
    }

    //NOT USED ANYWHERE
    public void moveCoords(int changeInX, int changeInY) {
        x += changeInX;
        y += changeInY;
    }



}