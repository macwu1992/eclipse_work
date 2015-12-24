//此版本增加功能：

//使代表坦克的圆相应上下左右键

import java.awt.*;
import java.awt.List;
import java.util.*;

import java.awt.event.*;

public class TankClient extends Frame{
	int x = 50;
	int y = 50;
	
	Image offScreenImage = null;
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	private Random r = new Random();
	private int enemyLocate = r.nextInt(100);
	
	public Tank tank = new Tank(x, y, true, this);;
	ArrayList<Tank> tanks = new ArrayList<Tank> ();
	ArrayList<Missile> missiles = new ArrayList<Missile> ();
	ArrayList<Missile> enemyMissiles = new ArrayList<Missile> ();
	
	public void lauchFrame(){
		
		for(int i = 0; i<5; i++){
			tanks.add(new Tank((i+1)*enemyLocate, (i+3)*enemyLocate, false, this));
		}
		this.setLocation(30, 40);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setBackground(Color.GREEN);
		this.setResizable(false);
		
		this.addKeyListener(new KeyMonitor());
		
		setVisible(true);
		
		new Thread(new PaintThread()).start();
	}

	
	public void paint(Graphics g) {
		g.drawString("Missiles count:"+missiles.size(), 10, 50);
		g.drawString("EnemyTanks count:"+tanks.size(), 10, 30);
		g.drawString("EnemyMissiles count:"+enemyMissiles.size(), 10, 70);
		tank.draw(g);
		for(int k = 0; k<tanks.size(); k++){
			Tank t = tanks.get(k);
			if(t.isLive) t.draw(g);
		}
		
		for(int i=0; i<missiles.size();i++){
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.draw(g);
		}
		
		for(int i=0; i<enemyMissiles.size();i++){
			Missile m = enemyMissiles.get(i);
			m.enemyHitTank(tank);
			m.draw(g);
		}
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
	
	private class PaintThread implements Runnable{
		public void run(){
			while(true){
				repaint();
				try{
					Thread.sleep(50);
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

		public void keyReleased(KeyEvent e) {
			tank.keyReleased(e);
		}
		
		
	}
	
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}
}
