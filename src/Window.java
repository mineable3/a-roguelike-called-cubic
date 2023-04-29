package src;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.midi.Soundbank;
import javax.swing.*;

import src.enemies.BasicEnemy;



public class Window extends JFrame{

    private static boolean playing = true;

    private static boolean
        leftSpawnable = true,
        rightSpawnable = true,
        topSpawnable = true,
        bottomSpawnable = true;

        private static ArrayList<String> sidesSpawnable = new ArrayList<String>(4);

    private static String
        left = "left",
        right = "right",
        top = "top",
        bottom = "bottom";



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
            moveEnemy();
            swingSword();
            playerEnemyCollision();
            this.repaint();

            sleeep(20);
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
            board.p.changeY((int)Math.round(-board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//W
            board.p.changeX((int)Math.round(board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//D
        }
        if(board.keyboard.getWHeld() && board.keyboard.getAHeld()) {
            board.p.changeY((int)Math.round(-board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//W
            board.p.changeX((int)Math.round(-board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//A
        }
        if(board.keyboard.getSHeld() && board.keyboard.getDHeld()) {
            board.p.changeY((int)Math.round(board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//S
            board.p.changeX((int)Math.round(board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//D
        }
        if(board.keyboard.getSHeld() && board.keyboard.getAHeld()) {
            board.p.changeY((int)Math.round(board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//S
            board.p.changeX((int)Math.round(-board.p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//A
        }

    }



    public static void swingSword() {

        //holding left
        if(board.keyboard.getLeftHeld() && !board.keyboard.getRightHeld()) {
            board.p.s.changeTheta(-Math.PI/30);
        }

        //holding right
        if(board.keyboard.getRightHeld() && !board.keyboard.getLeftHeld()) {
            board.p.s.changeTheta(Math.PI/30);
        }

        board.p.s.orbit(board.p.getXValue(), board.p.getYValue());
    }




    public static void moveEnemy() {
        int xDiff = board.p.getXValue() - board.be.getXValue();
        int yDiff = board.p.getYValue() - board.be.getYValue();

        int xHolder = (int) Math.round(xDiff * (board.be.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + board.be.getXValue());
        int yHolder = (int) Math.round(yDiff * (board.be.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + board.be.getYValue());


        board.be.setLocation(xHolder, yHolder);
    }






    public static void playerEnemyCollision(/*Player p, BasicEnemy be*/) {

        for(int i = board.p.s.swordCollisionPoints.size(); i > 0; i--) {

            board.p.s.setCollisionPoints(board.p.getXValue(), board.p.getYValue());

            if (board.be.getHitBox().contains(board.p.s.getSwordHitPoints(i - 1))) {
                board.be.setIsAlive(false);
                resetEnemy(board.be);
            }
        }
    }



    public static void resetEnemy(BasicEnemy be) {

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
            be.setLocation(0, (int)location);
            System.out.println("TOP");
        }

        //LEFT SIDE
        else if (((side <= .3) && (side > .15)) && leftSpawnable) {
            leftSpawnable = false;
            sidesSpawnable.add(left);
            be.setLocation((int)location, 0);
            System.out.println("LEFT");
        }

        //BOTTOM SIDE
        else if (((side <= .45) && (side > .3)) && bottomSpawnable) {
            bottomSpawnable = false;
            sidesSpawnable.add(bottom);
            be.setLocation((int)location, 600);
            System.out.println("BOTTOM");
        }

        //RIGHT SIDE
        else if ((side >.45) && rightSpawnable) {
            rightSpawnable = false;
            sidesSpawnable.add(right);
            be.setLocation(600, (int)location);
            System.out.println("RIGHT");
        } else {
            System.out.println("randomizing the enemies location went wrong");
            playing = false;
        }

        resetSpawnableSides();

        be.setIsAlive(true);
    }

    private static void resetSpawnableSides() {

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