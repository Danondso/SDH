package Map;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import Entities_and_Player.Creature;
import Entities_and_Player.Item;
import Entities_and_Player.Projectile;
 
  public class Rooms {
	
    int roomSize = 16;
	private Image[][] display = new Image[roomSize][roomSize];
	private Rectangle[][]Collision = new Rectangle[roomSize][roomSize];
  
	// private Beach beach;
    // private Forest forest;
    // private Mountain mountain;
	private ArrayList<Creature> Creatures;
	private ArrayList<Projectile> Projectiles;
	public boolean cleared = false;
	public boolean itemSpawn = false;
	Item Item;
	private int x;
	private int y;
	//private Random rand = new Random(System.)
	
	
	Tiles tile;
	
	//I forgot why the X and Y values are in there D:<
	public Rooms(Tiles t, int xIn, int yIn, Item item){
		
		tile = t;
		//somethings about room spawn		
		display = setTile(xIn, yIn);
		Collision = setRect(xIn, yIn);
	    Item = item;
	
	}
	
	public Rooms(){
		//initializes by clearing everything
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				display[i][j] = null;
				Collision[i][j] = null;
			}
		}
		//clears the Creatures and Projectiles array
		Creatures = new ArrayList<Creature>();
		Projectiles = new ArrayList<Projectile>();
		Item = null;
	}
	
	public Image[][] setTile(int x, int y){
		
		return tile.swapTile(x, y);
	}
	
	public void setCreatures(int amount){
	
		//Neal needs to write a get random creature
		//public Creature getCreature(Tiles t, int amount)
		for(int i = 0; i <= amount; i ++)
		{
			
		//	int r = 
		//   Creatures.add(getCreature(t, random));
		   
		}
	}
	
	public Rectangle[][]setRect(int x, int y){
		return tile.swapRect(x, y);
	}

	public ArrayList<Projectile> getProArray(){
		return Projectiles;
	}
	
	public ArrayList<Creature> getCreArray(){
		return Creatures;
	}
	
	public Item getItem(){	
		return Item;
	}
	
	public void Clone(Rooms room){
		//empty projectile array list
		Projectiles.clear();
		
		//empty creature array list
		Creatures.clear();
		
		//copy item from room to this, reference not hardcopy
		Item = room.Item;
		
		//copy creature array list from room to this hardcopy not referencey
		if(!room.cleared){
			if(room.Creatures != null)
				for(Creature C : room.Creatures)
					if(C != null)
						room.Creatures.add(C.Clone());
	 	}
		//copy tile from room to this, reference not hardcopy
		//if(room != null)
			//if(room.display != null)
		display = room.display.clone();
		
		Collision = room.Collision.clone();
	    
		//copy IsCleared from room to this, reference not hardcopy
	    cleared = room.cleared; 
    
	}
	
	public Image[][] GetDisplay(){
		return display.clone();
	}
	
    public Rectangle[][] GetCollision(){
    	return Collision.clone();
    }
	
	
	
}
