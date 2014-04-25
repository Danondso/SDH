package Entities_and_Player;

public class FireAttack extends Item {

	public FireAttack(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
	}

	@Override
	public Item Clone() {
		return new FireAttack(Position);
	}

	@Override
	void Collect(Entities_and_Player.Player player) {
		player.Attack = new fireball(0, 0, 0, 0, 0, false, null);
	}
}
