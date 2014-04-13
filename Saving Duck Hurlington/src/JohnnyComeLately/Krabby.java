package JohnnyComeLately;

import java.util.Random;


public class Krabby extends Creature {
	int x,y,xslope,yslope;
	int movecounter = 0;
	int movecountermax = 10;
	private static Random rand;
	public Krabby (Position pos){
		super(10,10,3,1, 0,pos, "/Entities/Placeholder/placeholder.png");
		Position = pos;
		
	
		
	
		
	}

	public void Move() {
		if(movecounter == 0){
	    	xslope = (rand.nextInt(3) - 1) * Speed;
	    	yslope = (rand.nextInt(3) - 1) * Speed;
	    	movecounter = movecountermax;
	    }
	    else{
	    	movecounter--;
	    }
		Position.SetX(Position.GetX() + xslope);
		Position.SetY(Position.GetY() + yslope);
		Update();
	    }
	

	Projectile AttackMethod() {
		Update();
		return null;
		
	}

	@Override
	public Creature clone() {
		return new Krabby(Position);
	}
}
