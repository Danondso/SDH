public class Position {
	private int X;
	private int Y;
	
	public Position(int x, int y){
		X = x;
		Y = y;
	}
	
	public int GetX(){
		return X;
	}
	
	public int GetY(){
		return Y;
	}
	
	public void SetX(int x){
		X = x;
	}
	
	public void SetY(int y){
		Y = y;
	}
	
	public void AdjustX(int x){
		X += x;
	}
	
	public void AdjustY(int y){
		Y += y;
	}
}
