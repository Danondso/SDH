package JohnnyComeLately;

import java.util.Random;


public class Krabby extends Creature {
	int x,y,xslope,yslope;
	int movecounter = 0;
	int movecountermax = 10;
	private static Random rand;
	public Krabby (Position pos,int yin,int xin){
		super(10,10,3,1, 0,pos, "/Entities/Rat/rat.png");
		Position = pos;
		x = xin;
		y = yin;
		
	
		
	}

	void Move() {
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
}
