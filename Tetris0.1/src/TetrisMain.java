import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TetrisMain extends Frame{
	
	private final int WIDTH = 300;
	private final int HEIGHT = 600;
	
	//private final boolean TRUE = 1;
	
	TetrisMain(){
		lauchFrame();
	}
	
	public void lauchFrame(){
		this.setTitle("Tetris");
		this.setLocation(400,300);
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.GRAY);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}
	
	
	
	public static void main(String[] args){
		TetrisMain tm = new TetrisMain();
	}

}
