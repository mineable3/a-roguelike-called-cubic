package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import src.enemies.BasicEnemy;
import src.enemies.SpeedyEnemy;

public class Board extends JPanel {

    //sword graphics
    private ImageIcon icon = new ImageIcon("assets/SwordSkin.png");//where the sword picture is located
    private Image image = icon.getImage();
    private Graphics2D g2d;

    //basic enemy(be) graphics
    private ImageIcon beImageIcon = new ImageIcon("assets/BasicEnemy.png");
    private Image beImage = beImageIcon.getImage();

    //basic enemy(se) graphics
    private ImageIcon seImageIcon = new ImageIcon("assets/SpeedyEnemy.png");
    private Image seImage = seImageIcon.getImage();

    public Keyboard keyboard = new Keyboard();
    public static Player p = new Player(Constants.playerStartingX, Constants.playerStartingY);
    public BasicEnemy be = new BasicEnemy(0,0);
    public BasicEnemy beTwo = new BasicEnemy(0,0);
    public SpeedyEnemy se = new SpeedyEnemy();

    

    

    public static String direction = "";


        
    public Board() {
        this.add(keyboard);
        this.add(be);
        this.add(beTwo);
        this.add(se);
        this.add(p);
        this.setBounds(0, 0, Constants.gameSize, Constants.gameSize);
        this.setBackground(new Color(54, 60, 79));
        this.setOpaque(true);
        this.setVisible(true);
        this.paint();
    }


