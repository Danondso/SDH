
public class wilsonowisp extends Creature {

	public wilsonowisp(Position pos) {
		super(100, 100, 3, 10, 100, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	Projectile Attack() {
		fireball fire = new fireball(Damage, 5, 256, Range, Enemy, Position);
		return fire;
		
	}

	@Override
	void Move() {
		Update();
		// TODO Auto-generated method stub
		
	}
}
