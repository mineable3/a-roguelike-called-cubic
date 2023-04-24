package src;
//this class is the player graphic


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends JLabel{


    private int x = 100;
    private int y = 100;

    private  int playerSpeed = 2;

    double theta;

    public final Sword s = new Sword();


//==============================Constructors=====================================================================================
    public Player() {}

    public Player(int startingX, int startingY) {
        x = startingX;
        y = startingY;

        this.setLayout(null);
        s.setOpaque(false);
        this.add(s);
        this.setOpaque(false);
    }




    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }

    //public void paintComponent(Graphics g) {
    //    //This is where the graphic is 'manufactured'
    //    super.paintComponent(g);
    //    try {
    //        g.drawImage((Image) ImageIO.read(new File(
    //            "C:/Users/emmet/Desktop/JavaProjects/keyListener/assets/PlayerSkin.png")), 
    //            (int)Math.round(x), 
    //            (int)Math.round(y), 
    //            getFocusCycleRootAncestor());
//
    //    } catch (IOException e) {}
 //
    //}
//



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
        s.moveCoords(x, y);
    }

    public void changeY(int amount) {
        y += amount;
        s.moveCoords(x, y);
    }

    //NOT USED ANYWHERE
    public void moveCoords(int changeInX, int changeInY) {
        x += changeInX;
        y += changeInY;
    }



}