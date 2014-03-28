//Creatures need to know what directions they are moving so that they know what to give to their attack functions as far as speed goes
abstract class Creature extends Entity{
	protected int Health;
	protected int MaxHealth;
	protected int Damage;
	protected int Range;
	protected int Speed; //SPEEDS NEED TO BE CHANGED BASED ON HOW THE MAP WORKS
	protected int FacingDirection; // 0 is up, 1 is right, 2 is down, 3 is left
	protected int MovingX;
	protected int MovingY;
	protected boolean IsBurned;
	protected int BurnTime;
	protected int BurnDamage;
	
	public Creature(int health, int maxhealth, int damage, int speed, int range, Position pos){
		super(pos);
		Health = health;
		MaxHealth = maxhealth;
		Damage = damage;
		Speed = speed;
		Range = range;
		FacingDirection = 2;
		IsBurned = false;
		BurnDamage = 0;
		BurnTime = 0;
		MovingX = 0;
		MovingY = 0;
	}
	
	public int GetHealth(){
		return Health;
	}
	public void AdjustHealth(int health){
		Health += health;
	}
	
	public void Burn(int duration, int Bdamage){
		IsBurned = true;
		BurnTime = duration;
		if(BurnDamage > 0)
		BurnDamage = Bdamage;
	}
	
	public void Collide(Entity entity){
		//Current collisons are Player-Enemy, Creature-Projectile,
		if(Overlap(entity)){
			if(entity instanceof Player){
				((Player) entity).AdjustHealth(-Damage);
			}
			
			if(entity instanceof Projectile){
				if((((Projectile) entity).Owner = Enemy && this instanceof Player) || (((Projectile) entity).Owner = Player && !(this instanceof Player))){//check to see if this creature and the projectile are the same ownership
					if(entity instanceof fireball){
						this.Burn(3, ((fireball)entity).BurnDamage);
					}
					this.AdjustHealth(-((Projectile)entity).Damage);
					entity.Remove();
				}
			}
			
			//write more collision stuff
		}
		
	}
	protected void Update(){
		if(IsBurned){
			Health -= BurnDamage;
			BurnTime--;
			if(BurnTime < 1){
				IsBurned = false;
				BurnDamage = 0;
			}
		}
		
		//More Update stuff, maybe add poison or regeneration over time or something later
	}
	
	abstract Projectile Attack();
	abstract void Move();
}
