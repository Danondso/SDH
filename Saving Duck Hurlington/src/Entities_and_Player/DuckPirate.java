package Entities_and_Player;


public class DuckPirate extends Creature{
	 Player Player;
		public DuckPirate(Position p, Player player)
		{
		//figure out how to slow him, too OP
	    super(30, 30, 10, 1, 0, p, "/Entities/Placeholder/placeholder.png");
		 Player = player;
		 Position = p;
		 
	 }

		Projectile AttackMethod() {
			Sword sword = new Sword(2, 2, 2, 2, Enemy, Position);
			return sword;
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
	    	else if (Player.Position.GetY()<Position.GetY()){
	    		Position.AdjustY(-Speed);
	    	}
		}

		@Override
		public Creature clone() {
			return new DuckPirate(Position, Player);
		}

	}



