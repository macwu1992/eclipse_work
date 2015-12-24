//此版本增加功能：
//画出代表坦克的圆

import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame{
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(50, 50, 30, 30);
		g.setColor(c);
	}

	public void lauchFrame(){
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setBackground(Color.GREEN);
		this.setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
