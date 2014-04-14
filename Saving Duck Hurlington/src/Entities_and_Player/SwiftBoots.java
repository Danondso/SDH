package Entities_and_Player;

public class SwiftBoots extends Item {

	public SwiftBoots(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(Entities_and_Player.Player player) {
		// TODO Auto-generated method stub
		player.Speed += 1;
	}
}
