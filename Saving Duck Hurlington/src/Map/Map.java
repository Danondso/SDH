package Map;
import JohnnyComeLately.*;

public class Map {

	private Rooms[][] blueprint;
	private Player player;
	private Rooms room;
	
	
	public Map(Rooms r, Player p)
	{
		//nested for loop generating the room array;
		
		
		//
		room = r;
		player = p;
		
		
	}
	

	public void MapUpdate(){
		
		//need to check if the player moves out of the room
		//if we leave room call this.Clone(RoomWeMovedInto)
		
	}
}