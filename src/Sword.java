package src;
import java.awt.*;
import javax.swing.*;

public class Sword extends JLabel{


    private double x, y;


    private double theta = -Math.PI/2;//what determines the starting orientation of the sword



    public Sword() {
        this.setLocation(Constants.playerStartingX, Constants.playerStartingY);
        this.setBounds((int)x, (int)y, 40, 40);
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



    //@Override
    //public void paintComponent(Graphics g) {
    //    super.paintComponent(g);
    //    g2d = (Graphics2D) g;
//
    //    //rotating the sword around its center
    //    g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
    //    g2d.rotate(theta + ((Math.PI)/2));//in radians
    //    g2d.translate(-image.getWidth(this) / 2, -image.getHeight(this) / 2);
//
    //    g2d.drawImage(image, 0, 0, null);
    //}


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
