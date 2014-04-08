package Player;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.Beach;
public class RType extends JFrame {

	private Beach m = new Beach();
	
    public RType() {
     	
    	//JLabel background = new JLabel(new ImageIcon(map[0][0]));
    	
    	//add(background, 0);
        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        
        setTitle("R - Type");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RType();
    }
}