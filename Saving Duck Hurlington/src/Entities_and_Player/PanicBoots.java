package Entities_and_Player;

//Increase speed based on missing health
public class PanicBoots extends Item{

	public PanicBoots(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(Player player) {
		player.PanicBoots = true;
	}

	@Override
	public Item Clone() {
		return new PanicBoots(Position);
	}
}
