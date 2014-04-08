package Map;

import java.awt.Image;
import java.util.ArrayList;

import JohnnyComeLately.*;
 
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
	
	public Rooms(Tiles t, Player p, int xIn, int yIn){
		
		LoadMap(t);

	}
	
	
	public Tiles LoadMap(Tiles t){
		
		t.createMap();
	    t.clearDoors();
	    t.genBorders();
	    t.addDoors();
		
		return t;
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
	
	public Rooms CloneNext(){
		
		return null;
	}
	
	

}
