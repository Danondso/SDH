
public class Player extends Creature{
	private Projectile Attack;
	
	public Player(Position pos){
		super(5, 5, 5, 5, 100, pos);
		Attack = new Sword(Damage, Damage, Damage, Damage, IsBurned, pos);
	}

	@Override
	Projectile Attack() {
		if(Attack instanceof Sword){
			Projectile sword = new Sword(Damage, Speed, Speed, Damage, Player, Position);
			return sword;
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
		Position.SetX(Position.GetX() + Speed * MovingX);
		Position.SetY(Position.GetY() + Speed * MovingY);
	}

}
