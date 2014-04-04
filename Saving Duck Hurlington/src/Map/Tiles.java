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
	    protected Image[][] displaytile;
				
		//This will be used for the entity collision 
		private boolean issolid = false;
		
		//This creates the map for the levels
		//Will consist of the tiles
		protected Image[][] totalmap = new Image[row][column];
		
		//protected Image[][] level;

		//The subclass array of asset strings will be passed into this
		protected Image[] terrain;
		//Randomize the terrain object
		protected Random rand = new Random();
        //single 16 X 16 tile array
		public Image[][] tile1, tile2, tile3, tile4,
		                    tile5, tile6, tile7, tile8,
		                    tile9, tile10, tile11, tile12,
		                    tile13, tile14, tile15, tile16 
		                    = new Image[tilerow][tilecolumn];
			
		
		protected Image[][] tile;
		
		//protected String[][] arrays = { array1, array2, array3, array4, array5 };
		protected Image[][][] choose;
		
	
		
		
		public Tiles(String[] texture) {
				
			
		
	       //passes the array to the Tiles 	
			textures = texture;	
			//instantiates the terrain array 
			this.terrain = new Image[textures.length];
			this.tile = new Image[tilerow][tilecolumn];
		
			
			
			
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

		
		
		//loads a tile to display on the map
		public Image[][] loadTile(int r, int c){
				
			for(int i = 0; i < tilerow; i++){
		       for(int j = 0; j < tilecolumn;j++){
					
		    	   tile[i][j] = totalmap[(i + r)][(j + c)];		    	 
				}
		      
			}	
			return tile;
		}
		
		
		//1st row
		public Image[][] getTile1(){tile1 = loadTile(0,0); return tile1; }
		public Image[][] getTile2(){tile2 = loadTile(16,0); return tile2;}
		public Image[][] getTile3(){tile3 = loadTile(32,0); return tile3;}
		public Image[][] getTile4(){tile4 = loadTile(48,0); return tile4;}
		//2nd row
		public Image[][] getTile5(){tile5 = loadTile(0,16); return tile5;}
		public void getTile6(){tile6 = loadTile(16,16);}
		public void getTile7(){tile7 = loadTile(32,16);}
		public void getTile8(){tile8 = loadTile(48,16);}
		//3rd row
		public void getTile9(){tile9 = loadTile(0,32);}
		public void getTile10(){tile10 = loadTile(16,32);}
		public void getTile11(){tile11 = loadTile(32,32);}
		public void getTile12(){tile12 = loadTile(32,48);}
	    //4th row
		public void getTile13(){tile13 = loadTile(0,48);}
		public void getTile14(){tile14 = loadTile(16,48);}
		public void getTile15(){tile15 = loadTile(32,48);}
		public void getTile16(){tile16 = loadTile(48,48);}
		
	
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



