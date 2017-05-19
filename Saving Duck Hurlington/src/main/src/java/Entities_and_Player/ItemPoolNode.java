package Entities_and_Player;

public class ItemPoolNode implements Comparable{
	private Item Item;
	private double Value;
	
	protected ItemPoolNode(Item I, double d){
		Item = I;
		Value = d;
	}
	
	protected Item GetItem(){
		return Item;
	}
	
	protected double GetValue(){
		return Value;
	}

	@Override
	public int compareTo(Object node) {
		// TODO Auto-generated method stub
		if(Value < ((ItemPoolNode)node).GetValue())
			return -1;
			
		if(Value > ((ItemPoolNode)node).GetValue())
			return 1;
		
		return 0;
	}
}

