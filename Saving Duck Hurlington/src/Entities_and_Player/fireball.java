package Entities_and_Player;


public class fireball extends Projectile {
	protected int BurnDamage;

	public fireball(int Damage, int burndamage, int SpeedX, int SpeedY, int Range, boolean ownership, Position pos) {
		super(Damage, SpeedX, SpeedY, Range, ownership, pos, "/Entities/Placeholder/placeholder.png");
		BurnDamage = burndamage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Move() {
		// TODO Auto-generated method stub
		super.Move();
		Position.SetX(Position.GetX() + SpeedX);
		Position.SetY(Position.GetY() + SpeedY);
	}

	@Override
	void Collide(Entity entity) {
		if(Overlap(entity) && entity instanceof Creature){
			((Creature) entity).Burn(20, BurnDamage);
		}
		// TODO Auto-generated method stub
		
	}

}
