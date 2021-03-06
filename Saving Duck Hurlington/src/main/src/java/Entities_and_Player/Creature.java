package Entities_and_Player;


public abstract class Creature extends Entity{
	protected Position PreviousPos;
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
	protected int InvincibilityFrames;
	protected int IFCount; //IFCount counts how many invincibility frames remain on a creature
	protected int AttackDelay;
	protected int CDelay;
	protected int ShotSpeed = 4;


	
	public Creature(int health, int maxhealth, int damage, int speed, int range, Position pos, String ImageLocation){
		super(pos, ImageLocation);
		PreviousPos = new Position(pos.X, pos.Y);
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
		InvincibilityFrames = 3;
		IFCount = 0;
		AttackDelay = 100;
		CDelay = 0;
	}
	
	public int GetMovingX(){
		return MovingX;
	}
	
	public int GetMovingY(){
		return MovingY;
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
		//Collisions are split into Player and non player collisions
		//Added Invincibility frames so that each collision will only damage a character or enemy once
		
		if(Overlap(entity)){
			if(this instanceof Player){
				
				//Player-Enemy collision in case we add an item that does contact damage to enemies, empty for now
				if(entity instanceof Creature){
					
				}
				
				//Player-Projectile collision
				if(entity instanceof Projectile){
					if(((Projectile) entity).GetOwner() == Enemy){//check to see if this creature and the projectile are the same ownership
						if(entity instanceof fireball){
							this.Burn(3, ((fireball)entity).BurnDamage);
						}
						this.AdjustHealth(-((Projectile)entity).Damage);
						entity.Remove();
					}
				}
				
				//Player-Item collision
				if(entity instanceof Item){
					((Item) entity).Collect((Player) this);
					entity.Remove();
				}
				//write more collision stuff				
			}
			
			else{
				//Enemy-Player collision
				if(entity instanceof Player){
					if(((Player) entity).IFCount == 0){
						((Player) entity).AdjustHealth(-Damage);
						((Player) entity).IFCount = ((Player) entity).InvincibilityFrames;
					}
				}
					
					//Enemy-Player collision
					if(entity instanceof Projectile){
						if(((Projectile) entity).GetOwner() == Player){//check to see if this creature and the projectile are the same ownership
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
		
		if(Health <= 0)
			Remove();
		
		if(IFCount > 0)
			IFCount--;
		//More Update stuff, maybe add poison or regeneration over time or something later
	}
	
	public Projectile Attack(){
		if(CDelay == 0){
			Projectile Return = AttackMethod();
			if(Return != null)
				CDelay = AttackDelay;
			return Return;
		}
		else{
			CDelay--;
		}
		return null;
	}
	abstract public Creature clone();
		
			
		
	
	abstract Projectile AttackMethod();
	abstract public void Move();



	public Creature Clone() {
		
		return null;
	}
	
	public int GetPrevX(){
		return PreviousPos.X;
	}
	
	public int GetPrevY(){
		return PreviousPos.Y;
	}
	
	protected void SetPrevious(){
		PreviousPos.X = Position.X;
		PreviousPos.Y = Position.Y;
	}
	

	
}
