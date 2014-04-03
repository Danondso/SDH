package Map;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.*;

import Player.Board;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;


abstract class Tiles extends Canvas {
	
		private String[] textures;
		private int[] id;
		private String[] name;
		
		//entire generated map dimensions
		static int row = 64;
		static int column = 64;
		
		//display tile dimensions
		public static int tilerow = 16;
		public int tilecolumn = 16;
		
		
		//These allow the tiles to reload based on adding values of 
		//  16, 32, and 48
		private int rowcoord = 0;
		private int colcoord = 0;
				
		//This will be used for the entity collision 
		private boolean issolid = false;
		
		//This creates the map for the levels
		//Will consist of the tiles
		protected Image[][] totalmap = new Image[row][column];
		//The subclass array of asset strings will be passed into this
		protected Image[] terrain;
		//Randomize the terrain object
		protected Random rand = new Random();
        //single 16 X 16 tile array
		private Image[][] tile = new Image[tilerow][tilecolumn];
	
		protected Image[][] displaytile;
		
		public Tiles(String[] texture) {
				
			
		
	       //passes the array to the Tiles 	
			textures = texture;	
			//instantiates the terrain array 
			this.terrain = new Image[textures.length];
			
			//instantiates the temptile that is displayed on the map
			this.displaytile = new Image[tilerow][tilecolumn];
			//testing to make sure Strings pass
		//	for(int i = 0; i < textures.length; i++)
			//   System.out.println(textures[i]);
				
			
			//string for textures
			name = new String[textures.length];
			//string for 
			id = new int[textures.length];
			
			try{
				
				for(int i = 0; i < textures.length; i++){
				   terrain[i] = ImageIO.read(Tiles.class.getResourceAsStream(textures[i])); 				   
			}
			}
			
			catch(IOException e){System.out.println("Error: " + e);}
			
		  //  setPreferredSize(new Dimension(800,800));
			
			
		}


		//Randomizes the terrain of the entire 64 X 64 map
		public void createMap(){
			
			for(int i = 0; i < row; i ++)
			{
				for(int j = 0; j < column; j ++)
				{
			    
			     int r = rand.nextInt(terrain.length);
			     
			     	totalmap[i][j] = terrain[r];
			     	
				}
			}
		}
		
		public void clearDoors(){
			for(int i = 0; i < row; i++) 
			{
				for(int j = 0; j < column; j++)
				{
				//you pretty much subgrid the map so it makes all the entrances and exits nonsolid	
				  if(i == 7 || j == 6)//add the rest of the i's and j's for the rest of the map
					totalmap[i][j] = terrain[1];  
				}
			}
			
		}
		
		
		public void clearTile(){
			
			for(int i = 0; i < tilerow; i++) 
			{
				for(int j = 0; j < tilecolumn; j++){
					
					tile[i][j] = null;
				}
			}
		}
		
       //This method creates the doors 	
		public void addDoors(){
			
			for(int i = 0; i < totalmap.length; i++)	
			{
				for(int j = 0; j < totalmap.length; j++)
				{
			    if((i == 15 || i == 16 || i == 31 || i == 32 || i == 47 || i == 48))
			         if((j == 6 ||  j == 24 || j == 41 || j == 56)) 		   
			            totalmap[i][j] = terrain[4];
				   if((j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48))
				         if((i == 7 || i == 24 || i == 41 || i == 56)) 	
				        totalmap[i][j] = terrain[4];
			   }
			}  
			
		}
		//Returns the entire array, I suppose it's not needed
		
        //Perhaps make one that would return the entire map array, or have it divide then return

		
		//Draws the map in the total 64 X 64 array	
		
		public void paint(Graphics g){
				
			super.paint(g);
			
			Graphics2D gm = (Graphics2D)g;
			
			int wrect = getWidth() / tilerow;
			int hrect = getHeight() / tilecolumn;
			for(int i = 0;i < tilerow; i++)
			{
				for(int j = 0; j < tilecolumn; j++)
				{
				 int x = i * wrect;
				 int y = j * hrect;
				 Image temp[][] = loadTile();
				 
				 g.drawImage(temp[i][j], x, y, wrect, hrect, this);
		
				}
			}
		}
		
		
		public int getCurrentX(){
			
			//need to get filled in with the 
			//player position or something that returns the X
			return 0;
			
		}
		
		
		public int getCurrentY(){
		
			//need to get filled in with the 
			//player position or something that returns the Y
			return 0;
		}
		
		//loads a tile to display on the map
		public Image[][] loadTile(){
			
			int x = getCurrentX();
			int y = getCurrentY();
			
			for(int i = 0; i < tilerow; i++){
		       for(int j = 0; j < tilecolumn;j++){
					
		    	   tile[i][j] = totalmap[(i + rowcoord)][(j + colcoord)];
				}
			}
			displaytile = tile;
			return displaytile;
		}
		
		

		
		public String getImageName(){
			
			String imagename = null;
			
			return imagename;
			
		}

		public boolean navagable()
		{
			//player.getposition();
			//if statement to check to see what the tile is
			
			
			return false;	
		}
		
		//need a function for collision detection 
		

	public void genBorders() {
		// TODO Auto-generated method stub
		//SKELETAL STRUCTURE FOR THE BORDERS OF THE TILES AND THE DOORS
	     //sets the borders for the tiles
		//With how this works, the stone borders have 
		//to be in the correct array space.	
		//for the beach, have everything has to have (i > 3)
		for(int i = 0; i < totalmap.length; i++)
		{
		   for(int j = 0; j < totalmap.length; j++)
		   {
		    if((i == 15 || i == 16 || i == 31 || i == 32 || i == 47 || i == 48 || i == 63 || i == 64))
		       totalmap[i][j] = terrain[3];
			
			if((j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48 || j == 63 || j == 64))
				totalmap[i][j] = terrain[3];
		
			if((i == 0 || i == 63))
			  totalmap[i][j] = terrain[3];
			
			if(j == 0 || j == 63)
			  totalmap[i][j] = terrain[3];
		   } 
		}
	}
			
	}



