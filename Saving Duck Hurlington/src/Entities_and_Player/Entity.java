package Entities_and_Player;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



//This is a rough draft of the Entities class that will encompass all of the entities of the game, we will make sub classes that makes thing more specific later
abstract class Entity {
	protected static int AttackDelayCap = 25;
	static Entities_and_Player.Player Player = true;
	static boolean Enemy = false;
	protected Position Position;
	protected Hitbox Hitbox;
	protected boolean Remove;
	protected Image Sprite;
	protected Image Image;
	
	public Entity(Position pos, String ImageLocation){
		Position = pos;
		Remove = false;
		
		try{
			Image = ImageIO.read(Entity.class.getResourceAsStream(ImageLocation));
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		Hitbox = new Hitbox(pos, Image.getWidth(null), Image.getHeight(null));
	}
	
	public Image getImage() {
        return Image;
    }
	
	public int GetX(){
		return Position.GetX();
	}
	
	public int GetY(){
		return Position.GetY();
	}
	
	public void SetX(int x){
		Position.SetX(x);
	}
	
	public void SetY(int y){
		Position.SetY(y);
	}
	
	abstract void Collide(Entity entity);
	
	protected boolean Overlap(Entity entity){
		return Hitbox.Intersect(entity.Hitbox);
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