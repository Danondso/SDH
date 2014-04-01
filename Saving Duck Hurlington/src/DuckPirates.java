
public class DuckPirates extends Creature {
Player player;
public DuckPirates(Position q,Player player){
	super(30, 30, 10, 5, 0, q);
	Player = player;	
	
}
	@Override
	Projectile Attack() {
		// TODO Auto-generated method stub
		SwordAttack S1 = new SwordAttack(Damage,5,256, Enemy, Position);
		return S1;
	}

	@Override
	void Move() {
		Update();
		// TODO Auto-generated method stub
		if(Player.Position.GetX()>Position.GetX()){
			Position.AdjustX(Speed);
		}
		else if(Player.Position.GetX()<Position.GetX()){
			Position.AdjustX(-Speed);
		}
		if(Player.Position.GetY()>Position.GetY()){
			Position.AdjustY(Speed);
		}
		else if(Player.Position.GetY()<Position.GetY()){
			Position.AdjustY(-Speed);
		}
	}

}
