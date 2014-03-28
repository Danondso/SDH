
public abstract class Item extends Entity {

	public Item(Position pos) {
		super(pos);
	}

	@Override
	void Collide(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	abstract void Collect(Player player);
}
