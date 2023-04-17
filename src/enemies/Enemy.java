package src.enemies;

import java.awt.Rectangle;

public interface Enemy {

    Rectangle getBounds();//the hitbox of the enemy

    void setHP(int newHP);//setting the HP

    void changeHP(int hpToAdd);//adding/subtracting HP

    int getSpeed();//returns the speed of the enemy

    void setSpeed(int inSpeed);
}
