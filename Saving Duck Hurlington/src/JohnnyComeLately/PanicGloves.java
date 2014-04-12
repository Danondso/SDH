package JohnnyComeLately;

//Increase Range based on missing health
public class PanicGloves extends Item{

	public PanicGloves(Position pos) {
		super(pos, "/Entities/Rat/rat.png");
		// TODO Auto-generated constructor stub
	}

	void Collect(Player player) {
		player.PanicGloves = true;
	}

}
