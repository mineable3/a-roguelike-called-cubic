package src;

import java.awt.*;
import javax.swing.*;

public class Border extends JPanel{

    private int x = 0, y = 0;
    private int width, height;

    public Border(int width, int height) {
        this.width = width;
        this.height = height;
        this.setVisible(true);
        this.setBounds(x, y, width, height);
    }

    public void paint() {//This is where the graphic is painted to the screen
        repaint();
    }


    public void paintComponent(Graphics g) {
        //This is where the graphic is 'manufactured'
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }
    
}
