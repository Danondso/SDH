package Map;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

 public class Beach extends Tiles {
	 
	private static final long serialVersionUID = 1L;
	protected static String[] texture = {"/Beach/sand_grass.png", "/Beach/sand.png", "/Beach/stone.png", "/Beach/wavy_sand.png", "/Beach/water.png"};
    
	public Beach(){super(texture);}
	
	@Override
	public void createMap(){
		
		for(int i = 0; i < row; i ++)
		{
			for(int j = 0; j < column; j ++)
			{
		    
		     int r = rand.nextInt(terrain.length - 1);
				
		        if(r == 2 || r == 4)
		          identity[i][j] = new Rectangle(0,0,32, 32);
		        else
		            identity[i][j] = null;
		     	
		       totalmap[i][j] = terrain[r];
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
//End Class
}
	

