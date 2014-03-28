//projectiles may not need collision classes, that may need to be moved to creature, to make the code more simple

abstract class Projectile extends Entity{
	protected int Damage;
	protected int SpeedX;
	protected int SpeedY;//Speed needs to be X and Y for projectile, enemies won't need but one stat for this because they can change their direction
	protected int Range;
	protected int DistTraveled;
	protected boolean Owner;
	
	public Projectile(int damage, int speedx, int speedy, int range, boolean ownership, Position pos){
		super(pos);
		Damage = damage;
		SpeedX = speedx;
		SpeedY = speedy;
		Range = range;
		DistTraveled = 0;
		Owner = ownership;
	}
	
	abstract void Move();
	
	public int GetDamage(){
		return Damage;
	}
}
