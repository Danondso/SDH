package Map;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Entities_and_Player.Creature;
import Entities_and_Player.Item;
import Entities_and_Player.Krabby;
import Entities_and_Player.Position;
import Entities_and_Player.Projectile;
import Entities_and_Player.Rat;
import Entities_and_Player.SeaTurtle;
 
  public class Rooms {
	
    int roomSize = 16;
	private Image[][] display = new Image[roomSize][roomSize];
	private Rectangle[][]Collision = new Rectangle[roomSize][roomSize];
  
	// private Beach beach;
    // private Forest forest;
    // private Mountain mountain;
	private ArrayList<Creature> Creatures = new ArrayList<Creature>();
	private ArrayList<Projectile> Projectiles;
	public boolean cleared = false;
	public boolean itemSpawn = false;
	Item Item;
	private int x;
	private int y;
	private Random randx = new Random(System.currentTimeMillis());
	private Random randy = new Random(System.currentTimeMillis());
	//private Random rand = new Random(System.)
    Rat r;
    SeaTurtle s;
    Krabby k;
	
	
	Tiles tile;
	
	//I forgot why the X and Y values are in there D:<
	public Rooms(Tiles t, int xIn, int yIn, Item item){
		
		tile = t;
		//somethings about room spawn		
		display = setTile(xIn, yIn);
		Collision = setRect(xIn, yIn);
		setCreature(tile, xIn, yIn);
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
	
	
	protected void setCreature(Tiles t, int x, int y){
    
		
		
		
		if(t instanceof Beach)
		{
		for(int i = 0; i < 3; i++)
		{
			
			int yPos = 31 + randy.nextInt(481);
			int  xPos = 95 + randx.nextInt(386);
			Creatures.add(new Rat(new Position(xPos, yPos)));
		    //r = new Rat(new Position(xPos, yPos));
		    //s = new SeaTurtle(new Position(xPos + yPos, yPos));
			//k = new Krabby(new Position(xPos, yPos + xPos));
		    //Creatures.add(r.Clone());
			//Creatures.add(s.Clone());
		    //Creatures.add(k.Clone());
			//Creature.add(new DuckPirate(new Position(x,y), p));
		}
		
		
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
	
	public void setItem(Item i){
		Item = i;
	}
	
	
	public void Clone(Rooms room){
		//empty projectile array list
		System.out.printf("%b\n", room.cleared);
		Projectiles.clear();
		
		//empty creature array list
		Creatures.clear();
		
		//copy item from room to this, reference not hardcopy
		Item = room.Item;
		
		//copy creature array list from room to this hardcopy not referencey

		cleared = room.cleared;
		
		if(!room.cleared){
			if(!room.Creatures.isEmpty())	
				for(Creature C : room.Creatures)
					if(C != null)
						Creatures.add(C.clone());
		}	
		
		//copy tile from room to this, reference not hardcopy
		//if(room != null)
			//if(room.display != null)
		display = room.display.clone();
		
		Collision = room.Collision.clone();
	    
		//copy IsCleared from room to this, reference not hardcopy
	    //cleared = room.cleared; 
    
	}
	
	public Image[][] GetDisplay(){
		return display.clone();
	}
	
    public Rectangle[][] GetCollision(){
    	return Collision.clone();
    }
	
	
	
}
