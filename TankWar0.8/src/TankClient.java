//此版本增加功能：

//使代表坦克的圆相应上下左右键

import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame{
	int x = 50;
	int y = 50;
	
	Image offScreenImage = null;
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	Tank tank = new Tank(x,y);
	
/*	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
	}*/
	
	public void paint(Graphics g) {
		tank.draw(g);
	}
	
	
	
	public void update(Graphics g) {
		if(offScreenImage == null){
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		
		Graphics goffScreen = offScreenImage.getGraphics();
		Color c = goffScreen.getColor();
		goffScreen.setColor(Color.GREEN);
		goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreen.setColor(c);
		paint(goffScreen);
		g.drawImage(offScreenImage ,0 ,0 ,null);
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
		
		this.addKeyListener(new KeyMonitor()
//		new KeyAdapter() {
//			public void KeyPressed(KeyEvent e){
//				int key = e.getKeyCode();
//				switch(key){
//				case KeyEvent.VK_LEFT:
//					x -= 5;
//					break;
//				case KeyEvent.VK_RIGHT:
//					x += 5;
//					break;
//				case KeyEvent.VK_UP:
//					y -= 5;
//					break;
//				case KeyEvent.VK_DOWN:
//					y += 5;
//					break;
//				}
//			}
//		}
				);
		
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
	
	private class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			tank.keyPressed(e);
		}
	}

}
