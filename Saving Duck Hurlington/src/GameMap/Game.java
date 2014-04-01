package GameMap;
import Map.*;
import Player.*;
import graphics.Screen;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 3;
	private int tickcount = 0;
	private int gl;
	public static final String map = "Game";
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private  int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    
	private Input handler;
	int x = 0;
	
	//private SpriteSheet spriteSheet = new SpriteSheet("/Beach/sand.png");	
	private Screen screen;
	
	
	private JFrame frame;
	
	//public
	
	public Game(){

		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		frame = new JFrame(map);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	    frame.add(this, BorderLayout.CENTER);

	    frame.add(new Map());

	    frame.pack();
	    frame.setResizable(true);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	}
	

	public boolean running = false;
	//Screen test = new Screen();
	
	
	public static void initialize(){
		
		new Game().start();
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		long lasttime = System.nanoTime();
		double nspertick = 1000000000D/60D;
		
		int frames = 0;
		int ticks = 0;
		
		long lastimer = System.currentTimeMillis();
		double delta = 0;
		
	 //  test.getFullScreenWindow();
		
		while(running){
					
			long now = System.nanoTime();
			delta += (now - lasttime) / nspertick;
			lasttime = now;
			tick();
			boolean shouldrender = true;
			//System.out.println("Goopty");
			
			while(delta >= 1){
				
				ticks++;
				tick();
				delta -= 1;
				shouldrender = true;
			}
			try{
			Thread.sleep(2);
			}
			catch(InterruptedException e){}
			
			
			
			if(shouldrender){
			
		    frames++;	
			render();
			
			}
			if(System.currentTimeMillis() - lastimer >= 1000)
			{
				lastimer += 1000;
				System.out.println(frames + "," + ticks);
				frames = 0;
				ticks = 0;
			}
				
			//System.out.println(frames + "," + ticks);
			
		    }
			
		}
	
	
	
	
	public void tick(){
		
		tickcount ++;	
		
		for(int i = 0; i < pixels.length; i++)
		{
			new Board();
			pixels[i] = i + tickcount;
		}
		
	}
	//update function
	public void render(){
		
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null){
		createBufferStrategy(3);
		return;
		}
		Graphics g = bs.getDrawGraphics();
		bs.show();
	}
	
	
	public synchronized void start(){
	 
		running = true;
		new Thread(this).start();
	}
   
	public synchronized void stop(){
		running = false;
		
		
	}
	
	public static void main(String[] args){
	
		initialize();
		
	}
	
}