
public class wolf extends Creature {
 Creature creature;
 Entity entity;
 int playerhealth;
 Player Player;
	public wolf(Position p, Player player){
	 super(30, 30, 10, 5, 0, p);
	 Player = player;
	 
 }

	Projectile Attack() {
		return null;
	}
	
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
    	else if (Player.Position.GetY()>Position.GetY()){
    		Position.AdjustY(-Speed);
    	}
	}

}


