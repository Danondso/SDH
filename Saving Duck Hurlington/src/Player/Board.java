package Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Entities_and_Player.*;
import Map.*;

public class Board extends JPanel implements ActionListener {

	  //Make variables move these to top so it doesnt break
    Rooms currentRoom = new Rooms();
    Player player;// = new Player(new Position(256 - 25,256 - 25));
    Map theMap;// = new Map(currentRoom, player);
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
    boolean confirmation = false;
	private Timer timer;
    private Craft craft;
    private boolean mapdraw = true;
    private Beach b = new Beach();
    private Image[][] Map;
    private Position pos = new Position(250, 250);
    //private Rat rat = new Rat(pos);
    private Random Rand = new Random();
    private String GameState = "StartMenu";
    private String StartMenuLoc = "/Menus/StartMenu.png";
    private String PauseMenuLoc = "/Menus/BlankPanel-2.png";
	double locationX, locationY, rotationRequired;
	AffineTransform tx;
	AffineTransformOp op;
	

    
    ImageIcon PauseIcon = new ImageIcon(this.getClass().getResource(PauseMenuLoc));
    private Image PauseMenu = PauseIcon.getImage();  
    
    ImageIcon DeadIcon = new ImageIcon(this.getClass().getResource(PauseMenuLoc));
    private Image DeadMenu = DeadIcon.getImage();
    
    ImageIcon StartIcon = new ImageIcon(this.getClass().getResource(StartMenuLoc));
    private Image StartMenu = StartIcon.getImage();
    
    Font MenuHeader = new Font("Helvetica", Font.BOLD, 24);
    FontMetrics MenuHeadMetr = this.getFontMetrics(MenuHeader);
    
    Font MenuContent = new Font("Helvetica", Font.BOLD, 14);
    FontMetrics MenuContMetr = this.getFontMetrics(MenuContent);
    
    AffineTransform identity = new AffineTransform();
      
    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        //Add misc creatures for testing under here
        creature.add(new DuckPirate(new Position(100,100), player));
        
