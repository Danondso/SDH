import java.util.Random;

public class Rat extends Creature{
	int x,y,w,h,xslope,yslope;
	Creature c1;
	Entity e1;
	private static Random rand;
	public Rat(Position pos,int yin,int xin,int height,int width){
		super(10,10,1,1,pos);
		Position = pos;
		x = xin;
		y = yin;
		w = width;
		h = height;
		
	}

	@Override
	void Move() {
		int x = Position.GetX() + xslope;
		int y = Position.GetY() + yslope;
		xslope = rand.nextInt(2)*Speed;
		yslope = rand.nextInt(2)*Speed;
		if(x<0) x = w;
		if(x > w) x = 0;
		if(y < 0) y = h;
		if(y > h) y = 0;
		Position.SetX(Position.GetX());
		Position.SetY(Position.GetY());
		//RAT MOVEMENT IS NOT FINAL
	}

	@Override
	void Attack() {
		//RAT ATTACKS BY COLLISION
		
	}
	
	
}
