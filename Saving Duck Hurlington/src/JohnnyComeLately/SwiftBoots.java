package JohnnyComeLately;

public class SwiftBoots extends Item {

	public SwiftBoots(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(JohnnyComeLately.Player player) {
		// TODO Auto-generated method stub
		player.Speed += 1;
	}
}
