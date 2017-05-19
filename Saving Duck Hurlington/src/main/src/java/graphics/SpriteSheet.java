package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

	public String Path;
	public int width;
	public int height;
    private BufferedImage image;
	public int[] pixels;
	
	
	public SpriteSheet(String path){
		
		BufferedImage image = null;
		
		try{
			
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		}catch(IOException e)
		{e.printStackTrace();  // System.out.println(e);
		
		}
		
		if(image == null)
			return;
	
		
		this.Path = path;
	    this.width = image.getWidth();
	    this.height = image.getHeight();
	
	    pixels = image.getRGB(0, 0, width, height, null, 0, width);
	
	    //puts a 0, 1, 2.. in sprite sheet
	   for(int i = 0; i < pixels.length; i++)
		   pixels[i] = (pixels[i] & 0xff)/64;
	   
	   for(int i = 0; i < 8; i++)
	      System.out.println(pixels[i]);
	}
	
}
