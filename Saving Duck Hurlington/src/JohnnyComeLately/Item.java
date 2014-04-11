package JohnnyComeLately;


public abstract class Item extends Entity {

	public Item(Position pos, String ItemLocation) {
		super(pos, ItemLocation);
	}

	@Override
	void Collide(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	
	public void HeartItem(){
		
		return Heart;
	}
	
	abstract void Collect(Player player);
}
