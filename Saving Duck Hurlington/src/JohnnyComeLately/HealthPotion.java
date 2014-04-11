package JohnnyComeLately;

public class HealthPotion extends Item {

	public HealthPotion(Position pos){
		super(pos, "/Entities/Rat/rat.png");
		// TODO Auto-generated constructor stub
	}

	void Collect(Player player) {
		player.Health += 20;
	}
}
