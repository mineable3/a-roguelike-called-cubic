package src;
import java.awt.Color;
import java.awt.MenuBar;

import javax.swing.*;


public class Window extends JFrame{

    private static boolean playing = true;


    public static Player p = new Player(Constants.playerStartingX, Constants.playerStartingY);
    public static Border b = new Border();
    public static Keyboard keyboard = new Keyboard();



    public Window() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.frameWidth, Constants.frameHeight);
        this.setLocation(Constants.frameX, Constants.frameY);
        this.setResizable(false);
        this.setTitle("fun video game");
        this.setMenuBar(new MenuBar());
        this.getMenuBar().setName("test");
        this.getContentPane().setBackground(new Color(54, 60, 79));
        this.add(keyboard);
        this.add(p);
        this.setVisible(true);
    }




    //the loop running during the game
    public void gameLoop() {

        while(playing) {
            movePlayer();
            swingSword();
            this.repaint();
            sleeep(10);
        }
    }



    public static void sleeep(int amountToSleep) {
        try {
            Thread.sleep(amountToSleep);
        } catch (InterruptedException i) {}
    }





    public static void movePlayer() {


        //If a single key is held down (cardinal directions)
        if(keyboard.getWHeld() && !keyboard.getDHeld() && !keyboard.getAHeld()) {//W
            p.changeY(-p.getPlayerSpeed());
        }
        if(keyboard.getSHeld() && !keyboard.getDHeld() && !keyboard.getAHeld()) {//S
            p.changeY(p.getPlayerSpeed());
        }
        if(keyboard.getAHeld() && !keyboard.getWHeld() && !keyboard.getSHeld()) {//A
            p.changeX(-p.getPlayerSpeed());
        }
        if(keyboard.getDHeld() && !keyboard.getWHeld() && !keyboard.getSHeld()) {//D
            p.changeX(p.getPlayerSpeed());
        }

        //If two keys are held down (diagonals)
        if(keyboard.getWHeld() && keyboard.getDHeld()) {
            p.changeY((int)Math.round(-p.getPlayerSpeed() * .707));//W
            p.changeX((int)Math.round(p.getPlayerSpeed() * .707));//D
        }
        if(keyboard.getWHeld() && keyboard.getAHeld()) {
            p.changeY((int)Math.round(-p.getPlayerSpeed() * .707));//W
            p.changeX((int)Math.round(-p.getPlayerSpeed() * .707));//A
        }
        if(keyboard.getSHeld() && keyboard.getDHeld()) {
            p.changeY((int)Math.round(p.getPlayerSpeed() * .707));//S
            p.changeX((int)Math.round(p.getPlayerSpeed() * .707));//D
        }
        if(keyboard.getSHeld() && keyboard.getAHeld()) {
            p.changeY((int)Math.round(p.getPlayerSpeed() * .707));//S
            p.changeX((int)Math.round(-p.getPlayerSpeed() * .707));//A
        }

        p.s.orbit(p.getXValue(), p.getYValue());
    }



    public static void swingSword() {

        //holding left
        if(keyboard.getLeftHeld() && !keyboard.getRightHeld()) {
            p.s.changeTheta(-Math.PI/90);
            p.s.orbit(p.getXValue(), p.getYValue());
        }

        //holding right
        if(keyboard.getRightHeld() && !keyboard.getLeftHeld()) {
            p.s.changeTheta(Math.PI/90);
            p.s.orbit(p.getXValue(), p.getYValue());
        }
    }
}