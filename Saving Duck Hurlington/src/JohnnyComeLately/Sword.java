package JohnnyComeLately;


public class Sword extends Projectile{

	public Sword(int damage, int speedx, int speedy, int range,
			boolean ownership, Position pos) {
		super(damage, speedx, speedy, range, ownership, pos, "/Entities/Rat/rat.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		super.Move();
		// TODO Auto-generated method stub
		Position.SetX(Position.GetX() + SpeedX);
		Position.SetY(Position.GetY() + SpeedY);
	}

	@Override
	void Collide(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
