package src;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.*;

public class Sword extends JLabel{


    private double x, y;


    private double theta = -Math.PI/2;//what determines the starting orientation of the sword

    public ArrayList<Point> swordCollisionPoints = new ArrayList<Point>(2);



    public Sword(int playerX, int playerY) {
        this.setLocation(Constants.playerStartingX, Constants.playerStartingY);
        this.setBounds((int)x, (int)y, 40, 40);
        swordCollisionPoints.add(new Point((int)x - 0, (int)y - 0));
        swordCollisionPoints.add(new Point((int)x - 0, (int)y - 0));
        swordCollisionPoints.add(new Point((int)x - 0, (int)y - 0));
        swordCollisionPoints.add(new Point((int)x - 0, (int)y - 0));
        swordCollisionPoints.add(new Point((int)x - 0, (int)y - 0));
        setCollisionPoints(playerX, playerY);
    }


    public void setCollisionPoints(int px, int py) {

        hitPointsTrack(px, py, 0, swordCollisionPoints.get(0));
        hitPointsTrack(px, py, -20, swordCollisionPoints.get(1));
        hitPointsTrack(px, py, 20, swordCollisionPoints.get(2));
        hitPointsTrack(px, py, 10, swordCollisionPoints.get(3));
        hitPointsTrack(px, py, -10, swordCollisionPoints.get(4));
    }

    public Point getSwordHitPoints(int index) {
        return swordCollisionPoints.get(index);
    }

    public void moveCoords(int x, int y) {
        this.x = x;
        this.y = y;
       // this.setLocation(this.x + 6, this.y - 40);
    }




    public void orbit(int inX, int inY) {
        x = Math.cos(theta);//the coordinate around the unit circle
        y = Math.sin(theta);//the coordinate around the unit circle

        x *= 40;//radius of the circle the sword will rotate around
        y *= 40;//radius of the circle the sword will rotate around

        x += inX;//moving the center of the circle to the wanted place(the players coordinates)
        y += inY;//moving the center of the circle to the wanted place(the players coordinates)

        x = Math.round(x);//rounding to avoid any problems type casting
        y = Math.round(y);//rounding to avoid any problems type casting

        x -= 10;//the offsets to spin the sword around the center of the player
        y -= 10;//the offsets to spin the sword around the center of the player


        this.setLocation((int)x, (int)y);//the offsets to spin the sword around the center of the player
    }



    private void hitPointsTrack(int inX, int inY, int distanceFromTip, Point p) {

        double xh = Math.cos(theta),//the coordinate around the unit circle
               yh = Math.sin(theta);//the coordinate around the unit circle

        xh *= (40 - distanceFromTip);//radius of the circle the sword will rotate around
        yh *= (40 - distanceFromTip);//radius of the circle the sword will rotate around

        xh += inX + 20;//moving the center of the circle to the wanted place(the players coordinates)
        yh += inY + 20;//moving the center of the circle to the wanted place(the players coordinates)

        xh = Math.round(xh);//rounding to avoid any problems type casting
        yh = Math.round(yh);//rounding to avoid any problems type casting

        xh -= 10;//the offsets to spin the sword around the center of the player
        yh -= 10;//the offsets to spin the sword around the center of the player


        p.setLocation((int)xh, (int)yh);//the offsets to spin the sword around the center of the player
    }


    public double getTheta() {
        return theta;
    }

    public void setTheta(double newTheta) {
        theta = newTheta;
    }

    public void changeTheta(double amountToAdd) {
        theta += amountToAdd;
    }


    public double getXValue() {
        return x;
    }
    
    public double getYValue() {
        return y;
    }
}
