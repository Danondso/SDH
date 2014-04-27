package Map;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Entities_and_Player.Creature;
import Entities_and_Player.DuckPirate;
import Entities_and_Player.Item;
import Entities_and_Player.Krabby;
import Entities_and_Player.Pattyogoose;
import Entities_and_Player.Player;
import Entities_and_Player.Position;
import Entities_and_Player.Projectile;
import Entities_and_Player.Rat;
import Entities_and_Player.SeaTurtle;
import Entities_and_Player.wilsonowisp;
 
  public class Rooms {
	
    int roomSize = 16;
	private Image[][] display = new Image[roomSize][roomSize];
	private Rectangle[][]Collision = new Rectangle[roomSize][roomSize];
	private ArrayList<Creature> Creatures = new ArrayList<Creature>();
	private ArrayList<Projectile> Projectiles;
	public boolean cleared = false;
	public boolean itemSpawn = false;
	protected Item Item;
	private int x;
	private int y;
	private Random randx = new Random(System.currentTimeMillis());
	private Random randy = new Random(System.currentTimeMillis());
	private Rat r;
    private SeaTurtle s;
    private Krabby k;
	private Tiles tile;
	protected Player player;
	

	public Rooms(Tiles t,Player p, int xIn, int yIn, Item item){
		
		player = p;
		tile = t;
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
	
	//Setter methods
	public Image[][] setTile(int x, int y){return tile.swapTile(x, y);}
	
	protected void setCreature(Tiles t, int x, int y){
    	
		if(t instanceof Beach)
		{
		for(int i = 0; i < 3 - randx.nextInt(2); i++)
		{
			
			if(x == 3 && y ==3)
			   Creatures.add(new wilsonowisp(new Position(100, 100), player));
				else{
						int yPos = 31 + randy.nextInt(481);
						int  xPos = 95 + randx.nextInt(386);
						Creatures.add(new Rat(new Position(xPos, yPos)));
						Creatures.add(new SeaTurtle(new Position(xPos, yPos)));
						Creatures.add(new Krabby(new Position(yPos, xPos)));
						Creatures.add(new DuckPirate(new Position(xPos, yPos),player));
					}
				}
			}
		else if(t instanceof Forest){
			
			if(x == 3 && y == 3)
				Creatures.add(new Pattyogoose(new Position(256, 256), player));
			for(int i = 0; i < 3 - randx.nextInt(2); i++)
			{
				int yPos = 31 + randy.nextInt(481);
				 int  xPos = 31 + randx.nextInt(386);
					//Creatures.add(new wolf(new Position(xPos, yPos), player));
					//Creatures.add(new Evilwoodduck(new Position(xPos, yPos)));
				 	Creatures.add(new Rat(new Position(xPos, yPos)));
					}	
				}
	}	
		
	public void setItem(Item i){Item = i;}
	
	public Rectangle[][]setRect(int x, int y){return tile.swapRect(x, y);}

	//Getter methods. 
	public Image[][] GetDisplay(){return display.clone();}
	
    public Rectangle[][] GetCollision(){return Collision.clone();}
    
	public ArrayList<Projectile> getProArray(){return Projectiles;}
	
	public ArrayList<Creature> getCreArray(){return Creatures;}
	
	public Item getItem(){return Item;}
	
	//Copies the blueprint into the display room.
	public void Clone(Rooms room){
		
		//Empty projectile array list
		//System.out.printf("%b\n", room.cleared);
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
						Creatures.add(C.clone());}	
		
		display = room.display.clone();	
			Collision = room.Collision.clone();	      
	}
//End class	
}
