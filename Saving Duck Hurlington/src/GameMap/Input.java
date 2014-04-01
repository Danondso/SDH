package GameMap;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {


	private boolean[] keys = new boolean[256];
	
	public Input(Component c){
		
	 c.addKeyListener(this);
	}
	
	
	public boolean isKeyDown(int KeyCode){
		
		
		if(KeyCode > 0 && KeyCode < 256)
		{
		
			return keys[KeyCode];
		}
		
		return false;
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) 
        { 
                keys[e.getKeyCode()] = true; 
        } 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		 if (e.getKeyCode() > 0 && e.getKeyCode() < 256) 
         { 
                 keys[e.getKeyCode()] = false; 
         } 
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
