package Map;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Player.Board;

//Map will function as a dynamic loader for the moment.
public class Map extends JFrame{

	private JFrame j;

	
	
//	private int x;
//	private int y;
//	private int xdest;
//	private int ydest;
	private Image i;
	private Beach test;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//will display the map 
	public Map(){
		
		
		j = new JFrame("Map");
		j.setPreferredSize(new Dimension(800,800));
		j.add(this.addlvl());
		j.pack();
		j.setVisible(true);
	  
	}
	
  
	public Tiles addlvl(){
	test = new Beach();
	test.createMap();
	test.clearDoors();
	test.genBorders();		
	test.loadTile();

		return test;
		
	}
	
	//https://www.youtube.com/watch?v=1XperKlhD48
	
	
	
	/*
	 *Methods:
	 *Loading -- will load the  
	 * 
	 * Make methods in tiles for borders, then generate the inside
	 * 
	 * 
	 */
	
	private void loadEntities(){
		
	}
	
	private void loadItems(){
		
	}
	
	
	public void LoadLevel(){
		
		
	}
	
	public Board loadPlayer(){
		return new Board();
	}
		
/*
 * this is the test main to make sure map works
 * Game needs to get fixed to map can be added
 */

public static void main(String[] args){
	

	new Map();

}
	
	
	
}
