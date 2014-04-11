package Map;

import java.awt.Image;
import java.util.ArrayList;

import JohnnyComeLately.Creature;
import JohnnyComeLately.Item;
import JohnnyComeLately.Projectile;
 
  public class Rooms {
	
    
	private Image[][] display = new Image[16][16];
  
	// private Beach beach;
    // private Forest forest;
    // private Mountain mountain;
	private ArrayList<Creature> Creatures;
	private ArrayList<Projectile> Projectiles;
	private boolean cleared = false;
	private boolean itemSpawn = false;
	Item Item;
	private int x;
	private int y;
	
	Tiles tile;
	
	//I forgot why the X and Y values are in there D:<
	public Rooms(Tiles t, int xIn, int yIn, Item item){
		
		tile = t;
		//somethings about room spawn
		
		
		display = setTile(xIn, yIn);
		

	}
	
	public Rooms(){
		//initializes by clearing everything
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				display[i][j] = null;
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
		for(Creature C : room.Creatures)
			room.Creatures.add(C.Clone());
		
		//copy tile from room to this, reference not hardcopy
	    display = room.display;
	    
		//copy IsCleared from room to this, reference not hardcopy
	    cleared = room.cleared; 
	    
	    
	    
	}
	
	

}
