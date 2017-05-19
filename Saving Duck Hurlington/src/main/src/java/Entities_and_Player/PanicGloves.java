package Entities_and_Player;

//Increase Range based on missing health
public class PanicGloves extends Item{

	public PanicGloves(Position pos) {
		super(pos, "/Entities/Items/PanicGloves.png");
		// TODO Auto-generated constructor stub
	}

	void Collect(Player player) {
		player.PanicGloves = true;
	}

	@Override
	public Item Clone() {
		return new PanicGloves(Position);
	}
}
