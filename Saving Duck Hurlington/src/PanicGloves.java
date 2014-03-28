//Increase Range based on missing health
public class PanicGloves extends Item{

	public PanicGloves(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(Player player) {
		// TODO Auto-generated method stub
		player.PanicGloves = true;
	}

}
