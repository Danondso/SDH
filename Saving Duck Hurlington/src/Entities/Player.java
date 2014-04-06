package Entities;

public class Player extends Creature{
	private Projectile Attack;
	protected boolean PanicBoots;
	protected boolean PanicGloves;
	
	public Player(Position pos){
		super(5, 5, 5, 5, 100, pos, "/Entities/Rat/rat.png");
		Attack = new Sword(Damage, Damage, Damage, Damage, IsBurned, pos);
		PanicBoots = false;
		InvincibilityFrames = 10;
	}

	@Override
	Projectile Attack() {
		if(CDelay == 0){
			if(Attack instanceof Sword){
			Projectile sword = new Sword(Damage, Speed, Speed, Range + (PanicGloves ? MaxHealth - Health : 0), Player, Position);
			return sword;
		
			}
			CDelay = AttackDelay;
		}
		else{
			CDelay--;
		}
		// TODO Auto-generated method stub
		return null;
	}

	void SetDirection(int x, int y){
		if(x >= -1 && x <= 1)
			MovingX = x;
		
		if(y >= -1 && y <= 1)
			MovingY = y;
	}
	
	void Move() {
		Update();
		Position.SetX(Position.GetX() + (Speed + (PanicBoots ? MaxHealth - Health : 0)) * MovingX); // if we have PanicBoots then adjust speed based on health missing, Maybe adjust this later to no be insane at hight HP
		Position.SetY(Position.GetY() + (Speed + (PanicBoots ? MaxHealth - Health : 0)) * MovingY);
	}

	public void Collect(Item item){
		//apply changes based on item
	}
}
