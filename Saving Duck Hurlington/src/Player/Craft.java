package Player;

import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Craft {

    private String craft = "/Player/player_male.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
    private ArrayList<Missile> missiles;
    
    private final int CRAFT_SIZE = 20;

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        missiles = new ArrayList();
        x = 100;
        y = 60;
    }


    public void move() {
        x += dx;
        y += dy;
    }
    
    public int getCraftSize() {
    	return CRAFT_SIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int Xin) {
    	x = Xin;
    }
    
    public void setY(int Yin) {
    	y = Yin;
    }
    
    public int getDX() {
    	return dx;
    }

    public int getDY() {
        return dy;	
    }
    
    public Image getImage() {
        return image;
    }
    
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            fire(e);
        }

        if (key == KeyEvent.VK_A) {
            dx = -1;
        }

        if (key == KeyEvent.VK_D) {
            dx = 1;
        }

        if (key == KeyEvent.VK_W) {
            dy = -1;
        }

        if (key == KeyEvent.VK_S) {
            dy = 1;
        }
    }

    public void fire(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_RIGHT) {
           missiles.add(new Missile(x + CRAFT_SIZE, y + CRAFT_SIZE/2, 1, 0));
    	}
    	
    	if (key == KeyEvent.VK_LEFT) {
            missiles.add(new Missile(x - CRAFT_SIZE, y + CRAFT_SIZE/2, -1, 0));
     	}
     	
    	if (key == KeyEvent.VK_UP) {
            missiles.add(new Missile(x + CRAFT_SIZE/2, y - CRAFT_SIZE, 0, -1));
     	}
     	
    	if (key == KeyEvent.VK_DOWN) {
            missiles.add(new Missile(x + CRAFT_SIZE/2, y + CRAFT_SIZE, 0, 1));
     	}
     	
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}