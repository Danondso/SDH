package Entities;
import java.util.Random;


public class Krabby extends Creature {
	int x,y,w,h,xslope,yslope;
	private static Random rand;
	public Krabby (Position pos,int yin,int xin,int height,int width){
		super(10,10,3,1, 0,pos, "Entities/Rat/Rat.png");
		Position = pos;
		x = xin;
		y = yin;
		w = width;
		h = height;
		
	}

	void Move() {
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
		
	}

	Projectile Attack() {
		Update();
		return null;
		
	}
}
