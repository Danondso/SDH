package Entities_and_Player;

public class CrazyArm extends Item
{

	public CrazyArm(Entities_and_Player.Position pos) {
		super(pos, "/Entities/Items/CrazyArm.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(Player player) {
		// TODO Auto-generated method stub
		player.AttackDelay = AttackDelayCap;
		player.Range /= 2;
		if(player.Range < 32)
			player.Range = 32;
	}

	@Override
	public Item Clone() {
		return new CrazyArm(Position);
	}

}
