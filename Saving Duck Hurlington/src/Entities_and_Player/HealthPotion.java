package Entities_and_Player;

public class HealthPotion extends Item {

	public HealthPotion(Position pos){
		super(pos, "/Entities/Items/HealthPotion.png");
		// TODO Auto-generated constructor stub
	}

	void Collect(Player player) {
		player.Health += 20;
		if(player.Health > player.MaxHealth)
			player.Health = player.MaxHealth;
	}

	@Override
	public Item Clone() {
		return new HealthPotion(Position);
	}
}
