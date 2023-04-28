package src;
//this class is the player graphic


import javax.swing.*;

public class Player extends JLabel{


    private int x = 100;
    private int y = 100;

    private int playerSpeed = 4;

    public final Sword s = new Sword(x, y);


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