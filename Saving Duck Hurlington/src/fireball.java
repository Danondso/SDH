
public class fireball extends Projectile {
	protected int BurnDamage;

	public fireball(int Damage, int burndamage, int Speed, int Range, boolean ownership, Position pos) {
		super(Damage, Speed, Range, Range, ownership, pos);
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
