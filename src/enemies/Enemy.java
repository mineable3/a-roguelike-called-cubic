package src.enemies;

import java.awt.Rectangle;

public interface Enemy {

    Rectangle getBounds();//the hitbox of the enemy

    int getSpeed();//returns the speed of the enemy

    void setSpeed(int inSpeed);

    void resetEnemy();//spawns the enemy on a random side
}
