package JohnnyComeLately;

public class GlassCannon extends Item {

	public GlassCannon(Position pos){
		super(pos, "/Entities/Placeholder/placeholder.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Collect(Player player) {
		player.Damage *= 2;
		player.MaxHealth /= 2;
		if(player.Health > player.MaxHealth)
			player.Health = player.MaxHealth;
	}
}
