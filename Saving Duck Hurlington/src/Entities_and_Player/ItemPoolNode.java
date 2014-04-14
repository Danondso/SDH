package Entities_and_Player;

import java.util.Comparator;

public class ItemPoolNode{
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
}
