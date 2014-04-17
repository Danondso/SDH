package Map;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


abstract class Tiles{
	
		private String[] textures;
	
		private String[] name;
		protected boolean issolid = false;
		
		
		
		//entire generated map dimensions
		static int row = 64;
		static int column = 64;
		
        protected int x;
        
        
        protected int y;
		
        protected int nextX;
        
        protected int nextY;
        
		//display tile dimensions
		public static int tilerow = 16;
		public int tilecolumn = 16;
		
		
		//These allow the tiles to reload based on adding values of 
		//  16, 32, and 48
	    protected Image[][] displaytile;
				
		//This will be used for the entity collision 
		
		
	    
	    
		//This creates the map for the levels
		//Will consist of the tiles
		protected Image[][] totalmap = new Image[row][column];
		
		//protected Image[][] level;

		
		protected Graphics[][] identity = new Graphics[row][column];
		protected Graphics[][] roomID = new Graphics[tilerow][tilecolumn];
		//The subclass array of asset strings will be passed into this
		protected Image[] terrain;
		//Randomize the terrain object
		protected Random rand = new Random(System.currentTimeMillis());
        //single 16 X 16 tile array
		public Image[][] tile1 = new Image[tilerow][tilecolumn], 
						 tile2 = new Image[tilerow][tilecolumn], 
						 tile3 = new Image[tilerow][tilecolumn], 
						 tile4 = new Image[tilerow][tilecolumn],
		                 tile5 = new Image[tilerow][tilecolumn], 
		                 tile6 = new Image[tilerow][tilecolumn], 
		                 tile7 = new Image[tilerow][tilecolumn], 
		                 tile8 = new Image[tilerow][tilecolumn],
		                 tile9 = new Image[tilerow][tilecolumn], 
		                 tile10 = new Image[tilerow][tilecolumn], 
		                 tile11 = new Image[tilerow][tilecolumn], 
		                 tile12 = new Image[tilerow][tilecolumn],
		                 tile13 = new Image[tilerow][tilecolumn], 
		                 tile14 = new Image[tilerow][tilecolumn], 
		                 tile15 = new Image[tilerow][tilecolumn], 
		                 tile16 = new Image[tilerow][tilecolumn];
		
		protected Image[][] tile;
		
