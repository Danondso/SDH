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
import Map.Beach;

public class Board extends JPanel implements ActionListener {

	  //Make variables move these to top so it doesnt break
    Rooms currentRoom = new Rooms();
    Player player = new Player(new Position(250,250));
    Map theMap = new Map(currentRoom, player);
    ArrayList<Creature> creature = currentRoom.getCreArray();
    ArrayList<Projectile> projectile = currentRoom.getProArray();
    boolean W = false;
    boolean A = false;
    boolean S = false;
    boolean D = false;
    boolean Up = false;
    boolean Left = false;
    boolean Down = false;
    boolean Right = false;
    Item item = currentRoom.getItem();
    boolean confirmation = false;
	private Timer timer;
    private Craft craft;
    private boolean mapdraw = true;
    private Beach b = new Beach();
    private Image[][] Map;
    private Position pos = new Position(250, 250);
    //private Rat rat = new Rat(pos);
    private Random Rand = new Random();
    private String GameState = "Play";

    
    public Board() {
    	
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        creature.add(new Rat(pos));
        //h
        //the map draws here
        b.createMap();
        //b.clearDoors();
        b.genBorders();
        b.clearDoors();
        b.sealBorders();
        b.addWater();
        Map = b.swapTile(0, 0);
        //setLayout(new BorderLayout());  
        //setContentPane(new JLabel(new ImageIcon(Map[0][0])));
        //setLayout(new FlowLayout());
        //rat.getImage();
       
        craft = new Craft();
        
        //rat.Move();
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
	        	       
	        	    try{
	        	    	g2d.drawImage(currentRoom.GetDisplay()[i][j], x, y, this);
	        	    		
	        	    	if(currentRoom.GetCollision()[i][j] == null)
	        	    	  currentRoom.GetCollision()[i][j].setBounds(x, y, 32, 32);
	   
	        	    	
	        	    	  
	        	    }catch(Exception e){}
	            }
	        }
	
	        //Draw the rat
	        //g2d.drawImage(rat.getImage(), rat.GetX(), rat.GetY(), this);

	        //Draw player, not craft
	        g2d.drawImage(player.getImage(), player.GetX(), player.GetY(), this);
	        
	        
	        
	        
	        for(Creature c : creature)
	        	if(c != null)
	        		g2d.drawImage(c.getImage(), c.GetX(), c.GetY(), this);
	          
	       	for(Projectile p : projectile)
	       		if(p != null)
	       			g2d.drawImage(p.getImage(), p.GetX(), p.GetY(), this);
	       	
	       	
	       	  
	        //When player collides with the far right.
/*	       	if (player.GetX() + player.GetMovingX() == getWidth()){
	       		//Clear crap
	       		// b.setNextCoord(1, 0);
	       		Map = b.swapTile(1, 0);
	       		//Change map
	       		player.SetX(0 - player.getImage().getWidth(null));
	        }
	          
	        //When player collides with the far left
	       	if (player.GetX() + player.GetMovingX() + player.getImage().getWidth(null) == 0){
	       		//Clear crap
	        	// b.setNextCoord(1, 0);
	        	Map = b.swapTile((-1), 0);
	        	//Change map
	        	player.SetX(getWidth());
	       	}
	        
	        //When player collides with the bottom.
	       	if (player.GetY() + player.GetMovingY() == getHeight()){
	       		//Clear crap
	        	//  b.setNextCoord(0, 1);
	        	Map = b.swapTile(0, 1);
	        	//Change map        	  
	        	player.SetY(0 - player.getImage().getHeight(null));
	       	}

	       	//When player collides with the top.
	        if (player.GetY() + player.GetMovingY() + player.getImage().getHeight(null) == 0){
	        	//Clear crap
	        	//  b.setNextCoord(0, 1);
	        	Map = b.swapTile(0, (-1));
	        	//Change map        	  
	        	player.SetY(getHeight());
	        }
			
	        /* This orients the projectiles so they are facing the right direction
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
	        }*/
	
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
        
        if(!D && !A)
        	player.SetXDirection(0);
        if(!W && !S)
        	player.SetYDirection(0);
        if(D && A)
        	player.SetXDirection(0);
        if(W)
        	player.SetYDirection(-1);
        if(S)
        	player.SetYDirection(1);
        if(A)
        	player.SetXDirection(-1);      
        if(D)
        	player.SetXDirection(1);
        
        
        if(!Right && !Left)
        	player.SetShotXDirection(0);
        if(!Up && !Down)
        	player.SetShotYDirection(0);
        if(Up)
        	player.SetShotYDirection(-1);
        if(Left)
        	player.SetShotXDirection(-1);
        if(Down)
        	player.SetShotYDirection(1);
        if(Right)
        	player.SetShotXDirection(1);
        
     	moveAllTheThings();
     	attack();
     	collisions();
     	removeSomeOfTheThings();
     	theMap.MapUpdate();
     	//rat.Move();
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
	            	//if(!S)
	            		//player.SetYDirection(0);
	            	W = false;
	            }
	            if(e.getKeyChar() == 's'){
	            	//if(!W)
	            		//player.SetYDirection(0);
	            	S = false;
	            }
	            if(e.getKeyChar() == 'a'){
	            	//if(!D)
	            		//player.SetXDirection(0);
	            	A = false;
	            }
	            if(e.getKeyChar() == 'd'){
	            	//if(!A)
	            		//player.SetXDirection(0);
	            	D = false;
	            }
	            
	            
	          //shooting things release
	            if(e.getKeyCode() == KeyEvent.VK_UP){
	            	//if(!Down)
	            		//player.SetShotYDirection(0);
	            	Up = false;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	//if(!Right)
	            		//player.SetShotXDirection(0);
	            	Left = false;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	//if(!Up)
	            		//player.SetShotYDirection(0);
	            	Down = false;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	            	//if(!Left)
	            		//player.SetShotXDirection(0);
	            	Right = false;
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
	            	//if(!S)
	            		//player.SetYDirection(-1);
	            	W = true;
	            }
	            if(e.getKeyChar() == 's'){
	            	//if(!W)
	            		//player.SetYDirection(1);
	            	S = true;
	            }
	            if(e.getKeyChar() == 'a'){
	            	//if(!D)
	            		//player.SetXDirection(-1);
	            	A = true;
	            }
	            if(e.getKeyChar() == 'd'){
	            	//if(!A)
	            		//player.SetXDirection(1);
	            	D = true;
	            }
	            
	            //shooting things
	            if(e.getKeyCode() == KeyEvent.VK_UP){
	            	//if(!Down)
	            		//player.SetShotYDirection(-1);
	            	Up = true;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	//if(!Up)
	            		//player.SetShotYDirection(1);
	            	Down = true;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	//if(!Right)
	            		//player.SetShotXDirection(-1);
	            	Left = true;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	            	//if(!Left)
	            		//player.SetShotXDirection(1);
	            	Right = true;
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
	    			if(j != null)
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
    	   	if(t != null)
	    	   	if(t.ShouldRemove())
	        		itrCreature.remove();
        }
    	//Check remove projectiles
    	while(itrProjectile.hasNext()){
    	   	Projectile t = itrProjectile.next();
    	   	if(t != null)
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