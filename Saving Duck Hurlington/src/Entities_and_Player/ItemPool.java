package Entities_and_Player;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ItemPool implements Comparator<ItemPoolNode>{
	private PriorityQueue<ItemPoolNode> Pool;
	
	public ItemPool(){
		Random rand = new Random();
		Pool.add(new ItemPoolNode(new PanicBoots(new Position(250, 250)), rand.nextDouble()));
		Pool.add(new ItemPoolNode(new PanicGloves(new Position(250, 250)), rand.nextDouble()));
		Pool.add(new ItemPoolNode(new WellCookedSteak(new Position(250, 250)), rand.nextDouble()));
		Pool.add(new ItemPoolNode(new GlassCannon(new Position(250, 250)), rand.nextDouble()));
		Pool.add(new ItemPoolNode(new SwiftBoots(new Position(250, 250)), rand.nextDouble()));
		Pool.add(new ItemPoolNode(new CrazyArm(new Position(250, 250)), rand.nextDouble()));
		//add more as more items added
	}

	public Item NextItem(){
		return (Pool.poll()).GetItem();
	}

	public Item GetHealthPotion(){
		return new HealthPotion(new Position(250, 250));
	}
	
	@Override
	public int compare(ItemPoolNode node1, ItemPoolNode node2) {
		if(node1.GetValue() < node2.GetValue())
			return -1;
			
		if(node1.GetValue() > node2.GetValue())
			return 1;
		
		return 0;
	}
}