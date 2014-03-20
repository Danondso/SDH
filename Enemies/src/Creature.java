//attack does not need to be void
abstract class Creature extends Entity{
	protected int Health;
	protected int MaxHealth;
	protected int Damage;
	protected int Speed; //SPEEDS NEED TO BE CHANGED BASED ON HOW THE MAP WORKS
	protected int FacingDirection; // 0 is up, 1 is right, 2 is down, 3 is left
	
	public Creature(int health, int maxhealth, int damage, int speed, Position pos){
		super(pos);
		Health = health;
		MaxHealth = maxhealth;
		Damage = damage;
		Speed = speed;
		FacingDirection = 2;
	}
	
	public int GetHealth(){
		return Health;
	}
	public void AdjustHealth(int health){
		Health += health;
	}
	
	public void Collide(Entity entity){
		if(Overlap(entity)){
			if(entity instanceof Player){
				((Player) entity).AdjustHealth(-Damage);
			}
			
			if(entity instanceof Projectile){
				// check if the projectile is owned by a player, if it is and this is a player then nothing happens, if it is then the enemy is hurt and the projectile is gone.  Same goes for the opposite.
			}
			//write more collision stuff
		}
		
	}
	
	abstract void Attack();
	abstract void Move();
}
