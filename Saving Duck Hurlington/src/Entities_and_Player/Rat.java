package Entities_and_Player;
 
import java.util.Random;

public class Rat extends Creature{
	int x,y,xslope,yslope;
	Creature c1;
	Entity e1;
	int movecounter = 0;
	int movecountermax = 10;
	private static Random rand = new Random();
	
	public Rat(Position pos){
		super(1, 1, 5, 	1, 5, pos, "/Entities/Enemies/Rat.png");
		Position = pos;
		
	
		
	}
	

	
	public int upX(){return x;}
	
	public int upY(){return y;}
	
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
	
	    
		//RAT MOVEMENT IS NOT FINAL
	

	Projectile AttackMethod() {
		return null;
		//RAT ATTACKS BY COLLISION
	}
	
	



	@Override
	public Creature clone() {
		// TODO Auto-generated method stub
		return new Rat(Position);
		
	}



	
}
