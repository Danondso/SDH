package Entities;

public class wilsonowisp extends Creature {
Player Player;
	public wilsonowisp(Position pos) {
		super(100, 100, 3, 10, 100, pos, "/Entities/Rat/rat.png");
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
    	if(Player.Position.GetX()> Position.GetX()){
    		Position.AdjustX(Speed);
    	}
    	else if(Player.Position.GetX()< Position.GetX()){
    		Position.AdjustX(-Speed);
    	}
    	if(Player.Position.GetY()> Position.GetY()){
    		Position.AdjustY(Speed);
    	}
    	else if (Player.Position.GetY()<Position.GetY()){
    		Position.AdjustY(-Speed);
    	}
	}

}
