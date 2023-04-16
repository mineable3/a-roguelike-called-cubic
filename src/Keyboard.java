package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Keyboard extends JPanel{


    //boolean values looked at by other files that represent the state of each key
    private boolean
    leftHeld = false,
    rightHeld = false,
    wHeld = false,
    aHeld = false,
    sHeld = false,
    dHeld = false;


    public Keyboard() {
        setButtonBindings();
        this.setOpaque(false);
    }




//===================================Action on press========================================================================================






    Action left = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            /*theta -= (Math.PI / 60);
            s.orbit(theta, x, y);*/
            leftHeld = true;
        }
        
    };

    Action right = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            rightHeld = true;
        }
        
    };

    Action wPressed = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            wHeld = true;
        }
        
    };

    Action aPressed = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            aHeld = true;
        }
        
    };

    Action sPressed = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            sHeld = true;
        }
    };

    Action dPressed = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            dHeld = true;
        }
    };



//=======================Actions on release====================================================================================



    Action leftReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            leftHeld = false;
        }
        
    };

    Action rightReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            rightHeld = false;
        }
        
    };

    Action wReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            wHeld = false;
        }
        
    };

    Action aReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            aHeld = false;
        }
        
    };

    Action sReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            sHeld = false;
        }
        
    };

    Action dReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            dHeld = false;
        }
        
    };


//=====================================Setting the input and action maps===========================================================




    public void setButtonBindings(){



//==========================When pressed bindings===================================================================================




        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
                            "left");

        this.getActionMap().put("left",
                                left);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), 
                            "right");

        this.getActionMap().put("right",
                                right);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false),
                            "wPressed");

        this.getActionMap().put("wPressed",
                                wPressed);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false),
                            "aPressed");

        this.getActionMap().put("aPressed",
                                aPressed);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false),
                            "sPressed");

        this.getActionMap().put("sPressed",
                                sPressed);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false),
                            "dPressed");

        this.getActionMap().put("dPressed",
                                dPressed);







//===================================When released bindings======================================================================





        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true),
                                "leftReleased");
    
        this.getActionMap().put("leftReleased",
                                leftReleased);
    
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), 
                                "rightReleased");
    
        this.getActionMap().put("rightReleased",
                                rightReleased);
    
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true),
                                "wReleased");
    
        this.getActionMap().put("wReleased",
                                wReleased);
    
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true),
                                "aReleased");
    
        this.getActionMap().put("aReleased",
                                aReleased);
    
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true),
                                "sReleased");
    
        this.getActionMap().put("sReleased",
                                sReleased);
    
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true),
                                "dReleased");
    
        this.getActionMap().put("dReleased",
                                dReleased);
    }



//==================================Getter methods======================================================================================


    public boolean getLeftHeld() {
        return leftHeld;
    }

    public boolean getRightHeld() {
        return rightHeld;
    }

    public boolean getWHeld() {
        return wHeld;
    }

    public boolean getAHeld() {
        return aHeld;
    }

    public boolean getSHeld() {
        return sHeld;
    }

    public boolean getDHeld() {
        return dHeld;
    }
}
