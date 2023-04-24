package demos;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
/*
	this is Version 4 of a little video game template thingy.
	now the other box follows you about
	W,A,S,D for the movement of the player
*/
public class Game extends Canvas implements Runnable
{
 static Thread thread;
 public int width = 500, height = 300, boxSize = 10;
 public InputHandler input;
 public Player player = new Player();
 public Box box = new Box();
 int boxDir = 0;
	 public static void main(String args[])
	 {
		 JFrame frame = new JFrame();
		 Game game = new Game();
		 frame.setResizable(false);
		 frame.setTitle("Game");
		 frame.add(game);
		 frame.pack();
		 frame.setDefaultCloseOperation(3);
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
	 	 thread.start();
	}
	 public Game()
	 {
		 Dimension size = new Dimension(width, height);
		 setPreferredSize(size);
		 setMinimumSize(size);
		 setMaximumSize(size);
		 thread = new Thread(this, "Game");
		 input = new InputHandler();
		 addKeyListener(input);
	 }
	 public void run()
	 {
		long lastLoopTime = System.nanoTime();
		final long second = 1000000000;
		final int fps = 150;
		while(true)
	    {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double)second/fps);
			update(delta);
			render();
			try{Thread.sleep((lastLoopTime-System.nanoTime())/1000000+10);}
			catch(Exception ex){}
		}
	 }
	 public void update(double delta)
	 {
		 double speed = delta;
		 if(input.keys[KeyEvent.VK_W])
		 {
			 	player.setY(player.getY() - speed);
			 	if(player.getY() < 0)player.setY(player.getY() + speed);
		 }
		 if(input.keys[KeyEvent.VK_S])
		 {
			 	player.setY(player.getY() + speed);
			 	if(player.getY() > height-boxSize)player.setY(player.getY() - speed);
		 }
		 if(input.keys[KeyEvent.VK_A])
		 {
			 	player.setX(player.getX() - speed);
			 	if(player.getX() < 0)player.setX(player.getX() + speed);
		 }
		 if(input.keys[KeyEvent.VK_D])
		 {
			 	player.setX(player.getX() + speed);
			 	if(player.getX() > width-boxSize)player.setX(player.getX() - speed);
		 }
		 player.setBounds((int)player.getX(), (int)player.getY(), boxSize, boxSize);
		 if(box.getY() < 0)box.setY(box.getY() + speed);
		 if(box.getY() > height-boxSize)box.setY(box.getY() - speed);
		 if(box.getX() < 0)box.setX(box.getX() + speed);
		 if(box.getX() > width-boxSize)box.setX(box.getX() - speed);
		 speed=delta*.35;
		 chase(speed);
		 collision();
	 }
	 private void collision()
	 {
		 if(box.intersects(player)) 
		 {
			 switch(boxDir)
			 {
			 	case 0: box.setY(box.getY() + 2);
			 			break;
			 	case 1: box.setY(box.getY() - 2);
			 			break;
			 	case 2: box.setX(box.getX() + 2);
			 			break;
			 	case 3: box.setX(box.getX() - 2);
			 			break;
			 	case 4: box.setY(box.getY() + 2);
			 			box.setX(box.getX() + 2);
			 			break;
			 	case 5: box.setY(box.getY() + 2);
			 			box.setX(box.getX() - 2);
			 			break;
			 	case 6: box.setY(box.getY() - 2);
			 			box.setX(box.getX() + 2);
			 			break;
			 	case 7: box.setY(box.getY() - 2);
			 			box.setX(box.getX() - 2);
			 			break;
			 }
		 }
		
	}
	public void chase(double speed)
		{
		 box.setBounds((int)box.getX(), (int)box.getY(), boxSize, boxSize);
			if (box.getX() > player.getX()+boxSize)
			{
				box.setX(box.getX()-speed);
				boxDir = 0;
			}  
			else if (box.getX()+boxSize < player.getX())
			{
				box.setX(box.getX()+speed);
				boxDir = 1;
			}
			if (box.getY() > player.getY()+boxSize)
			{
				box.setY(box.getY()-speed);
				boxDir = 2;
			}  
			else if (box.getY()+boxSize < player.getY())
			{
				box.setY(box.getY()+speed);
				boxDir = 3;
			}
			if (box.getX()+boxSize < player.getX()&&box.getY() > player.getY()+boxSize)
			{
				boxDir = 4;
			}
			if (box.getX() > player.getX()+boxSize&&box.getY()+boxSize < player.getY())
			{
				boxDir = 5;
			}
		}
	  public void render()
	  {
		  BufferStrategy bs = this.getBufferStrategy();
		  if(bs == null)
			{
				createBufferStrategy(2);
				return;
			}
			Graphics g = bs.getDrawGraphics();
			g.clearRect(0, 0, width, height);
			g.setColor(Color.black);
			g.fillRect((int)player.getX(), (int)player.getY(), boxSize, boxSize);
			g.fillRect((int)box.getX(), (int)box.getY(), boxSize, boxSize);

			g.dispose();
			bs.show();
	  }

class Player extends Rectangle
{
	private double x = 50;
	private double y = 50;
	public double getX(){return x;}
	public double getY(){return y;}
	public void setX(double x){this.x = x;}
	public void setY(double y){this.y = y;}
}
class Box extends Rectangle
{
	private double x = 100;
	private double y = 100;
	public double getX(){return x;}
	public double getY(){return y;}
	public void setX(double x){this.x = x;}
	public void setY(double y){this.y = y;}
}
class InputHandler implements KeyListener
{
 public boolean[] keys = new boolean[65536];
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		keys[keyCode] = true;
	}
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		keys[keyCode] = false;
	}
	public void keyTyped(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		keys[keyCode] = true;
	}
}
}