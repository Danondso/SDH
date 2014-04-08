package Map;

import java.awt.Dimension;
import java.awt.Image;
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
		    if((i > 3) && (i == 15 ||i == 31 || i == 32 || i == 47 || i == 48 || i == 63 || i == 64))
		    	totalmap[i][j] = terrain[2];
			
			if((i > 3) && (j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48 || j == 63 || j == 64))
				totalmap[i][j] = terrain[2];
		
			if(i > 3 && (i == 0 || i == 63))
				totalmap[i][j] = terrain[2];
			
			if(i > 3 && j == 0 || j == 63)
				totalmap[i][j] = terrain[2];
		 /////////////////////////////////////////////////////////////////
		 //Adds the doors
			   if((i == 15 || i == 16 || i == 31 || i == 32 || i == 47 || i == 48))
		         if((j == 6 ||  j == 24 || j == 41 || j == 56)) 		   
		        	 totalmap[i][j] = terrain[3];
			   if((j == 15 || j == 16 || j == 31 || j == 32 || j == 47 || j == 48))
			         if((i == 7 || i == 24 || i == 41 || i == 56)) 	
			        	 totalmap[i][j] = terrain[3];
	     /////////////////////////////////////////////////////////////////
		   }
		}  
		
		for(int i = 0; i < totalmap.length; i++)
		{
		   for(int j = 0; j < totalmap.length; j++)
		   {
			   if(i < 3)
			      totalmap[i][j] = terrain[4];
		   }
		}
		
		
	}	




}
	

