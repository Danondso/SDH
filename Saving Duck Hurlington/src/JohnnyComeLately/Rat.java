package JohnnyComeLately;
 
import java.util.Random;

public class Rat extends Creature{
	int x,y,w,h,xslope,yslope;
	Creature c1;
	Entity e1;
	private static Random rand = new Random();
	
	public Rat(Position pos,int yin,int xin,int height,int width){
		super(5, 5, 5, 1, 5, pos, "/Entities/Rat/rat.png");
		Position = pos;
		x = xin;
		y = yin;
		w = width;
		h = height;
		
	}
	

	
	public int upX(){return x;}
	
	public int upY(){return y;}
	
	public void Move() {
		
		x = Position.GetX() + xslope;
	    y = Position.GetY() + yslope;
		xslope = (rand.nextInt(3) - 1) * Speed;
		yslope = (rand.nextInt(3) - 1) * Speed;
		if(x < 0) x = w;
		if(x > w) x = 0;
		if(y < 0) y = h;
		if(y > h) y = 0;
		Position.SetX(Position.GetX() + xslope);
		Position.SetY(Position.GetY() + yslope);
		Update();
		//RAT MOVEMENT IS NOT FINAL
	}

	public Projectile Attack() {
		return null;
		//RAT ATTACKS BY COLLISION
	}
	
	
}
