package Entities_and_Player;


public class wolf extends Creature {
 Creature creature;
 Entity entity;
 int playerhealth;
 Player Player;
	public wolf(Position p, Player player){
	 super(30, 30, 10, 5, 0, p, "/Entities/Placeholder/placeholder.png");
	 Player = player;
	 //checking to  see if neal can see this
	 
 }

	Projectile AttackMethod() {
		return null;
	}
	
	public void Move() {
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
    	else if (Player.Position.GetY()>Position.GetY()){
    		Position.AdjustY(-Speed);
    	}
	}

	@Override
	public Creature clone() {
		return new wolf(Position, Player);
	}

}


