//此版本增加功能：
//使代表坦克的圆动起来

import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame{
	int x = 50;
	int y = 50;
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		y += 5;
	}

	public void lauchFrame(){
		this.setLocation(400, 300);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setBackground(Color.GREEN);
		this.setResizable(false);
		setVisible(true);
		
		new Thread(new PaintThread()).start();
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}
	
	private class PaintThread implements Runnable{
		public void run(){
			while(true){
				repaint();
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

}
