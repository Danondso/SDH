package Engine;

<<<<<<< HEAD:Saving Duck Hurlington/src/Main.java
=======
	import java.io.File;
>>>>>>> e006757825e66b261535d9c72fa5b9d4d221067d:Saving Duck Hurlington/src/Engine/Main.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JohnnyComeLately.Creature;
import JohnnyComeLately.Item;
import JohnnyComeLately.Player;
import JohnnyComeLately.Projectile;
import Map.*;
	public class Main
<<<<<<< HEAD:Saving Duck Hurlington/src/Main.java
	{	
		public static void main(String[] args)
	    {
	    	new RType();
	    	/*
	    	//String gameState = play; //this will need to be changed to startMenu when that is implemented
=======
	{
		
		
		 // private int MapSize = 4;  
		//  private Rooms[][] blueprint = new Rooms[MapSize][MapSize];
		  
		  private Beach b = new Beach();
		  private Forest f = new Forest();
		  private Mountain m = new Mountain();
		  
		
		
	    public static void main(String[] args)
	    {
	    	String gameState = "play"; //this will need to be changed to startMenu when that is implemented
>>>>>>> e006757825e66b261535d9c72fa5b9d4d221067d:Saving Duck Hurlington/src/Engine/Main.java
	    	List<Projectile> projectiles = new ArrayList<Projectile>();
	    	List<Creature> creatures = new ArrayList<Creature>();//need array of these so I can just pass each one to mason as needed
	    	List<Item> items = new ArrayList<Item>();
	    	List<Item> spawnableItems = new ArrayList<Item>();
	    	//List<Tiles> tiles = new ArrayList<Tiles>();
	    	//Player player = new Player();

<<<<<<< HEAD:Saving Duck Hurlington/src/Main.java
	    	Scanner in = new Scanner(new file(filepath));
=======
	    	Scanner in = new Scanner(new File("/Unlocked Items/Unlocked.txt"));
>>>>>>> e006757825e66b261535d9c72fa5b9d4d221067d:Saving Duck Hurlington/src/Engine/Main.java
	    		//read things in from unlock file
	    	in.close();
	    	
	    	while(gameState != "end"){
	    	
	    	while(gameState == "play"){
	    		//need to add things to the arraylists
	    		//need a way to stop where we are if the pause menu is accessed
	    		
	    		//collision loops
	    		for(int i = 0; i < creatures.size(); i++){
	    			creatures[i].Collide();
	    		}
	    		for(int i = 0; i < projectiles.size(); i++){
	    			projectiles[i].Collide();
	    		}
	    		for(int i = 0; i < items.size(); i++){
	    			items[i].Collide();
	    		}
	    		
	    		//movement loops
	    		for(int i = 0; i < creatures.size(); i++){
	    			creatures[i].Move();
	    		}
	    		for(int i = 0; i < projectiles.size(); i++){
	    			projectiles[i].Move();
	    		}
	    		
	    		//attack loops
	    		for(int i = 0; i < creatures.size(); i++){
	    			creatures[i].Attack();
	    		}
	    		
	    		//call display ask Mason how to do this
	    		
	    		
	    		//not sure how the removing things from the array list is working ask Matt
	    		
	    		if(player == dead || player == victory){
	    			gameState = startMenu;
	    			check unlocks
	    			save unlocks
	    		  }
	    	}
	    		//while(gameState == "pause"){
	    			//display pause menu
	    			if(button pressed to resume){
	    			 	gameState = play;
	    			 	jump to start of code
	    			 }
	    			 else if(button pressed to quit){
	    			 	gameState = startMenu;
	    			 }
	    			 
	    			 }
	    	}*/
	    		   	
	    }
	}
