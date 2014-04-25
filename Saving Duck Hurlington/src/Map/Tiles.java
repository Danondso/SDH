package Map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
        
        protected int rectX;
        
        protected int rectY;
        
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

		
		protected Rectangle[][] identity = new Rectangle[row][column];
		protected Rectangle[][] roomID = new Rectangle[tilerow][tilecolumn];
		//The subclass array of asset strings will be passed into this
		protected Image[] terrain;
		//Randomize the terrain object
		protected Random rand = new Random(System.currentTimeMillis());
        //single 16 X 16 tile array
		public Image[][] tile1, tile2, tile3, tile4,
		                 tile5, tile6, tile7, tile8,
		                 tile9, tile10, tile11, tile12,
		                 tile13, tile14, tile15, tile16;
		
		public Rectangle[][] rectTile1, rectTile2, rectTile3, rectTile4,
		rectTile5, rectTile6, rectTile7, rectTile8,
		rectTile9, rectTile10, rectTile11, rectTile12,
		rectTile13, rectTile14,rectTile15, rectTile16;
		
		
		
		
		protected Image[][] tile;
		
		protected Graphics g;
		
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


		public void fillIdentity(){
			
			for(int i = 0; i < row; i ++)
			{
				for(int j = 0; j < column; j ++)
				{
			      identity[i][j] = new Rectangle(0, 0, 32, 32);
				}
			}
		  
		}

	
		//Randomizes the terrain of the entire 64 X 64 map
		public void createMap(){
			
			for(int i = 0; i < row; i ++)
			{
				for(int j = 0; j < column; j ++)
				{
			    
			     int r = rand.nextInt(terrain.length);
		
			        if(r != 2 || r != 4)
			          identity[i][j] = null;
			     
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
				  if(i == 7 || j == 7)//add the rest of the i's and j's for the rest of the map
					{
					 totalmap[i][j] = terrain[1]; 
					 identity[i][j] = null;
					}
				  if(i == 23 || j == 23)
				  {
					totalmap[i][j] = terrain[1];
					identity[i][j] = null;
				  }
				  if(i == 39 || j == 39)
				  {
				    totalmap[i][j] = terrain[1];
				    identity[i][j] = null;
				  }
				  if(i == 55 || j == 55)
				  {
				    totalmap[i][j] = terrain[1];
				    identity[i][j] = null;
				  }
				  
				
				  
				  if(i == 0 || j == 0){
						totalmap[i][j] = terrain[2];  
				        identity[i][j] = new Rectangle(0, 0, 32, 32);
				  }
				  if(i == 63 || j == 63)
					  {
						 totalmap[i][j] = terrain[2];
				        identity[i][j] = new Rectangle(0, 0, 32, 32);
					  }
				}
			
			
			}
			
		}	
		
		public void sealBorders(){
			for(int i = 0; i < row; i++) 
			{
				for(int j = 0; j < column; j++)
				{
			
			     if(i <= 63){
			    	 if(j == 0 || j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48 || j == 63){
				    totalmap[i][j] = terrain[2];
			        identity[i][j] = new Rectangle(0,0,32,32);
			    	 }
			    }

			     if(j <= 63){
			    	 if(i == 0 || i == 15 || i == 16 || i == 31 || i == 32 || i == 47 || i == 48 || i == 63){
					    totalmap[i][j] = terrain[2];
				        identity[i][j] = new Rectangle(0,0,32,32);}

			     }
			     if(i == 0 || i == 63){
					    totalmap[i][j] = terrain[2];
			        identity[i][j] = new Rectangle(0,0,32,32);
			     }

			    
			     if(j == 0 || j == 63){
					    totalmap[i][j] = terrain[2];
			        identity[i][j] = new Rectangle(0,0,32,32);
			     }

				}
			}
			
			
		}
		

		//loads a tile to display on the map
		public Image[][] loadTile(int r, int c, Image[][] inTile){
				
			   if(inTile == null)
				  inTile = new Image[tilerow][tilecolumn]; 
			if(r == 48 && c == 48)
			   BossRoom(inTile);
			else{
			
			for(int i = 0; i < tilerow; i++){
		       for(int j = 0; j < tilecolumn; j++){
				
		    	
		    	   inTile[i][j] = totalmap[(i + r)][(j + c)]; 
				}      
			}	
			
			}
			return inTile;
		}
		
		public void BossRoom(Image[][] inTile)
		{
			for(int i = 0; i < tilerow; i++){
				for(int j = 0; j < tilecolumn; j++)
				{
				
					inTile[i][j] = totalmap[i + 48][j + 48];
					
				 if(i > 0 && i < 15)
				 {
						if(j > 0 && j < 15)
						  inTile[i][j] = terrain[1];
				 }			
				
				
				}
			}
		}
		
		
		public void RectRoom(Rectangle[][] inRect)
		{
			for(int i = 0; i < tilerow; i++){
				for(int j = 0; j < tilecolumn; j++)
				{
				
					inRect[i][j] = identity[i + 48][j + 48];
					
				 if(i > 0 && i < 15)
					 if(j > 0 && j < 15)
						 inRect[i][j] = null;
				 			
				
				
				}
			}
		}
		
		
		//loads the rectangles used for collision
		public Rectangle[][] loadRect(int r, int c, Rectangle[][] CollideTile){
			
			   if(CollideTile == null)
				   CollideTile = new Rectangle[tilerow][tilecolumn]; 
			
			if(r == 48 && c == 48)
				RectRoom(CollideTile);
			else{  
			for(int i = 0; i < tilerow; i++){
		       for(int j = 0; j < tilecolumn; j++){
					
		    	   CollideTile[i][j] = identity[(i + r)][(j + c)]; 
				}      
			}	
			}
			return CollideTile;
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
		public Image[][] getTile2()
		
		{tile2 = loadTile(16,0, tile2); return tile2;}
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
		public Image[][] getTile12(){tile12 = loadTile(48,32, tile12); return tile12;}
	    //4th row
		public Image[][] getTile13(){tile13 = loadTile(0,48, tile13);  return tile13;}
		public Image[][] getTile14(){tile14 = loadTile(16,48, tile14); return tile14;}
		public Image[][] getTile15(){tile15 = loadTile(32,48, tile15); return tile15;}
		public Image[][] getTile16(){tile16 = loadTile(48,48, tile16); return tile16;}
		
	
		
	public Rectangle[][] swapRect(int newX, int newY){
			
			//4/10/2014 this may need to get changed to accommodate room.
			if(newX == 0 && newY == 0)
			{
				nextX = 0;
				nextY = 0;
			}
			
			nextX = newX;
			nextY = newY;
			
			if(nextX == 0 && nextY == 0)
				  return getRect1().clone();
			if(nextX == 1 && nextY == 0)
				  return getRect2().clone();
			if(nextX == 2 && nextY == 0)
				  return getRect3().clone();
			if(nextX == 3 && nextY == 0)
				  return getRect4().clone();
			if(nextX == 0 && nextY == 1)
				  return getRect5().clone();
			if(nextX == 1 && nextY == 1)
				  return getRect6().clone();
			if(nextX == 2 && nextY == 1)
				  return getRect7().clone();
			if(nextX == 3 && nextY == 1)
				  return getRect8().clone();
			if(nextX == 0 && nextY == 2)
				  return getRect9().clone();
			if(nextX == 1 && nextY == 2)
				  return getRect10().clone();
			if(nextX == 2 && nextY == 2)
				  return getRect11().clone();
			if(nextX == 3 && nextY == 2)
				  return getRect12().clone();
			if(nextX == 0 && nextY == 3)
				  return getRect13().clone();
			if(nextX == 1 && nextY == 3)
				  return getRect14().clone();
			if(nextX == 2 && nextY == 3)
				  return getRect15().clone();
			if(nextX == 3 && nextY == 3)
				  return getRect16().clone();
			
			System.out.printf("do we ever get here?\n");
			return null;
		}
		
	
	//1st row
			public Rectangle[][] getRect1(){rectTile1 = loadRect(0,0, rectTile1); return rectTile1; }
			public Rectangle[][] getRect2(){rectTile2 = loadRect(16,0, rectTile2); return rectTile2;}
			public Rectangle[][] getRect3(){rectTile3 = loadRect(32,0, rectTile3); return rectTile3;}
			public Rectangle[][] getRect4(){rectTile4 = loadRect(48,0, rectTile4); return rectTile4;}
			//2nd row
			public Rectangle[][] getRect5(){rectTile5 = loadRect(0,16, rectTile5); return rectTile5;}
			public Rectangle[][] getRect6(){rectTile6 = loadRect(16,16, rectTile6); return rectTile6;}
			public Rectangle[][] getRect7(){rectTile7 = loadRect(32,16, rectTile7); return rectTile7;}
			public Rectangle[][] getRect8(){rectTile8 = loadRect(48,16, rectTile8); return rectTile8;}
			//3rd row
			public Rectangle[][] getRect9(){rectTile9 = loadRect(0,32, rectTile9); return rectTile9;}
			public Rectangle[][] getRect10(){rectTile10 = loadRect(16,32, rectTile10); return rectTile10;}
			public Rectangle[][] getRect11(){rectTile11 = loadRect(32,32, rectTile11); return rectTile11;}
			public Rectangle[][] getRect12(){rectTile12 = loadRect(48,32, rectTile12); return rectTile12;}
		    //4th row
			public Rectangle[][] getRect13(){rectTile13 = loadRect(0,48, rectTile13);  return rectTile13;}
			public Rectangle[][] getRect14(){rectTile14 = loadRect(16,48, rectTile14); return rectTile14;}
			public Rectangle[][] getRect15(){rectTile15 = loadRect(32,48, rectTile15); return rectTile15;}
			public Rectangle[][] getRect16(){rectTile16 = loadRect(48,48, rectTile16); return rectTile16;}
		
		
		
	}



