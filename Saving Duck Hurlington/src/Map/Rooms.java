package Map;

import java.awt.Image;

import JohnnyComeLately.Player;
import JohnnyComeLately.*;
 


public class Rooms {
	
	private Image[][] display;
    private Beach beach;
    private Forest forest;
    private Mountain mountain;
	
	
	public Rooms(Tiles  t,Player p){
		
	  
		LoadMap(t);
		
		
		
	}
	
	
	public Tiles LoadMap(Tiles t){
		
		t.createMap();
	    t.clearDoors();
	    t.genBorders();
	    t.addDoors();
		
		return t;
	}
	
	public Entity genEnemies(){
		
	}
	
	

}
