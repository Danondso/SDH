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
				   
				   if(i == 3 && j == 3){
				     RoomItem = items.NextItem();
				      
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
	/*
	 if(left == true){
		int nextX = 0;
		int nextY = 0;
		//use the room logic from the board class, make a swap room like swaptile
		Room[][] blueprint = getBluePrint();
		
		
		if(newX == 0 && newY == 0)
		{
			nextX = 0;
			nextY = 0;
		}
		
		nextX += newX;
		nextY += newY;
		
		if(nextX == 0 && nextY == 0)
			  room.clone(blueprint[0][0]);
		if(nextX == 1 && nextY == 0)
			  return getTile2();
		if(nextX == 2 && nextY == 0)
			  return getTile3();
		if(nextX == 3 && nextY == 0)
			  return getTile4();
		if(nextX == 0 && nextY == 1)
			  return getTile5();
		if(nextX == 1 && nextY == 1)
			  return getTile6();
		if(nextX == 2 && nextY == 1)
			  return getTile7();
		if(nextX == 3 && nextY == 1)
			  return getTile8();
		if(nextX == 0 && nextY == 2)
			  return getTile9();
		if(nextX == 1 && nextY == 2)
			  return getTile10();
		if(nextX == 2 && nextY == 2)
			  return getTile11();
		if(nextX == 3 && nextY == 2)
			  return getTile12();
		if(nextX == 0 && nextY == 3)
			  return getTile13();
		if(nextX == 1 && nextY == 3)
			  return getTile14();
		if(nextX == 2 && nextY == 3)
			  return getTile15();
		if(nextX == 3 && nextY == 3)
			  return getTile16();
		
		
		return null;
		*/
		
		//checks to see if room is cleared
		
		//need to check if the player moves out of the room
		
		//if we leave room call room.Clone(RoomWeMovedInto)
		
		
		
		
		
		
		
	}
}