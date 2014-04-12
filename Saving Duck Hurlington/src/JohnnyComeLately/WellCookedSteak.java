package JohnnyComeLately;

public class WellCookedSteak extends Item{

	public WellCookedSteak(Position pos) {
		super(pos, "/Entities/Rat/rat.png");
	}

	void Collect(Player player) {
		player.MaxHealth += 10;
	}
}
