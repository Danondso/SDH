package Entities_and_Player;

//Increase Range based on missing health
public class PanicGloves extends Item{

	public PanicGloves(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	void Collect(Player player) {
		player.PanicGloves = true;
	}

}
