import java.awt.Image;

//This is a rough draft of the Entities class that will encompass all of the entities of the game, we will make sub classes that makes thing more specific later
abstract class Entity {
	static boolean Player = true;
	static boolean Enemy = false;
	protected Position Position;
	protected Hitbox Hitbox;
	protected boolean Remove;
	protected Image Sprite;
	
	public Entity(Position pos){
		//only Players should pass null in
		Position = pos;
		Hitbox = new Hitbox(/*Add information once the Hitbox class has been filled out*/);
		Remove = false;
	}
	
	
	
	/* This needs to cover all collisions between all types of entities, unless it is divided among the types themselves.
	 * This would be a better idea.  It would allow for a more simple method and not all of them actually need interaction function.
	 * From what Zack said about the main loop, a projectile shouldn't every be the origin, i.e. Projectile.Collide(Entity) should never be called.
	 * This allows us to skip writing the functions that don't need to be used because they are covered in other situations.
	 * 
	 * Projectile doesn't need a method for this because anything the projectile will already run through the lists of entities to check if it needs to do anything.
	 * Because of this, it is strictly necessary to write collisions for them.  It will probably be done anyway though.
	 * -Matthew
	 */
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