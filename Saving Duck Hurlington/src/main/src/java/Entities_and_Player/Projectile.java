package Entities_and_Player;

//projectiles may not need collision classes, that may need to be moved to creature, to make the code more simple
public abstract class Projectile extends Entity{
	protected int Damage;
	protected int SpeedX;
	protected int SpeedY;//Speed needs to be X and Y for projectile, enemies won't need but one stat for this because they can change their direction
	protected int Range;
	protected int DistTraveled;
	private boolean Owner = Enemy;
	
	public Projectile(int damage, int speedx, int speedy, int range, boolean ownership, Position pos, String ImageLocation){
		super(pos, ImageLocation);
		Damage = damage;
		SpeedX = speedx;
		SpeedY = speedy;
		Range = range;
		DistTraveled = 0;
		Owner = ownership;
	}
	
	public void Move(){
		DistTraveled++;
		if(DistTraveled >= Range)
			this.Remove();
	}
	
	public int GetDamage(){
		return Damage;
	}
	
	public int GetSpeedX(){
		return SpeedX;
	}
	
	public int GetSpeedY(){
		return SpeedY;
	}
	
	public boolean GetOwner(){
		return Owner;
	}
}
