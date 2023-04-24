package src;

import java.awt.*;
import javax.swing.*;

public class Border extends JPanel{

    private int x = 100, y = 100;

    public Border() {
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }

    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }


    public void paintComponent(Graphics g) {
        //This is where the graphic is 'manufactured'
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        int width = 200;
        int height = 200;

        //g.fillOval((int)x, (int)y, width, height);
        //g.fillRect(x, y, width, height);
        //g.drawOval((int)x+1, (int)y+1, width-2, height-2);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
    
}
