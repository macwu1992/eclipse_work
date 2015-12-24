import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TetrisMain extends Frame{
	
	private final int WIDTH = 500;
	private final int HEIGHT = 600;
	
	public MiniBlock[][] GamePad = new MiniBlock[10][20];
	
	public int x = 150;
	public int y = 30;
	
	TetrisMain(){
//		Block.initial(GamePad);
		lauchFrame();
	}
	
	public void paint(Graphics g){
		
		//画出背景和“记分方块”与“下一块方块”
		Color c = g.getColor();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(300, 0, WIDTH - 300, HEIGHT - 0);
		g.setColor(Color.GREEN);
		g.drawString("分数", 350, 50);
		g.drawRect(330, 30, 150, 100);
		g.setColor(Color.ORANGE);
		g.drawString("下一块", 350, 270);
		g.drawRect(330, 250, 150, 100);
		g.setColor(Color.PINK);
		g.fillRect(x, y, 30, 30);
		y += 30;
		g.setColor(c);
		
		new Thread(new refreshPad()).start();
	}
	
	public void lauchFrame(){
		this.setTitle("Tetris");
		this.setLocation(400,300);
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.GRAY);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public class refreshPad implements Runnable{
		public void run() {
			while(true){
				repaint();
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
					System.exit(0);
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		TetrisMain tm = new TetrisMain();
	}
}


