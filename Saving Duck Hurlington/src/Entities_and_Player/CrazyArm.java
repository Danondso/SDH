package Entities_and_Player;

public class CrazyArm extends Item {

	public CrazyArm(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(Player player) {
		// TODO Auto-generated method stub
		player.AttackDelay = 2;
		player.Range /= 2;
		if(player.Range < 32)
			player.Range = 32;
	}

}
