package Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import JohnnyComeLately.Position;
import JohnnyComeLately.Rat;
import Map.Beach;
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private boolean mapdraw = true;
    private Beach b = new Beach();
    private Image[][] Map;
    private Position pos = new Position(250, 250);
    private Rat rat = new Rat(pos);
    private Random Rand = new Random();
    
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        
        //h
        //the map draws here
        b.createMap();
        b.clearDoors();
        b.genBorders();
        Map = b.swapTile(0, 0);
        //setLayout(new BorderLayout());  
        //setContentPane(new JLabel(new ImageIcon(Map[0][0])));
        //setLayout(new FlowLayout());
        //rat.getImage();
       
        craft = new Craft();
        
        rat.Move();
        timer = new Timer(5, this);
        timer.start();
    }

    public Image[][] getTile(){
    	
    	//Map = b.swapTile();
    	
    	return Map;
    }
    
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);      
       
        Graphics2D g2d = (Graphics2D)g;
        
        
        
        
        //if(Map == null)
        //   Map = b.getTile1();
            
            int wWin = getWidth() / b.tilerow;
            int hWin = getHeight() / b.tilecolumn;
               

            for(int i = 0; i < b.tilerow; i++)
             {
               for(int j = 0; j < b.tilecolumn; j++)
                 {
        	       int x = i * wWin;
        	       int y = j * hWin;
        	       
        	       g2d.drawImage(Map[i][j], x, y, this); 
                 }
             }

          
            
            
               rat.Move();
               g2d.drawImage(rat.getImage(), rat.GetX(), rat.GetY(), this);
            
        
          if (craft.getDX() == 1) {
        	g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(),this);
          }
        
          if (craft.getDX() == -1) {
        	g2d.drawImage(craft.getImage(), craft.getX() + craft.getImage().getWidth(this), craft.getY(), craft.getDX() * craft.getImage().getWidth(this), craft.getImage().getHeight(this), this);
          }
          
          //When it collides with the far right.
          if (craft.getX() + craft.getDX() == getWidth()){
        	  //Clear crap
        	 // b.setNextCoord(1, 0);
        	  Map = b.swapTile(1, 0);
        	  //Change map
        	  craft.setX(0 - craft.getCraftSize());
          }
          
          //When it collides with the far left
          if (craft.getX() + craft.getDX() + craft.getCraftSize() == 0){
        	  //Clear crap
        	//  b.setNextCoord((-1), 0);
        	  Map = b.swapTile((-1), 0);
        	  //Change map
        	  craft.setX(getWidth());
          }
        
          //When it collides with the bottom.
          if (craft.getY() + craft.getDY() == getHeight()){
        	  //Clear crap
        	//  b.setNextCoord(0, 1);
        	  Map = b.swapTile(0, 1);
        	  //Change map
        	  
        	  
        	  craft.setY(0 - craft.getCraftSize());
          }
          
          //When it collides with the top.
          if (craft.getY() + craft.getDY() + craft.getCraftSize() == 0){
        	  //Clear crap
        	 
        	  Map = b.swapTile(0, (-1));  	  
        	  //Change map
        	  craft.setY(getHeight());
          }
        
        else {
        	g2d
        	.drawImage(craft.getImage(), craft.getX(), craft.getY(), null);
        }
        
        ArrayList<Missile> ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++ ) {
            Missile m = (Missile) ms.get(i);
            if(m.getVX() == 1){
               g2d.drawImage(m.getImage(), m.getX(), m.getY(), m.getVX() * m.getImage().getWidth(this), m.getImage().getHeight(this), this);
            }
            
            if(m.getVX() == -1){
                g2d.drawImage(m.getImage(), m.getX() + craft.getCraftSize(), m.getY(), m.getVX() * m.getImage().getWidth(this), m.getImage().getHeight(this), this);
             }
            
            if(m.getVY() == -1){
                g2d.drawImage(m.getImage(), m.getX() + craft.getCraftSize() / 2, m.getY(), m.getVY() * m.getImage().getWidth(this), m.getImage().getHeight(this), this);
             }
            
            if(m.getVY() == 1){
                g2d.drawImage(m.getImage(), m.getX() + craft.getCraftSize() / 2, m.getY() + craft.getCraftSize() / 2, -m.getVY() * m.getImage().getWidth(this), -m.getImage().getHeight(this), this);
             }
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<Missile> ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }

        craft.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }   
}