package Player;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.Beach;
public class RType extends JFrame {

	//private Beach m = new Beach();
	
    public RType() {
     	
    	//JLabel background = new JLabel(new ImageIcon(map[0][0]));
    	
    	//add(background, 0);
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(512, 512);
        setLocationRelativeTo(null);
        
        setTitle("Saving Duck Hurlington");
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args){
    	
    	new RType();
    	
    }
    
    
}