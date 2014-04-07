package JohnnyComeLately;
 
import java.util.Random;

public class Rat extends Creature{
	int x,y,w,h,xslope,yslope;
	Creature c1;
	Entity e1;
	private static Random rand = new Random();
	
	public Rat(Position pos,int yin,int xin,int height,int width){
		super(100 , 100 , 100 , 100, 100, pos, "/Entities/Rat/rat.png");
		Position = pos;
		x = xin;
		y = yin;
		w = width;
		h = height;
		
	}
	

	
	public int upX(){return x;}
	
	public int upY(){return y;}
	
	public void Move() {
		
		int x = Position.GetX() + xslope;
		int y = Position.GetY() + yslope;
		xslope = rand.nextInt(2)*Speed;
		yslope = rand.nextInt(2)*Speed;
		if(x<0) x = w;
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
