package Entities_and_Player;

import java.util.Random;


public class SeaTurtle extends Creature {
	int x,y,xslope,yslope;
	int movecounter = 0;
	int movecountermax = 10;
	private static Random rand = new Random(System.currentTimeMillis());
	public SeaTurtle(Position pos){
		super(10,10,1,1, 0,pos, "/Entities/Enemies/SeaTurtle.png");
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
	return new SeaTurtle(Position);
	}
}