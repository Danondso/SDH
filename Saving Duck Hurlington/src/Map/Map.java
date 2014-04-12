package Map;
import java.util.Random;

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
	private Random rand = new Random();
	private int counter = 0;
	
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
		
        Item RoomItem = null;		
 		
		for(int i = 0; i < MapSize; i ++)	
		   {
			   for(int j = 0; j < MapSize; j ++)
			   {
				   //two rooms get an item
				   //bossroom gets an item
				   
				   //I need to write ifs to set up two more items 
				   
				   if(i == 3 && j == 3){
				     RoomItem = items.NextItem();}
				   if(SpawnItem(i, j))
				     RoomItem = items.NextItem();
				   
				   //every room besides the item rooms have a 1/3 chance of a heart spawn
				   int r = rand.nextInt(3);
				   if(r == 1 && RoomItem == null)
				     RoomItem = items.GetHealthPotion();
				     
				  blueprint[i][j] = new Rooms(t, i, j, RoomItem); 
				   
				  RoomItem = null;
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
		  
		  //allows for multiple method calls so the other biomes
		  //can have items.
		  counter = 0;
		  
		  return null;
	}
	
	private boolean SpawnItem(int i, int j){
		
		int r = rand.nextInt(i + 10) % 2;
		int s = rand.nextInt(j + 10) % 2;		
		
	
		//gives a room an item based upon these conditions. 
		//increments the counter so it will only allow two
		if(counter < 2 && r == 0 && s == 0){
			counter ++;
			return true;
          }
		//if both items spawn it stops it from giving it another one. 
		if(counter == 2)
		  return false;	
		
		return false;
		
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
	/*
	 if(left == true){
		int nextX = 0;
		int nextY = 0;
		//use the room logic from the board class, make a swap room like swaptile
		Room[][] blueprint = getBluePrint();
		*/
		
		//the entire setup for the ifs will be cleaned once a method for making the items visible is created
		
		//checks to see if room is cleared
		if(room.cleared)
		{
		  //checks to see if an item has spawned yet
		  if(room.itemSpawn)
		  {
			  //checks to see if an item exists for this room
			  if(room.Item != null)
			  {
				  //make the item appear
			  }
				
		    }
		}
			  
		//need to check if the player moves out of the room
		
		//Logic for room move can be here but MapUpdate should take in the 
		//current X and Y, MapUpdate needs parameters and an if statement around it
		//so the room doesn't try to reload when it's not needed.
		
		//if we leave room call room.Clone(RoomWeMovedInto)
		
		
		
		
		
		
		
	}
}