		public Tiles(String[] texture) {
				
			
		
	       //passes the array to the Tiles 	
			textures = texture;	
			//instantiates the terrain array 
			this.terrain = new Image[textures.length];
			this.tile = new Image[tilerow][tilecolumn];
			//string for textures
			name = new String[textures.length];
			//string for 
				
			nextX = 0;
			nextY = 0;
			
			
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
		
			        if(r == 2 || r == 4)
			         identity[i][j].clearRect(0, 0, 32, 32);
			     
			     	totalmap[i][j] = terrain[r];
		            
				}
			}
		}
		
		
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
			    { totalmap[i][j] = terrain[4];
			      identity[i][j].clearRect(0, 0, 32, 32);
			    }
				if((j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48 || j == 63 || j == 64))
				{	totalmap[i][j] = terrain[4];
				identity[i][j].clearRect(0, 0, 32, 32);
				}
				
		     	if((i == 0 || i == 63))
		     	{
		     		totalmap[i][j] = terrain[4];
		     		identity[i][j].clearRect(0, 0, 32, 32);
		     	}
				if(j == 0 || j == 63)
				  totalmap[i][j] = terrain[4];
				identity[i][j].clearRect(0, 0, 32, 32);
			   } 
			}
		}
		
		
		public void clearDoors(){
			for(int i = 0; i < row; i++) 
			{
				for(int j = 0; j < column; j++)
				{
					
				//you pretty much subgrid the map so it makes all the entrances and exits nonsolid	
				  if(i == 7 || j == 7)//add the rest of the i's and j's for the rest of the map
					{
					 totalmap[i][j] = terrain[1]; 
					}
				  if(i == 23 || j == 23)
				  {
					totalmap[i][j] = terrain[1];
				  }
				  if(i == 39 || j == 39)
				  {
				    totalmap[i][j] = terrain[1];
				  }
				  if(i == 55 || j == 55)
				  {
				    totalmap[i][j] = terrain[1];
				  }
				}
			}
			
		}	
		
		public void sealBorders(){
			for(int i = 0; i < row; i++) 
			{
				for(int j = 0; j < column; j++)
				{
			
			  if(j == 63 && i <= 63)
				  {totalmap[i][j] = terrain[2];
//				   identity[i][j].clearRect(0, 0, 32, 32);
				  }
			  
			  if(i == 63 && j <= 63)
			  {
			   totalmap[i][j] = terrain[2];
//			   identity[i][j].clearRect(0, 0, 32, 32);
			  }
			  
			  if(j == 0 && i <= 63)
			  {
			   totalmap[i][j] = terrain[2];
//			   identity[i][j].clearRect(0, 0, 32, 32);
			  }
			  
			  if(j == 0 && i <= 63)
			  {
			   totalmap[i][j] = terrain[2];
//			   identity[i][j].clearRect(0, 0, 32, 32);
			  }
			  
				}
			}
			
			
		}
		
       //This method creates the doors 	
		public void addDoors(){
			
			for(int i = 0; i < totalmap.length; i++)	
			{
				for(int j = 0; j < totalmap.length; j++)
				{
			    if(i == 15 || i == 23 || i == 31 || i == 32 || i == 47 || i == 48 && j == 6 ||  j == 19 || j == 41 || j == 54) 		   
			            totalmap[i][j] = terrain[4];
				   if(j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48 && i == 7 || i == 23 || i == 41 || i == 54) 	
				        totalmap[i][j] = terrain[4];
			   }
			}  
			
		}

		
		
		//loads a tile to display on the map
		public Image[][] loadTile(int r, int c, Image[][] inTile){
				
			for(int i = 0; i < tilerow; i++){
		       for(int j = 0; j < tilecolumn; j++){
					
		    	   inTile[i][j] = totalmap[(i + r)][(j + c)]; 
				}      
			}	
			return inTile;
		}
		
		public Image[][] swapTile(int newX, int newY){
			
			//4/10/2014 this may need to get changed to accommodate room.
			if(newX == 0 && newY == 0)
			{
				nextX = 0;
				nextY = 0;
			}
			
			nextX = newX;
			nextY = newY;
			
			if(nextX == 0 && nextY == 0)
				  return getTile1().clone();
			if(nextX == 1 && nextY == 0)
				  return getTile2().clone();
			if(nextX == 2 && nextY == 0)
				  return getTile3().clone();
			if(nextX == 3 && nextY == 0)
				  return getTile4().clone();
			if(nextX == 0 && nextY == 1)
				  return getTile5().clone();
			if(nextX == 1 && nextY == 1)
				  return getTile6().clone();
			if(nextX == 2 && nextY == 1)
				  return getTile7().clone();
			if(nextX == 3 && nextY == 1)
				  return getTile8().clone();
			if(nextX == 0 && nextY == 2)
				  return getTile9().clone();
			if(nextX == 1 && nextY == 2)
				  return getTile10().clone();
			if(nextX == 2 && nextY == 2)
				  return getTile11().clone();
			if(nextX == 3 && nextY == 2)
				  return getTile12().clone();
			if(nextX == 0 && nextY == 3)
				  return getTile13().clone();
			if(nextX == 1 && nextY == 3)
				  return getTile14().clone();
			if(nextX == 2 && nextY == 3)
				  return getTile15().clone();
			if(nextX == 3 && nextY == 3)
				  return getTile16().clone();
			
			System.out.printf("do we ever get here?\n");
			return null;
		}
		
		
		
		//1st row
		public Image[][] getTile1(){tile1 = loadTile(0,0, tile1); return tile1; }
		public Image[][] getTile2(){tile2 = loadTile(16,0, tile2); return tile2;}
		public Image[][] getTile3(){tile3 = loadTile(32,0, tile3); return tile3;}
		public Image[][] getTile4(){tile4 = loadTile(48,0, tile4); return tile4;}
		//2nd row
		public Image[][] getTile5(){tile5 = loadTile(0,16, tile5); return tile5;}
		public Image[][] getTile6(){tile6 = loadTile(16,16, tile6); return tile6;}
		public Image[][] getTile7(){tile7 = loadTile(32,16, tile7); return tile7;}
		public Image[][] getTile8(){tile8 = loadTile(48,16, tile8); return tile8;}
		//3rd row
		public Image[][] getTile9(){tile9 = loadTile(0,32, tile9); return tile9;}
		public Image[][] getTile10(){tile10 = loadTile(16,32, tile10); return tile10;}
		public Image[][] getTile11(){tile11 = loadTile(32,32, tile11); return tile11;}
		public Image[][] getTile12(){tile12 = loadTile(32,48, tile12); return tile12;}
	    //4th row
		public Image[][] getTile13(){tile13 = loadTile(0,48, tile13);  return tile13;}
		public Image[][] getTile14(){tile14 = loadTile(16,48, tile14); return tile14;}
		public Image[][] getTile15(){tile15 = loadTile(32,48, tile15); return tile15;}
		public Image[][] getTile16(){tile16 = loadTile(48,48, tile16); return tile16;}
		
	
		
	}



