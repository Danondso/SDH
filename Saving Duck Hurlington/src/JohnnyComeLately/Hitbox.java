package JohnnyComeLately;


public class Hitbox {
	protected Position Position;
	protected int Width;
	protected int Height;
	
	protected Hitbox(Position pos, int width, int height){
		Position = pos;
		Width = width;
		Height = height;
	}
	
	protected boolean Intersect(Hitbox other){
		if(Position.X > other.Position.X + other.Width || 
		   Position.X + Width < other.Position.X || 
		   Position.Y > other.Position.Y + other.Height || 
		   Position.Y + Height < other.Position.Y)
			return false;
		else return true;
	}
}
