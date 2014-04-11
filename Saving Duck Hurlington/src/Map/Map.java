package Map;
import JohnnyComeLately.Item;
import JohnnyComeLately.ItemPool;
import JohnnyComeLately.Player;

public class Map {

	private int MapSize = 4;
	private Rooms[][] blueprint;
	private Rooms[][] blueprintBeach;
	private Rooms[][] blueprintForest;
	private Rooms[][] blueprintMountain;
	private Player player;
	private Rooms room;
	int X = 0;
	int Y = 0;
	
	private Beach b = new Beach();
	private Forest f = new Forest();
	private Mountain m = new Mountain();
	
	
	public Map(Rooms r, Player p)
	{
		//nested for loop generating the room array;
		player = p;
		room = r;
		loadMap(b);
		ItemPool itemPool =  new ItemPool();
		//loadMap(f);
		//loadMap(m);
		blueprintBeach = createBlueprint(b, itemPool);
		//blueprintForest = createBluePrint(f, itemPool);
		//blueprintMountain = createBluePrint(m, itemPool);
		
		
	}
	
	
	
	
	//method to switch the working blueprint
	public void loadMap(Tiles t){
		
		t.createMap();
		t.clearDoors();
		t.genBorders();
		t.addDoors();
		
	}
	
	private Rooms[][] createBlueprint(Tiles t, ItemPool items){
		
        Item RoomItem;		
 		
		for(int i = 0; i < MapSize; i ++)	
		   {
			   for(int j = 0; j < MapSize; j ++)
			   {
				   //two rooms get an item
				   //bossroom gets an item
				   
				   //I need to write ifs to set up two more items 
			       if(i == 0 && j == 0)
				     RoomItem = items.NextItem();	   
			       else if(i == 3 && j == 3){
				     RoomItem = items.NextItem();
				     else if(i == 2 && j == 3)
				    	 RoomItem = items.NextItem();
				     else
				    	RoomItem = items.HeartItem();
				      
				   //every room besides the item rooms have a 1/3 chance of a heart spawn
				   
				  blueprint[i][j] = new Rooms(t, i, j, RoomItem); 
				   
				  
			   }
		   }
			
		  if(t instanceof Beach)
		  {
			blueprintBeach = blueprint;  
		   return blueprintBeach;
		  }
	//	  if(t instanceof Forest){
		//  blueprintForest = blueprint;
		//    return blueprintForest;}
		  
		 // if(t instanceof Mountain){
		  //blueprintMountain = blueprint;
		   //  return blueprintMountain;}
		  
		  return null;
	}

	public Rooms[][] getBluePrint(Tiles t){
		
		 if(t instanceof Beach)
		  {
			blueprintBeach = blueprint;  
		   return blueprintBeach;
		  }
	//	  if(t instanceof Forest){
		//  blueprintForest = blueprint;
		//    return blueprintForest;}
		  
		 // if(t instanceof Mountain){
		  //blueprintMountain = blueprint;
		   //  return blueprintMountain;}
		return null;
	}

	
	public void MapUpdate(){
		
		//player l
	
		 
		
		
	 //if the player leaves then this will change it
	
		//use the room logic from the board class, make a swap room like swaptile
		
		//checks to see if room is cleared
	//	if(Creatures.isEmpty())
	//	  room.spawnItem();
		
		
		//need to check if the player moves out of the room
		//Until a player is on a screen within the engine, I'm not doing anything with it.
		//if we leave room call room.Clone(RoomWeMovedInto)
		
		
		
		
		
		
		
	}
}