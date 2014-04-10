package Map;

import java.awt.Image;
import java.util.ArrayList;

import JohnnyComeLately.Creature;
import JohnnyComeLately.Item;
import JohnnyComeLately.Projectile;
 
  public class Rooms {
	
    
	private Image[][] display;
  
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
	public Rooms(Tiles t, int xIn, int yIn){
		
		tile = t;
		LoadMap(t);
		display = setTile(xIn, yIn);
		

	}
	
	public Image[][] setTile(int x, int y){
		
		return tile.swapTile(x, y);
	}
	
	public Tiles LoadMap(Tiles t){
		
		t.createMap();
	    t.clearDoors();
	    t.genBorders();
	    t.addDoors();
		
		return t;
	}

	public void CreateRooms(){
		
		//for(int i = 0; int i < MapSize; i++)
           		
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
		//empty creature array list
		//copy item from room to this, reference not hardcopy
		//copy creature array list from room to this hardcopy not referencey
		//copy tile from room to this, hardcopy not reference
		//copy IsCleared from room to this, reference not hardcopy
	}
	
	

}
