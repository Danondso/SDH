package Entities_and_Player;

public class PinkFluffyUnicorn extends Item {

	public PinkFluffyUnicorn(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	public Item Clone() {
		return new PinkFluffyUnicorn(Position);
	}
	
	void Collect(Player player) {
		// TODO Auto-generated method stub
		player.Health += 20;
		player.MaxHealth += 20;
		//player.Speed -= 1;
	}
}
