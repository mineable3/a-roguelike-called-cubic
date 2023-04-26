package src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import src.enemies.BasicEnemy;

public class Board extends JPanel {

    //sword graphics
    private ImageIcon icon = new ImageIcon("assets/SwordSkin.png");//where the sword picture is located
    private Image image = icon.getImage();
    private Graphics2D g2d;

    //basic enemy(be) graphics
    private ImageIcon beImageIcon = new ImageIcon("assets/BasicEnemy.png");
    private Image beImage = beImageIcon.getImage();


    public Keyboard keyboard = new Keyboard();
    public Player p = new Player(Constants.playerStartingX, Constants.playerStartingY);
    public BasicEnemy be = new BasicEnemy();

    public Board() {
        this.add(keyboard);
        //this.add(be);
        this.add(p);
        this.setLayout(null);
        this.setBounds(0, 0, Constants.frameWidth, Constants.frameHeight);
        this.setOpaque(false);
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

                g.drawImage(beImage, 100, 100, null);


            //Sword graphics
            g2d = (Graphics2D) g;

            //rotating the sword around its center
            g2d.translate(p.s.getWidth() / 2, p.s.getHeight() / 2);
            g2d.rotate(p.s.getTheta() + ((Math.PI)/2));//in radians
            g2d.translate(-image.getWidth(p.s) / 2, -image.getHeight(p.s) / 2);

            g2d.drawImage(image, 500, 500, null);
            } catch (IOException e) {}
    }

    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }


}
