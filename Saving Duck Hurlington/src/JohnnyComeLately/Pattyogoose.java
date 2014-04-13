package JohnnyComeLately;

public class Pattyogoose extends Creature {
	Player player;
	public Pattyogoose(Position pos, Player p){
		super(6,6,6,2, 3, pos,"/Entities/Placeholder/placeholder.png");
		player = p;
	}

	@Override
	Projectile AttackMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	 public void Move() {
		Update();
		if(player.Position.GetX()>Position.GetX()){
			Position.AdjustX(Speed);
		}
		else if(player.Position.GetX()<Position.GetX()){
		    Position.AdjustX(Speed);	
		}
		if(player.Position.GetY()>Position.GetY()){
			Position.AdjustY(Speed);
		}
		else if(player.Position.GetX()<Position.GetY()){
			Position.AdjustY(Speed);
		}
	}

	@Override
	public Creature clone() {
		return new Pattyogoose(Position,player);
	}

}
