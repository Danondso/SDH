package Entities_and_Player;

public class WellCookedSteak extends Item{

	public WellCookedSteak(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
	}

	void Collect(Player player) {
		player.MaxHealth += 10;
		player.Health += 10;
	}

	@Override
	public Item Clone() {
		return new WellCookedSteak(Position);
	}
}
