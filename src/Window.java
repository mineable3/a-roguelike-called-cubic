package src;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MenuBar;

import javax.swing.*;

import src.enemies.BasicEnemy;


public class Window extends JFrame{

    private static boolean playing = true;


    public static Border b = new Border();
    public static Board board = new Board();



    public Window() {
        //h.add(be, Integer.valueOf(1));
        //this.setContentPane(h);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.frameWidth, Constants.frameHeight);
        this.setLocation(Constants.frameX, Constants.frameY);
        this.setResizable(false);
        this.setTitle("fun video game");
        this.getContentPane().setBackground(new Color(54, 60, 79));

        //FlatLightLaf.setup(); //setting the look and feel
        //this.setUndecorated(true);
        //this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);


        //this.add(board);
        this.add(board);
        //this.add(be);

        this.setLayout(null);
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
        if(board.keyboard.getWHeld() && !board.keyboard.getDHeld() && !board.keyboard.getAHeld()) {//W
            board.p.changeY(-board.p.getPlayerSpeed());
        }
        if(board.keyboard.getSHeld() && !board.keyboard.getDHeld() && !board.keyboard.getAHeld()) {//S
            board.p.changeY(board.p.getPlayerSpeed());
        }
        if(board.keyboard.getAHeld() && !board.keyboard.getWHeld() && !board.keyboard.getSHeld()) {//A
            board.p.changeX(-board.p.getPlayerSpeed());
        }
        if(board.keyboard.getDHeld() && !board.keyboard.getWHeld() && !board.keyboard.getSHeld()) {//D
            board.p.changeX(board.p.getPlayerSpeed());
        }

        //If two keys are held down (diagonals)
        if(board.keyboard.getWHeld() && board.keyboard.getDHeld()) {
            board.p.changeY((int)Math.round(-board.p.getPlayerSpeed() * .71));//W
            board.p.changeX((int)Math.round(board.p.getPlayerSpeed() * .71));//D
        }
        if(board.keyboard.getWHeld() && board.keyboard.getAHeld()) {
            board.p.changeY((int)Math.round(-board.p.getPlayerSpeed() * .71));//W
            board.p.changeX((int)Math.round(-board.p.getPlayerSpeed() * .71));//A
        }
        if(board.keyboard.getSHeld() && board.keyboard.getDHeld()) {
            board.p.changeY((int)Math.round(board.p.getPlayerSpeed() * .71));//S
            board.p.changeX((int)Math.round(board.p.getPlayerSpeed() * .71));//D
        }
        if(board.keyboard.getSHeld() && board.keyboard.getAHeld()) {
            board.p.changeY((int)Math.round(board.p.getPlayerSpeed() * .71));//S
            board.p.changeX((int)Math.round(-board.p.getPlayerSpeed() * .71));//A
        }

    }



    public static void swingSword() {

        //holding left
        if(board.keyboard.getLeftHeld() && !board.keyboard.getRightHeld()) {
            board.p.s.changeTheta(-Math.PI/90);
        }

        //holding right
        if(board.keyboard.getRightHeld() && !board.keyboard.getLeftHeld()) {
            board.p.s.changeTheta(Math.PI/90);
        }

        board.p.s.orbit(board.p.getXValue(), board.p.getYValue());
    }




    public static void moveEnemy() {
        board.p.getLocation();
    }
}