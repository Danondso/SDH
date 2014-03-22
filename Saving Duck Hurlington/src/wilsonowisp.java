
public class wilsonowisp extends Creature {

	public wilsonowisp(Position pos) {
		super(100,100,3,10,pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	void Attack() {
		fireball fire = new fireball(Damage,5,256,Enemy);
		//return fireball;
		// TODO Auto-generated method stub
		
	}

	@Override
	void Move() {
		// TODO Auto-generated method stub
		
	}
}