    public void paintComponent(Graphics g) {
        //This is where the graphic is 'manufactured'
        super.paintComponent(g);
        try {

            //Player graphics
            g.drawImage((Image) ImageIO.read(new File(
                "C:/Users/emmet/Desktop/JavaProjects/keyListener/assets/PlayerSkin.png")), 
                p.getXValue(),
                p.getYValue(),
                getFocusCycleRootAncestor());

            //Basic enemy graphics
            g.drawImage(beImage, be.getXValue(), be.getYValue(), null);
            g.drawImage(beImage, beTwo.getXValue(), beTwo.getYValue(), null);

            //Speedy enemy graphics
            g.drawImage(seImage, se.getXValue(), se.getYValue(), null);

            /* 
            draws the points that act as a hitbox for the sword

            g.setColor(new Color(0, 255, 0));
            for(int i = p.s.swordCollisionPoints.size(); i > 0; i--) {
                g.drawOval(
                    (int) p.s.getSwordHitPoints(i-1).getX(),
                    (int) p.s.getSwordHitPoints(i-1).getY(),
                    5,
                    5);
            }*/

            //Sword graphics
            g2d = (Graphics2D) g;


            //now works. idk what I changed, but it works now
            //rotating the sword around its center
            g2d.translate(p.s.getWidth() / 2, p.s.getHeight() / 2);
            g2d.rotate(p.s.getTheta() + ((Math.PI / 2)), p.s.getXValue(), p.s.getYValue());//in radians
            g2d.translate(-image.getWidth(p.s) / 2, -image.getHeight(p.s) / 2);

            g2d.drawImage(image, (int) p.s.getXValue(), (int) p.s.getYValue(), null);
            
            

            } catch (IOException e) {}
    }

    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }

    
    public void movePlayer() {


        //If a single key is held down (cardinal directions)
        if(keyboard.getWHeld() && ((!keyboard.getDHeld() && !keyboard.getAHeld()) || (keyboard.getDHeld() && keyboard.getAHeld())) && !keyboard.getSHeld()) {//W
            p.changeY(-p.getPlayerSpeed());
        }
        if(keyboard.getSHeld() && ((!keyboard.getDHeld() && !keyboard.getAHeld()) || (keyboard.getDHeld() && keyboard.getAHeld())) && !keyboard.getWHeld()) {//S
            p.changeY(p.getPlayerSpeed());
        }
        if(keyboard.getAHeld() && ((!keyboard.getWHeld() && !keyboard.getSHeld()) || (keyboard.getWHeld() && keyboard.getSHeld())) && !keyboard.getDHeld()) {//A
            p.changeX(-p.getPlayerSpeed());
        }
        if(keyboard.getDHeld() && ((!keyboard.getWHeld() && !keyboard.getSHeld()) || (keyboard.getWHeld() && keyboard.getSHeld())) && !keyboard.getAHeld()) {//D
            p.changeX(p.getPlayerSpeed());
        }

        //If two keys are held down (diagonals)
        if(keyboard.getWHeld() && keyboard.getDHeld() && !keyboard.getAHeld() && !keyboard.getSHeld()) {
            p.changeY((int)Math.round(-p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//W
            p.changeX((int)Math.round(p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//D
        }
        if(keyboard.getWHeld() && keyboard.getAHeld() && !keyboard.getDHeld() && !keyboard.getSHeld()) {
            p.changeY((int)Math.round(-p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//W
            p.changeX((int)Math.round(-p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//A
        }
        if(keyboard.getSHeld() && keyboard.getDHeld() && !keyboard.getAHeld() && !keyboard.getWHeld()) {
            p.changeY((int)Math.round(p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//S
            p.changeX((int)Math.round(p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//D
        }
        if(keyboard.getSHeld() && keyboard.getAHeld() && !keyboard.getDHeld() && !keyboard.getWHeld()) {
            p.changeY((int)Math.round(p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//S
            p.changeX((int)Math.round(-p.getPlayerSpeed() /*  * .71 include to dampen speed on diaganols*/));//A
        }

    }


    //Shortest distance method
    /*
    public void swingSword() {

        //holding left
        

        //holding right
        

        if (!keyboard.getRightHeld() && !keyboard.getLeftHeld()) {
            direction = "still";
        }

        if (direction == "cw") {
            p.s.changeTheta(Math.PI/30);
        } else if (direction == "ccw") {
            p.s.changeTheta(-Math.PI/30);
        } else if (direction == "still") {

        }

        p.s.orbit(p.getXValue(), p.getYValue());
    }*/

    //ORIGINAL METHOD
    
    public void swingSword() {

        //holding left
        if(keyboard.getLeftHeld() && !keyboard.getRightHeld()) {
            p.s.changeTheta(-Math.PI/30);
        }

        //holding right
        if(keyboard.getRightHeld() && !keyboard.getLeftHeld()) {
            p.s.changeTheta(Math.PI/30);
        }

        p.s.orbit(p.getXValue(), p.getYValue());
    }
     




    public void moveEnemy() {
        
        //moving the Basic enemy
        int xDiff = p.getXValue() - be.getXValue();
        int yDiff = p.getYValue() - be.getYValue();

        int xHolder = (int) Math.round(xDiff * (be.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + be.getXValue());
        int yHolder = (int) Math.round(yDiff * (be.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + be.getYValue());


        be.setLocation(xHolder, yHolder);

        
        xDiff = p.getXValue() - beTwo.getXValue();
        yDiff = p.getYValue() - beTwo.getYValue();

        xHolder = (int) Math.round(xDiff * (beTwo.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + beTwo.getXValue());
        yHolder = (int) Math.round(yDiff * (beTwo.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + beTwo.getYValue());


        beTwo.setLocation(xHolder, yHolder);
        


        //moving the Speedy enemy
        xDiff = p.getXValue() - se.getXValue();
        yDiff = p.getYValue() - se.getYValue();

        xHolder = (int) Math.round(xDiff * (se.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + se.getXValue());
        yHolder = (int) Math.round(yDiff * (se.getSpeed() / Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))) + se.getYValue());


        se.setLocation(xHolder, yHolder);
    }






    public void playerEnemyCollision() {


        //Sword collision with the enemies
        for(int i = p.s.swordCollisionPoints.size(); i > 0; i--) {

            p.s.setCollisionPoints(p.getXValue(), p.getYValue());

            if (be.getHitBox().contains(p.s.getSwordHitPoints(i - 1))) {
                be.setIsAlive(false);
                be.resetEnemy();
            }

            if (beTwo.getHitBox().contains(p.s.getSwordHitPoints(i - 1))) {
                beTwo.setIsAlive(false);
                beTwo.resetEnemy();
            }

            if (se.getHitBox().contains(p.s.getSwordHitPoints(i - 1))) {
                se.setIsAlive(false);
                se.resetEnemy();
            }
        }



        //Player collision with the enemies
        for(int i = p.playerCollisionPoints.size(); i > 0; i--) {

            p.s.setCollisionPoints(p.getXValue(), p.getYValue());

            if (be.getHitBox().contains(p.getPlayerHitPoints(i - 1))) {
                Window.playing = false;
            }

            if (se.getHitBox().contains(p.getPlayerHitPoints(i - 1))) {
                Window.playing = false;
            }
        }
    }

}
