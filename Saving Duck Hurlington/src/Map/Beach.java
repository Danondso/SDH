package Map;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

 public class Beach extends Tiles {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String[] texture = {"/Beach/sand_grass.png", "/Beach/sand.png", "/Beach/stone.png", "/Beach/wavy_sand.png", "/Beach/water.png"};
    
	//Look for the size in the Sprite Constructor of Assignment V
	public Beach(){
	
      super(texture);
      
		}
	
	@Override
	public void createMap(){
		
		for(int i = 0; i < row; i ++)
		{
			for(int j = 0; j < column; j ++)
			{
		    
		     int r = rand.nextInt(terrain.length - 1);
		     
		     	totalmap[i][j] = terrain[r];
		     	
			}
		}
	}
	
	
	@Override	
	public void genBorders(){
	    
		//SKELETAL STRUCTURE FOR THE BORDERS OF THE TILES AND THE DOORS
	     //sets the borders for the tiles
		for(int i = 0; i < totalmap.length; i++)
		{
		   for(int j = 0; j < totalmap.length; j++)
		   {
		    if((i > 3) && (i == 15 || i == 16 ||i == 31 || i == 32 || i == 47 || i == 48 || i == 63)){
		    	totalmap[i][j] = terrain[2];
		    	identity[i][j] = new Rectangle(0,0,32, 32);
		       }
			
			if((i > 3) && (j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48 || j == 63)){
				totalmap[i][j] = terrain[2];
				identity[i][j] = new Rectangle(0,0,32, 32);
			   }
		
			if(i > 3 && (i == 0 || i == 63)){
				totalmap[i][j] = terrain[2];
				identity[i][j] = new Rectangle(0,0,32, 32);
		    	}
			
			if(i > 3 && j == 0 || j == 63){
				totalmap[i][j] = terrain[2];
				identity[i][j] = new Rectangle(0,0,32, 32);
			    }
		 /////////////////////////////////////////////////////////////////
		 //Adds the doors
			   if((i == 15 || i == 16 || i == 31 || i == 32 || i == 46 || i == 48))
		         if((j == 7 ||  j == 23 || j == 39 || j == 55)) 		   
		        	 totalmap[i][j] = terrain[3];
			   if((j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48))
			         if((i == 7 || i == 23 || i == 39 || i == 55)) 	
			        	 totalmap[i][j] = terrain[3];
			    
	     /////////////////////////////////////////////////////////////////
		   }
		}  
		
		
		
		
		
	}	

	
	public void addWater(){
		
		//adds the water
				for(int i = 0; i < totalmap.length; i++)
				{
				   for(int j = 0; j < totalmap.length; j++)
				   {
					   if(i < 3)
					   { 
					      totalmap[i][j] = terrain[4];
						identity[i][j] = new Rectangle(0,0,32, 32);
					   }  
				   }
				}
				
		
	}
	
}
	

