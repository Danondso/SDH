package Engine;



import Player.*;

import javax.swing.*;

public class Main extends JFrame
	{
		public Main(){

			add(new Board());

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(512, 512);
			setLocationRelativeTo(null);

			setTitle("Saving Duck Hurlington");
			setResizable(false);
			setVisible(true);
		}


		public static void main(String[] args)
	    {
	    	new Main();
	    }
	}
