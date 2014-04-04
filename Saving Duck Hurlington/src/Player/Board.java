package Player;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Map.Beach;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private boolean mapdraw = true;
    private Beach b = new Beach();
    private Image[][] Map;
    
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);

        //h
        //the map draws here
        b.createMap();
        b.clearDoors();
        b.genBorders();
     //   b.divideMap();
      //  b.getTile1();
        //b.getTile2();
      //  Map = b.tile1;
        
        //setLayout(new BorderLayout());  
        //setContentPane(new JLabel(new ImageIcon(Map[0][0])));
        //setLayout(new FlowLayout());
                
        craft = new Craft();
        timer = new Timer(5, this);
        timer.start();
    }

    public Image[][] getTile(){
    	
    	Image[][] joe = Map;
    	
    	return joe;
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);      
       
        Graphics2D g2d = (Graphics2D)g;
   
        if(Map == null)
           Map = b.getTile1();
            
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
        
          if (craft.getDX() == 1) {
        	g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(),this);
          }
        
          if (craft.getDX() == -1) {
        	g2d.drawImage(craft.getImage(), craft.getX() + craft.getImage().getWidth(this), craft.getY(), craft.getDX() * craft.getImage().getWidth(this), craft.getImage().getHeight(this), this);
          }
          
          if (craft.getX() + craft.getDX() == getWidth()){
        	  //Clear crap
        	  Map = b.getTile2();
        	  //Change map
        	  craft.setX(0 - craft.getCraftSize());
          }
          
          if (craft.getX() + craft.getDX() + craft.getCraftSize() == 0){
        	  //Clear crap
        	  Map = b.getTile1();
        	  //Change map
        	  craft.setX(getWidth());
          }
        
          if (craft.getY() + craft.getDY() == getHeight()){
        	  //Clear crap
        	  Map = b.getTile5();
        	  //Change map
        	  
        	  
        	  craft.setY(0 - craft.getCraftSize());
          }
          
          if (craft.getY() + craft.getDY() + craft.getCraftSize() == 0){
        	  //Clear crap
        	  Map = b.getTile1();
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