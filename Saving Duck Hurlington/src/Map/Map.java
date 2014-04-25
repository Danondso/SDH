package Map;
import java.util.ArrayList;
import java.util.Random;

import Entities_and_Player.Creature;
import Entities_and_Player.Item;
import Entities_and_Player.ItemPool;
import Entities_and_Player.Player;

public class Map {

	private int MapSize = 4;
	private Rooms[][] blueprint = new Rooms[MapSize][MapSize];
	private Rooms[][] blueprintBeach = new Rooms[MapSize][MapSize];
	private Rooms[][] blueprintForest = new Rooms[MapSize][MapSize];
	private Rooms[][] blueprintMountain = new Rooms[MapSize][MapSize];
	private Player player;
	private Rooms room;
	int X = 0;
	int Y = 0;
	
	private Beach b = new Beach();
	private Forest f = new Forest();
	private Mountain m = new Mountain();
	private Random rand = new Random(System.currentTimeMillis());
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
		room.Clone(blueprintBeach[X][Y]);
		
	}
	//method to switch the working blueprint
	public void loadMap(Tiles t){
		
		if(t instanceof Beach)
		{
			t.fillIdentity();
			t.createMap();
			t.sealBorders();
			t.clearDoors();
			((Beach) t).addWater();
		
		}
		else{
			t.createMap();
			t.clearDoors();
		
		}
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
				   //every room besides the item rooms have a 1/3 chance of a heart spawn
				   int r = rand.nextInt(3);
				   if(r == 1 && RoomItem == null)
				     RoomItem = items.GetHealthPotion();
				   
				   if(i == 3 && j == 3)
				     RoomItem = items.NextItem();
				   
				   else if(SpawnItem(i, j))
				     RoomItem = items.NextItem();
				   
				   if(RoomItem != null)
				   		blueprint[i][j] = new Rooms(t, player, i, j, RoomItem.Clone());
				   else
				   		blueprint[i][j] = new Rooms(t, player, i, j, null);
				   RoomItem = null;
				   if(blueprint[i][j] == null)
					   System.out.printf("What is this even\n");
				   
				  
					   
				   
				   
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

	public void CollisionPlayer(){
		
      
		
		for(int i = 0; i < room.roomSize; i ++)	
		   {
			   for(int j = 0; j < room.roomSize; j ++)
			   {
				  
			     if(room.GetCollision()[i][j] != null && room.GetCollision()[i][j].intersects(player.GetX(), player.GetY(), player.getImage().getWidth(null), player.getImage().getHeight(null)))	   
			     {
			    	// System.out.println("yes" + "Rectangle" + i + ", " + j);
			     
			    	//four if statements
			       int RockX = room.GetCollision()[i][j].x;
			       int RockY = room.GetCollision()[i][j].y;
			       int RockW = room.GetCollision()[i][j].width;
			       int RockH = room.GetCollision()[i][j].height;
			       int PlayerW = player.getImage().getWidth(null);
			       int PlayerH = player.getImage().getHeight(null);
			       int xPoint = player.GetX() + (PlayerW * (player.GetMovingX() + 1) / 2);
			       int yPoint = player.GetY() + (PlayerH * (player.GetMovingY() + 1) / 2);
			       char side = 'Q';
			       int shallow = Integer.MIN_VALUE;
			    	
			       if(RockX - (player.GetX() + PlayerW) < 0 && RockX - (player.GetX() + PlayerW) >= shallow)
			       {
			    	   side = 'L';
			    	   	shallow = RockX - (player.GetX() + PlayerW);
			       }
			      
			       if(player.GetY() - (RockY + RockH) < 0 && player.GetY() - (RockY + RockH) >= shallow)
			       {
			    	   side = 'D';
			    	   	shallow = player.GetY() - (RockY + RockH);
			       }
			       
			       if(player.GetX() - (RockX + RockW) < 0 && player.GetX() - (RockX + RockW) >= shallow)
			       {
			    	   side = 'R';
			    	   	shallow = player.GetX() - (RockX + RockW);
			       }

			       if(RockY - (player.GetY() + PlayerW) < 0 && RockY - (player.GetY() + PlayerW) >= shallow)
			       {
			    	   side = 'U';
			    	   	shallow = RockY - (player.GetY() + PlayerW);
			       }
			       
			       
			       switch(side){
			       
			       case 'U':
			    	  // System.out.println(side);
						 player.SetY(room.GetCollision()[i][j].y - player.getImage().getHeight(null));

			       break;
			    	   
			       case 'D':
			 		  player.SetY(room.GetCollision()[i][j].y + room.GetCollision()[i][j].height);
			    	   //System.out.println(side);


			       break;
			       
			       case 'L':
					
						 player.SetX(room.GetCollision()[i][j].x - player.getImage().getWidth(null));
				    	//   System.out.println(side);


			       break;
			       
			       case 'R':
			    		
			  		 player.SetX(room.GetCollision()[i][j].x + room.GetCollision()[i][j].width);
			    	  // System.out.println(side);

			   	   break;
			    	   
			    	   default:
			    		   
			   	   break;
			       
			       }
 
			       side = 'Q';
			       shallow = Integer.MIN_VALUE;
			     }
			    
			   }
		   
		   }
	}
	
	public void CollisionEnemy(Creature c){
	
		

		
		for(int i = 0; i < room.roomSize; i ++)	
		   {
			   for(int j = 0; j < room.roomSize; j ++)
			   {
				  
			     if(room.GetCollision()[i][j] != null && room.GetCollision()[i][j].intersects(c.GetX(), c.GetY(), c.getImage().getWidth(null), c.getImage().getHeight(null)))	   
			     {
			    	// System.out.println("yes" + "Rectangle" + i + ", " + j);
			     
			    	//four if statements
			       int RockX = room.GetCollision()[i][j].x;
			       int RockY = room.GetCollision()[i][j].y;
			       int RockW = room.GetCollision()[i][j].width;
			       int RockH = room.GetCollision()[i][j].height;
			       int CreatureW = c.getImage().getWidth(null);
			       int CreatureH = c.getImage().getHeight(null);
			       int xPoint = c.GetX() + (CreatureW * (c.GetMovingX() + 1) / 2);
			       int yPoint = c.GetY() + (CreatureH * (c.GetMovingY() + 1) / 2);
			       char side = 'Q';
			       int shallow = Integer.MIN_VALUE;
			    	
			       if(RockX - (c.GetX() + CreatureW) < 0 && RockX - (c.GetX() + CreatureW) >= shallow)
			       {
			    	   side = 'L';
			    	   	shallow = RockX - (c.GetX() + CreatureW);
			       }
			      
			       if(c.GetY() - (RockY + RockH) < 0 && c.GetY() - (RockY + RockH) >= shallow)
			       {
			    	   side = 'D';
			    	   	shallow = c.GetY() - (RockY + RockH);
			       }
			       
			       if(c.GetX() - (RockX + RockW) < 0 && c.GetX() - (RockX + RockW) >= shallow)
			       {
			    	   side = 'R';
			    	   	shallow = c.GetX() - (RockX + RockW);
			       }

			       if(RockY - (c.GetY() + CreatureW) < 0 && RockY - (c.GetY() + CreatureW) >= shallow)
			       {
			    	   side = 'U';
			    	   	shallow = RockY - (c.GetY() + CreatureW);
			       }
			       
			       
			       switch(side){
			       
			       case 'U':
			    	  // System.out.println(side);
						 c.SetY(room.GetCollision()[i][j].y - c.getImage().getHeight(null));

			       break;
			    	   
			       case 'D':
			 		  c.SetY(room.GetCollision()[i][j].y + room.GetCollision()[i][j].height);
			    	   //System.out.println(side);


			       break;
			       
			       case 'L':
					
						 c.SetX(room.GetCollision()[i][j].x - c.getImage().getWidth(null));
				    	//   System.out.println(side);


			       break;
			       
			       case 'R':
			    		
			  		 c.SetX(room.GetCollision()[i][j].x + room.GetCollision()[i][j].width);
			    	  // System.out.println(side);

			   	   break;
			    	   
			    	   default:
			    		   
			   	   break;
			       
			       }
 
			       side = 'Q';
			       shallow = Integer.MIN_VALUE;
			     }
			    
			   }
		   
		   }
		
	}
	
	public void MapUpdate(){
		

		
      CollisionPlayer();
      for(Creature cr : room.getCreArray())
       CollisionEnemy(cr);
      
      
      
		//checks to see if a creature moved out of the room
		if(!room.getCreArray().isEmpty())
		{
	    	for(Creature cr : room.getCreArray()){
			if(cr.GetX() < 0)
				cr.SetX(0);
			
			if(cr.GetX() + cr.getImage().getHeight(null) > 32 * 16)
				cr.SetX(32 * 16 - cr.getImage().getHeight(null));
			
			if(cr.GetY() < 0)
				cr.SetY(0);
			
			if(cr.GetY() + cr.getImage().getWidth(null) > 32 * 16)
				cr.SetY(32 * 16 - cr.getImage().getWidth(null));
	    	}	
		
		}
		else{ room.cleared = true; blueprint[X][Y].cleared = true;  }
		//checks to see if the player moved out of the room
		if(player.GetX() + player.getImage().getWidth(null) < 0){
			X--;
			if(X < 0)
				X = 0;
			room.Clone(blueprint[X][Y]);
			player.SetX(32 * 16 - player.getImage().getWidth(null));
		}
		else if(player.GetX() > 32 * 16)
		{
			X++;
			if(X > 3)
				X = 3;
			room.Clone(blueprint[X][Y]);
			player.SetX(0);
		}
		else if(player.GetY() + player.getImage().getHeight(null) < 0){
			Y--;
			if(Y < 0)
				Y = 0;
			room.Clone(blueprint[X][Y]);
			player.SetY(32 * 16 - player.getImage().getHeight(null));
		}
		else if(player.GetY() + player.getImage().getHeight(null) > 32 * 16){
			
			Y++;
			if(Y > 3)
				Y = 3;
		    room.Clone(blueprint[X][Y]);
		    player.SetY(0);
		}
		//System.out.printf("Current room is X: %d Y: %d\n", X, Y);
		
		
		
		//Logic for room move can be here but MapUpdate should take in the 
		//current X and Y, MapUpdate needs parameters and an if statement around it
		//so the room doesn't try to reload when it's not needed.
		
		//if we leave room call room.Clone(RoomWeMovedInto)
		
		
		
		
		
		
		
	
	
	
	

	
	 
	  
	 
		 }
	}
