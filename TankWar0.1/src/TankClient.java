//此版本创建窗口

import java.awt.*;

public class TankClient extends Frame{
	
	public void lauchFrame(){
		this.setLocation(400, 300);
		this.setSize(800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
