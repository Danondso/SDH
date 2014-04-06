package Entities;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



//This is a rough draft of the Entities class that will encompass all of the entities of the game, we will make sub classes that makes thing more specific later
abstract class Entity {
	static boolean Player = true;
	static boolean Enemy = false;
	protected Position Position;
	protected Hitbox Hitbox;
	protected boolean Remove;
	protected Image Sprite;
	protected Image Image;
	
	public Entity(Position pos, String ImageLocation){
		//only Players should pass null in
		Position = pos;
		Hitbox = new Hitbox(/*Add information once the Hitbox class has been filled out*/);
		Remove = false;
		
		try{ Image = ImageIO.read(Entity.class.getResourceAsStream("/Entities/Rat/rat.png"));}
		catch(IOException e){System.out.println(e);}
		
		
		
	}
	
	public Image getImage() {
        return Image;
    }
	
	abstract void Collide(Entity entity);
	
	protected boolean Overlap(Entity entity){
		/*if(this overlaps entity)
		 * 	return true;
		 * else return false;
		 */
		return false;
	}
	
	public void Remove(){
		Remove = true;
	}
	public boolean ShouldRemove(){
		return Remove;
	}
	
	public Position GetPosition(){
		return Position;
	}
}