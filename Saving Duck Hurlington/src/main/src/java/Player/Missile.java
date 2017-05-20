package Player;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {

    private int x, y, vx, vy;
    private Image image;
    boolean visible;

    private final int BOARD_WIDTH = 800;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y, int vx, int vy) {

    	ImageIcon ii = new ImageIcon(this.getClass().getResource("/Missiles/missile.png"));
    	
    	if (vx == 0) {
    		ii = new ImageIcon(this.getClass().getResource("/Missiles/missile90.png"));
    	}
    	
    	image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVX() {
    	return vx;
    }
    
    public int getVY() {
    	return vy;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void move() {
    	if (vy == 0) {
           x += vx * MISSILE_SPEED;
    	}
    	
    	else if (vx == 0) {
    	   y += vy * MISSILE_SPEED;	
    	}
    	
        if (x > BOARD_WIDTH)
            visible = false;
    }
}
