//此版本增加功能：
//1、可以关闭窗口
//2、不能调整窗口大小
import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame{
	
	public void lauchFrame(){
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setTitle("TankWar" );
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
