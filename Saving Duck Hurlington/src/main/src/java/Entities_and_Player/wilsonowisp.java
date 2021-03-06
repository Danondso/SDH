package Entities_and_Player;


public class wilsonowisp extends Creature {
 
	Player Player;
	
	public wilsonowisp(Position pos, Player p) {
		super(100, 100, 3, 1, 100, pos, "/Entities/Boss/Wilson.png");
		Player = p;
	}

	@Override
	Projectile AttackMethod() {
		fireball fire = new fireball(Damage, 5, 5, 256, Range, Enemy, new Position(Position.X, Position.Y));
		return fire;
		
	}

	@Override
	public void Move() {
		Update();
		
		//SetX(256);
		//SetY(256);
		
		// TODO Auto-generated method stub
    	if(Player.Position.GetX() > Position.GetX()){
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

	@Override
	public Creature clone() {
		return new wilsonowisp(Position, Player);
	}

}
