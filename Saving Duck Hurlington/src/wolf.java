
public class wolf extends Creature {
 Creature creature;
 Entity entity;
 int playerhealth;
 Player Player;
	public wolf(Position p, Player player){
	 super(30,30,10,5, p);
	 Player = player;
	 
 }
	
@Override
void Attack() {
	// TODO Auto-generated method stub
	
	}

@Override
void Move() {
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


