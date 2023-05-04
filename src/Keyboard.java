package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Keyboard extends JPanel{


    //boolean values looked at by other files that represent the state of each key
    private boolean
    leftHeld = false,
    rightHeld = false,
    upHeld = false,
    downHeld = false,
    wHeld = false,
    aHeld = false,
    sHeld = false,
    dHeld = false;

    public static int swingCounter = 0;


    public Keyboard() {
        setButtonBindings();
        this.setOpaque(false);
    }




//===================================Action on press========================================================================================






    Action left = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            leftHeld = true;

            if((swingCounter % 2) == 0) {
                swingCounter += 1;

                if(getLeftHeld() && !getRightHeld() && Board.p.s.getTheta() > Math.PI) {
                    Board.direction = "ccw";
                } else if (getLeftHeld() && !getRightHeld() && Board.p.s.getTheta() < Math.PI) {
                    Board.direction = "cw";
                }
            }
        }
        
    };

    Action right = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            rightHeld = true;

            if((swingCounter % 2) == 0) {
                swingCounter += 1;

                if(getRightHeld() && !getLeftHeld() && Board.p.s.getTheta() < Math.PI) {
                    Board.direction = "ccw";
                } else if (getRightHeld() && !getLeftHeld() && Board.p.s.getTheta() > Math.PI) {
                    Board.direction = "cw";
                }
            }
            
        }
        
    };

    Action up = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            upHeld = true;
        }
        
    };

    Action down = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            downHeld = true;
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
            swingCounter += 1;
        }
        
    };

    Action rightReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            rightHeld = false;
            swingCounter += 1;
        }
        
    };

    Action upReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            upHeld = false;
        }
        
    };

    Action downReleased = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            downHeld = false;
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

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), 
                            "up");

        this.getActionMap().put("up",
                                up);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), 
                            "down");

        this.getActionMap().put("down",
                                down);

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

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), 
                                "upReleased");
    
        this.getActionMap().put("upReleased",
                                upReleased);

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), 
                                "downReleased");
    
        this.getActionMap().put("downReleased",
                                downReleased);
    
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

    public boolean getUpHeld() {
        return upHeld;
    }

    public boolean getDownHeld() {
        return downHeld;
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
