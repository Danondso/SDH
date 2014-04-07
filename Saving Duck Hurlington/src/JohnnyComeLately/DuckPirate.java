package JohnnyComeLately;


public class DuckPirate extends Creature{
	 Player Player;
		public DuckPirate(Position p, Player player){
		 super(30, 30, 10, 5, 0, p, "/Entities/Rat/rat.png");
		 Player = player;
		 
	 }

		Projectile Attack() {
			Sword sword = new Sword(2, 2, 2, 2, Enemy, Position);
			return sword;
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
	    	else if (Player.Position.GetY()<Position.GetY()){
	    		Position.AdjustY(-Speed);
	    	}
		}

	}



