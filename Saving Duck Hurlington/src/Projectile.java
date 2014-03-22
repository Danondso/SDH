//projectiles need to take in ranges in their constructors and position
abstract class Projectile extends Entity{
	private int Damage;
	private int Speed; //Speed needs to be X and Y for projectile, enemies won't need but one stat for this because they can change their direction
	private int Range;
	private int DistTraveled;
	boolean Owner;
	
	public Projectile(int Damage, int Speed, int Range, boolean ownership){
		//What do we need here?
	}
	
	abstract void Move();
}
