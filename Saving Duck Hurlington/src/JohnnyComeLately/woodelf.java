package JohnnyComeLately;
import java.util.Random;

public class woodelf extends Creature {
    int xslope;
    int yslope;
    int movecounter = 0;
    int movecountermax = 10;
    public static Random rand = new Random();
    
	public woodelf(Position p){
		super(6,6,6,2, 3, p,"/Entities/Placeholder/placeholder.png");
		Position = p;
	}
	@Override
	Projectile AttackMethod() {
		Spear spear = new Spear(2,2,2,2,Enemy,Position);
		return null;
	}

	@Override

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
	@Override
	public Creature clone() {
		return new woodelf(Position);
	}
		
	}


