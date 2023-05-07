package src;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.*;




public class Window extends JFrame{

    public static boolean playing = true;


    private static GridBagConstraints constraints = new GridBagConstraints();

    public static Board board = new Board();



    public Window() {
        //h.add(be, Integer.valueOf(1));
        //this.setContentPane(h);
        


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("fun video game");
        //this.getContentPane().setBackground(new Color(0, 255, 255));

        //making the cursor invisible
        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor to the JFrame.
        this.getContentPane().setCursor(blankCursor);

        //Makes the game full screen
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);



        this.setLayout(new GridBagLayout());

        this.setVisible(true);

        Border leftBorder = new Border(this.getWidth(), this.getHeight());
        Border rightBorder = new Border(this.getWidth(), this.getHeight());
        Border bottomBorder = new Border(this.getWidth(), this.getHeight());
        Border topBorder = new Border(this.getWidth(), this.getHeight());

        this.setVisible(false);

        //the left and right borders
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.ipady = this.getHeight();
        constraints.ipadx = (this.getWidth() - Constants.gameSize) / 2;
        this.add(leftBorder, constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.ipady = this.getHeight();
        constraints.ipadx = (this.getWidth() - Constants.gameSize) / 2;
        this.add(rightBorder, constraints);


        //constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.ipady = Constants.gameSize;
        constraints.ipadx = Constants.gameSize;
        this.add(board, constraints);

        constraints.ipadx = 0;


        //the bottom border which I might turn into a menu or inventory
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipady = this.getHeight() - Constants.gameSize;
        
        this.add(bottomBorder, constraints);


        //the bottom border which I might turn into a menu or inventory
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipady = this.getHeight() - Constants.gameSize;
        
        this.add(topBorder, constraints);

        //FlatLightLaf.setup(); //setting the look and feel
        
        //this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);



        this.setVisible(true);

    }




    //the loop running during the game
    public void gameLoop() {

        while(playing) {
            board.movePlayer();
            board.moveEnemy();
            board.swingSword();
            board.playerEnemyCollision();
            this.repaint();

            sleeep(20);
        }

        gameOver();
    }



    public static void sleeep(int amountToSleep) {
        try {
            Thread.sleep(amountToSleep);
        } catch (InterruptedException i) {}
    }



    public void gameOver() {
        this.remove(board);


        JComponent gameOverScreen = new JComponent() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.setColor(new Color(255, 0, 0));
                g.fillRect(0, 0, Constants.frameWidth, Constants.frameHeight);
            }
        };
        board.add(gameOverScreen);
        System.out.println("game over :(");
    }


}