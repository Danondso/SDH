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
<<<<<<< HEAD
			int angle = (int) Math.atan2(Player.Position.GetX() - Position.GetX(), Player.Position.GetY() - Position.GetY());
			int xspeed = (int) (ShotSpeed*Math.cos(angle));
			int yspeed = (int) (ShotSpeed*Math.cos(angle));
			Sword sword = new Sword(2, xspeed, yspeed, 2, Enemy, Position);
=======
			Sword sword = new Sword(2, 2, 2, 2, Enemy, new Position(Position.X, Position.Y));
>>>>>>> ea49a23517774156ccc99e896e4d0a3271dc58e0
			return sword;
		}
		
		public void Move() {
			Update();
			// TODO Auto-generated method stub
	    	if(Player.Position.GetX() > Position.GetX()){
	    		Position.AdjustX(Speed);
	    	}
	    	else if(Player.Position.GetX() < Position.GetX()){
	    		Position.AdjustX(-Speed);
	    	}
	    	if(Player.Position.GetY() > Position.GetY()){
	    		Position.AdjustY(Speed);
	    	}
	    	else if (Player.Position.GetY() < Position.GetY()){
	    		Position.AdjustY(-Speed);
	    	}
		}

		@Override
		public Creature clone() {
			return new DuckPirate(Position, Player);
		}

	}



