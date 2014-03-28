import java.util.Random;

public class Rat extends Creature{
	int x,y,w,h,xslope,yslope;
	Creature c1;
	Entity e1;
	private static Random rand;
	public Rat(Position pos,int yin,int xin,int height,int width){
		super(10,10,1,1, 0,pos);
		Position = pos;
		x = xin;
		y = yin;
		w = width;
		h = height;
		
	}

	void Move() {
		Update();
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
		//RAT MOVEMENT IS NOT FINAL
	}

	Projectile Attack() {
		return null;
		//RAT ATTACKS BY COLLISION
	}
	
	
}