        timer = new Timer(5, this);
        timer.start();
    }

    public Image[][] getTile(){
    	return Map;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);      
       
        AffineTransform trans = new AffineTransform();
        Graphics2D g2d = (Graphics2D)g;
        Graphics2D g2dRot = (Graphics2D)g;
        
        if(GameState == "StartMenu"){
        	g2d.drawImage(StartMenu, 0, 0, getWidth(), getHeight(), null);
        	if(confirmation){
       			g2d.setColor(Color.RED);
       			g2d.setFont(MenuHeader);
       			String ConfMsg = "Are you sure? y/n";
       			g2d.drawString(ConfMsg, (getWidth() - MenuHeadMetr.stringWidth(ConfMsg)) / 2, getHeight() * 2 / 5 + 100);
       		}
        }
        
       	if(GameState == "Dead"){
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
	        	    		
	        	    	if(currentRoom.GetCollision()[i][j] != null)
	        	    	{
	        	    		currentRoom.GetCollision()[i][j].setBounds(x, y, 32, 32);
	        	    	}
	        	    	  
	        	    }catch(Exception e){}
	            }
	        }
       	
       		//Draw Creatures
	        for(Creature c : creature)
	        	if(c != null)
	        		g2d.drawImage(c.getImage(), c.GetX(), c.GetY(), this);
       		
       		g2d.drawImage(DeadMenu, getWidth()/2 - DeadMenu.getWidth(null)/2, getHeight()/2 - DeadMenu.getHeight(null)/2, null);
      		
       		g2d.setColor(Color.BLACK);
       		g2d.setFont(MenuHeader);
       		
       		String MenuMsg = "Oh no you died!";
       		g2d.drawString(MenuMsg, (getWidth() - MenuHeadMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5);
       		
       		g2d.setFont(MenuContent);
       		MenuMsg = "'Enter' - Return to Start Menu";
       		g2d.drawString(MenuMsg, (getWidth() - MenuContMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5 + 25);
       		
       		MenuMsg = "'Esc' - Rage Quit";
       		g2d.drawString(MenuMsg, (getWidth() - MenuContMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5 + 50);

       		if(confirmation){
       			g2d.setColor(Color.RED);
       			g2d.setFont(MenuHeader);
       			MenuMsg = "Are you sure? y/n";
       			g2d.drawString(MenuMsg, (getWidth() - MenuHeadMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5 + 100);
       		}
       	}
        
        if(GameState == "Play" || GameState == "Pause"){
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
	        	    		
	        	    	if(currentRoom.GetCollision()[i][j] != null)
	        	    	{
	        	    		currentRoom.GetCollision()[i][j].setBounds(x, y, 32, 32);
	        	    	}
	        	    	  
	        	    }catch(Exception e){}
	            }
	        }

	        //Draw player, not craft
	        g2d.drawImage(player.getImage(), player.GetX(), player.GetY(), this);
	        
	        //Draw Creatures
	        for(Creature c : creature)
	        	if(c != null)
	        		g2d.drawImage(c.getImage(), c.GetX(), c.GetY(), this);
	          
	        //Draw Projectiles
	       	for(Projectile p : projectile)
	       		if(p != null){
	       			locationX = p.getImage().getWidth(null) / 2;
       				locationY = p.getImage().getHeight(null) / 2;
	       			if(p.GetSpeedX() > 0 && p.GetSpeedY() == 0){ //right
	       				rotationRequired = Math.toRadians(90);
	       			}
	       			else if(p.GetSpeedX() > 0 && p.GetSpeedY() < 0){ //right up
	       				rotationRequired = Math.toRadians(45);     				   				
	       			}
	       			else if(p.GetSpeedX() == 0 && p.GetSpeedY() < 0){ //up
	       				rotationRequired = Math.toRadians(0);     				   				
	       			}
	       			else if(p.GetSpeedX() < 0 && p.GetSpeedY() < 0){ // up left
	       				rotationRequired = Math.toRadians(315);     				   				
	       			}
	       			else if(p.GetSpeedX() < 0 && p.GetSpeedY() == 0){ //left
	       				rotationRequired = Math.toRadians(270);     				   				
	       			}
	       			else if(p.GetSpeedX() < 0 && p.GetSpeedY() > 0){ // left down
	       				rotationRequired = Math.toRadians(225);     				   				
	       			}
	       			else if(p.GetSpeedX() == 0 && p.GetSpeedY() > 0){ //down
	       				rotationRequired = Math.toRadians(180);     				   				
	       			}
	       			else if(p.GetSpeedX() > 0 && p.GetSpeedY() > 0){ //right down
	       				rotationRequired = Math.toRadians(135);     				   				
	       			}
	       			
	       			tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
	       			op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

       				g2d.drawImage(op.filter(toBufferedImage(p.getImage()), null), p.GetX(), p.GetY(), null);

	       		}
	       	//Draw the item
	       	if(currentRoom.cleared && currentRoom.getItem() != null){
	    		g2d.drawImage(currentRoom.getItem().getImage(), currentRoom.getItem().GetX(), currentRoom.getItem().GetY(), this);
	    	}
	       	
	       	
	       	if(GameState == "Pause"){
	       		g2d.drawImage(PauseMenu, getWidth()/2 - PauseMenu.getWidth(null)/2, getHeight()/2 - PauseMenu.getHeight(null)/2, null);
      		
	       		g2d.setColor(Color.BLACK);
	       		g2d.setFont(MenuHeader);
	       		
	       		String MenuMsg = "Pause";
	       		g2d.drawString(MenuMsg, (getWidth() - MenuHeadMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5);
	       		
	       		g2d.setFont(MenuContent);
	       		MenuMsg = "'Enter' - Resume";
	       		g2d.drawString(MenuMsg, (getWidth() - MenuContMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5 + 25);
	       		
	       		MenuMsg = "'Esc' - Return to Start Menu";
	       		g2d.drawString(MenuMsg, (getWidth() - MenuContMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5 + 50);

	       		if(confirmation){
	       			g2d.setColor(Color.RED);
	       			g2d.setFont(MenuHeader);
	       			MenuMsg = "Are you sure? y/n";
	       			g2d.drawString(MenuMsg, (getWidth() - MenuHeadMetr.stringWidth(MenuMsg)) / 2, getHeight() * 2 / 5 + 100);
	       		}
	       	}
	        Toolkit.getDefaultToolkit().sync();
	        g.dispose();
        }
    }

    public void actionPerformed(ActionEvent e) {
    	 //THIS IS MAIN LOOP

        if(GameState == "Play"){
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
	       	try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     	//Check if player is dead
	     	if(player.GetHealth() == 0){
	     		GameState = "Dead";
	     	}
        }
        
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	if(GameState == "StartMenu"){
        		//Start Menu Stuff
        	}
        	else if(GameState == "Play"){
	            //craft.keyReleased(e);
	            //Player move release
	            if(e.getKeyChar() == 'w'){
	            	W = false;
	            }
	            if(e.getKeyChar() == 's'){
	            	S = false;
	            }
	            if(e.getKeyChar() == 'a'){
	            	A = false;
	            }
	            if(e.getKeyChar() == 'd'){
	            	D = false;
	            }
	            
	            
	          //shooting things release
	            if(e.getKeyCode() == KeyEvent.VK_UP){
	            	Up = false;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	Left = false;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	Down = false;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	            	Right = false;
	            }
        	}
        	//Pause Menu Stuff
        	else if(GameState == "Pause"){
        		W = false;
        		S = false;
        		A = false;
        		D = false;
        		Up = false;
        		Left = false;
        		Down = false;
        		Right = false;
        	}
        }

        public void keyPressed(KeyEvent e) {
        	//Start Menu Stuff
        	if(GameState == "StartMenu"){
        		if(confirmation){
        			if(Character.toLowerCase(e.getKeyChar()) == 'y'){
        				System.exit(0);
        			}
        			if(Character.toLowerCase(e.getKeyChar()) == 'n')
        				confirmation = false;
        		}
        		
        		if(e.getKeyCode() == KeyEvent.VK_ENTER){
        				player = new Player(new Position(256 - 25,256 - 25));
        				theMap = new Map(currentRoom, player);
            			GameState = "Play";
            			//have mason display and then we need to change game state there as well
            		}
            		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            			//display are you sure?
            			confirmation = true;
            		}
            		if(confirmation && e.getKeyChar() == 'y'){
            			//confirm that they want to exit
            			GameState = "StartMenu";
            			confirmation = false;
            		}
            		if(confirmation && e.getKeyChar() == 'n'){
            			//they do not want to exit
            			confirmation = false;
            		}
        	}
        	//Pause Menu stuff
        	else if(GameState == "Pause"){
        		if(confirmation){
        			if(Character.toLowerCase(e.getKeyChar()) == 'y'){
        				GameState = "StartMenu";
        			}
        			if(Character.toLowerCase(e.getKeyChar()) == 'n')
        				confirmation = false;
        		}
        		
        		if(e.getKeyCode() == KeyEvent.VK_ENTER){
        		//	System.out.println("ENTER PRESSED");
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
        			GameState = "StartMenu";
        			confirmation = false;
        		}
        		if(confirmation && e.getKeyChar() == 'n'){
        			confirmation = false;
        		}
        	}
        	
        	else if(GameState == "Play"){
	            //craft.keyPressed(e);
	            //Player Movement
	            if(e.getKeyChar() == 'w'){
	            	W = true;
	            }
	            if(e.getKeyChar() == 's'){
	            	S = true;
	            }
	            if(e.getKeyChar() == 'a'){
	            	A = true;
	            }
	            if(e.getKeyChar() == 'd'){
	            	D = true;
	            }
	            
	            //shooting things
	            if(e.getKeyCode() == KeyEvent.VK_UP){
	            	Up = true;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	Down = true;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_LEFT){
	            	Left = true;
	            }
	            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	            	Right = true;
	            }
	            
	            //Pause game
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	GameState = "Pause";
	            }
	        }
        	else if(GameState == "Dead"){
        		if(confirmation){
        			if(Character.toLowerCase(e.getKeyChar()) == 'y'){
        				System.exit(0);
        			}
        			if(Character.toLowerCase(e.getKeyChar()) == 'n')
        				confirmation = false;
        		}
        		
        		if(e.getKeyCode() == KeyEvent.VK_ENTER){
        		//	System.out.println("ENTER PRESSED");
        			GameState = "StartMenu";
        			W = false;
            		S = false;
            		A = false;
            		D = false;
            		Up = false;
            		Left = false;
            		Down = false;
            		Right = false;
        		}
        		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
        			//disply are you sure???
        			confirmation = true;
        		}
        		if(confirmation && e.getKeyChar() == 'y'){
        			GameState = "StartMenu";
        			confirmation = false;
        		}
        		if(confirmation && e.getKeyChar() == 'n'){
        			confirmation = false;
        		}
        	}
        }
    }   
    //Zac's stuff dont delete it

    //I do what I want
    
    //Movement function
    public void moveAllTheThings(){
       	player.Move();
    	for(Creature i: creature){
    		i.Move();
    	}
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
    	if(currentRoom.cleared && currentRoom.getItem() != null){
    		player.Collide(currentRoom.getItem());
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
    	if(currentRoom.getItem() != null){
    		if(currentRoom.getItem().ShouldRemove()){
    			currentRoom.setItem(null);
    		}
    	}
    	//Check remove player
    	if(player.ShouldRemove()){
    		//gameState = "dead";
    	}    	
    }
    
    public void displayMainMenu(){
    	
    }
    
    //Converts Image to BufferedImage
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}