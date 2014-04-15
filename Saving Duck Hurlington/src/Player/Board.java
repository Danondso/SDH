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
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.Timer;

import Entities_and_Player.*;
import Map.*;
import Player.*;
import Map.Beach;

public class Board extends JPanel implements ActionListener {

	  //Make variables move these to top so it doesnt break
    Rooms currentRoom = new Rooms();
    Player player = new Player(new Position(250,250));
    Map theMap = new Map(currentRoom, player);
    ArrayList<Creature> creature = currentRoom.getCreArray();
    ArrayList<Projectile> projectile = currentRoom.getProArray();
    Item item = currentRoom.getItem();
    boolean confirmation = false;
	private Timer timer;
    private Craft craft;
    private boolean mapdraw = true;
    private Beach b = new Beach();
    private Image[][] Map;
    private Position pos = new Position(250, 250);
    private Rat rat = new Rat(pos);
    private Random Rand = new Random();
    private String GameState = "Play";
    
    public Board() {
    	
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        //h
        //the map draws here
        b.createMap();
        //b.clearDoors();
        b.genBorders();
        b.clearDoors();
        b.sealBorders();
        b.addWater();
        Map = b.swapTile(3, 2);
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
        
        if(GameState == "Play"){
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
	
	               
	          g2d.drawImage(rat.getImage(), rat.GetX(), rat.GetY(), this);

	          if (craft.getDX() == 1) {
	        	g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(),this);
	          }
	        
	          if (craft.getDX() == -1) {
	        	g2d.drawImage(craft.getImage(), craft.getX() + craft.getImage().getWidth(this), craft.getY(), craft.getDX() * craft.getImage().getWidth(this), craft.getImage().getHeight(this), this);
	          }

	          //Draw player, not craft
	       	  g2d.drawImage(player.getImage(), player.GetX(), player.GetY(), this);
	          
	       	  for(Projectile p : projectile)
	       		  if(p != null)
	       			  g2d.drawImage(p.getImage(), p.GetX(), p.GetY(), this);
	       	  
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
	        	g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), null);
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
    }

    public void actionPerformed(ActionEvent e) {
    	 //THIS IS MAIN LOOP
        ArrayList<Missile> ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }

     	  moveAllTheThings();
     	  attack();
     	  collisions();
     	  removeSomeOfTheThings();
     	 rat.Move();
        //craft.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	if(GameState == "StartMenu"){
        		//Start Menu Stuff
        	}
        	else if(GameState == "Play"){
	            craft.keyReleased(e);
	            //Player move release
	            if(e.getKeyChar() == 'w'){
	            	player.SetYDirection(0);
	            }
	            if(e.getKeyChar() == 'd'){
	            	player.SetXDirection(0);
	            }
	            if(e.getKeyChar() == 's'){
	            	player.SetYDirection(0);
	            }
	            if(e.getKeyChar() == 'a'){
	            	player.SetXDirection(0);
	            }
	            
	          //shooting things release
	            if(e.getKeyCode() == KeyEvent.VK_UP){
	            	player.SetShotYDirection(0);
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	player.SetShotXDirection(0);
	            }
	            if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	player.SetShotYDirection(0);
	            }
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	            	player.SetShotXDirection(0);
	            }
        	}
        	else if(GameState == "Pause"){
        		//Pause Menu Stuff
        	}
        }

        public void keyPressed(KeyEvent e) {
        	if(GameState == "StartMenu"){
        		//Start Menu Stuff
        		if(e.getKeyCode() == KeyEvent.VK_ENTER){
        			System.out.println("ENTER PRESSED");
        			GameState = "Play";
        		}
        		if(e.getKeyChar() == 'u'){
        			//display unlock
        		}
        		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
        			//disply are you sure???
        			confirmation = true;
        		}
        		if(confirmation && e.getKeyChar() == 'y'){
        			GameState = "Exit";
        		}
        		if(confirmation && e.getKeyChar() == 'n'){
        			confirmation = false;
        		}
        	}
        	
        	else if(GameState == "Play"){
	            craft.keyPressed(e);
	            //Player Movement
	            if(e.getKeyChar() == 'w'){
	            	player.SetYDirection(-1);
	            }
	            if(e.getKeyChar() == 's'){
	            	player.SetYDirection(1);
	            }
	            if(e.getKeyChar() == 'a'){
	            	player.SetXDirection(-1);
	            }
	            if(e.getKeyChar() == 'd'){
	            	player.SetXDirection(1);
	            }
	            
	            //shooting things
	            if(e.getKeyCode() == KeyEvent.VK_UP){
	            	player.SetShotYDirection(-1);
	            }
	            if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	player.SetShotYDirection(1);
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	player.SetShotXDirection(-1);
	            }
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	            	player.SetShotXDirection(1);
	            }
	            
	            //Pause game
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	player.SetXDirection(0);
	            	player.SetYDirection(0);
	            	GameState = "StartMenu";
	            }
	        }
        	else if(GameState == "Pause"){
        		//Pause Menu Stuff
        	}
        }
    }   
    //Zac's stuff dont delete it

    //I do what I want
    
    //Movement function
    public void moveAllTheThings(){
    	for(Creature i: creature){
    		i.Move();
    	}
    	player.Move();
    	synchronized(projectile){
	    	for(Projectile j: projectile){
	    		if(j != null)
	    			j.Move();
	    	}
    	}
    }
    
    //Collision Function
    public void collisions(){
    	//player and creatures hitting each other
    	if(!creature.isEmpty()){
	    	for(Creature i: creature){
	    		i.Collide(player);
	    		player.Collide(i);
	    		//creatures hitting projectiles
	    		for(Projectile j: projectile){
	    			i.Collide(j);
	    		}
    		}
    	}
    	//player hitting projectile
    	synchronized(projectile){
	    	if(!projectile.isEmpty()){
		    	for(Projectile k: projectile){
		    		if(k != null)
		    			player.Collide(k);
		    	}
	    	}
    	}
    	//Player hit the item
    	if(currentRoom.cleared && item != null){
    		player.Collide(item);
    	}
    }
    
    //Attack Function
    public void attack(){
    	//creature attack
    	synchronized(projectile){
	    	for(Creature i: creature){
	    		projectile.add(i.Attack());
	    	}
	    	//player attack
	    	projectile.add(player.Attack());
    	}
    }
    
    //Remove Stuff
    public void removeSomeOfTheThings(){
        Iterator<Creature> itrCreature = creature.iterator(); 
        Iterator<Projectile> itrProjectile = projectile.iterator();

    	while(itrCreature.hasNext()){
    	   	Creature t = itrCreature.next();
    	   	if(t.ShouldRemove())
        		itrCreature.remove();
        }
    	//Check remove projectiles
    	while(itrCreature.hasNext()){
    	   	Projectile t = itrProjectile.next();
    	   	if(t.ShouldRemove())
        		itrProjectile.remove();
        }
    	//Check remove item how to do this??
    	if(item != null){
    		if(item.ShouldRemove()){
    			item = null;
    		}
    	}
    	//Check remove player
    	if(player.ShouldRemove()){
    		//gameState = "dead";
    	}    	
    }
    
    public void displayMainMenu(){
    	
    }
    
    
}