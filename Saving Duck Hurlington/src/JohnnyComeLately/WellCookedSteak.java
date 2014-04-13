package JohnnyComeLately;

public class WellCookedSteak extends Item{

	public WellCookedSteak(Position pos) {
		super(pos, "/Entities/Placeholder/placeholder.png");
	}

	void Collect(Player player) {
		player.MaxHealth += 10;
		player.Health += 10;
	}
}
