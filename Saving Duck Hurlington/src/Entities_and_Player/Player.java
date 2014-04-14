package Entities_and_Player;


public class Player extends Creature{
	private Projectile Attack;
	private int ShotX = 0;
	private int ShotY = 0;
	protected boolean PanicBoots;
	protected boolean PanicGloves;
	
	public Player(Position pos){
		super(5, 5, 5, 5, 100, pos, "/Entities/Placeholder/placeholder.png");
		Attack = new Sword(Damage, ShotSpeed * ShotX, ShotSpeed * ShotY, Range, Player, pos);
		PanicBoots = false;
		InvincibilityFrames = 10;
	}

	Projectile AttackMethod() {
		if(ShotX != 0 && ShotY != 0){
			if(Attack instanceof Sword){
			Projectile sword = new Sword(Damage, /*holy crap no, please no, Matt means SpeedX and SpeedY*/Speed, Speed, Range + (PanicGloves ? MaxHealth - Health : 0), Player, Position);
			return sword;
			}
		}
		return null;
	}

	void SetShotDirection(int x, int y){
		if(x >= -1 && x <= 1)
			ShotX = x;
		
		if(y >= -1 && y <= 1)
			ShotY = y;
	}
	
	void SetShotXDirection(int x){
		if(x >= -1 && x <= 1)
			ShotX = x;
	}
	
	void SetShotYDirection(int y){
		if(y >= -1 && y <= 1)
			ShotY = y;
	}
	
	void SetDirection(int x, int y){
		if(x >= -1 && x <= 1)
			MovingX = x;
		
		if(y >= -1 && y <= 1)
			MovingY = y;
	}
	
	void SetXDirection(int x){
		if(x >= -1 && x <= 1)
			MovingX = x;
	}
	
	void SetYDirection(int y){
		if(y >= -1 && y <= 1)
			MovingY = y;
	}
	
	public void Move() {
		Update();
		Position.SetX(Position.GetX() + (Speed + (PanicBoots ? MaxHealth - Health : 0)) * MovingX); // if we have PanicBoots then adjust speed based on health missing, Maybe adjust this later to no be insane at hight HP
		Position.SetY(Position.GetY() + (Speed + (PanicBoots ? MaxHealth - Health : 0)) * MovingY);
	}

	public void Collect(Item item){
		//apply changes based on item
	}

@Override
public Creature clone() {
	// TODO Auto-generated method stub
	return null;
}
}
