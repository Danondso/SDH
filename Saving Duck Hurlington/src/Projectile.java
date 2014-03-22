abstract class Projectile extends Entity{
	private int Damage;
	private int SpeedX;
	private int SpeedY;//Speed needs to be X and Y for projectile, enemies won't need but one stat for this because they can change their direction
	private int Range;
	private int DistTraveled;
	boolean Owner;
	
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
}
