import java.awt.*;

//Block种类
public class Block {
	/*
	 * 1...----
	 * 2..._|_
	 * 3...7
	 * 4...
	 * */
	private int initial_x = 150;
	private int initial_y = 30;
	public MiniBlock[][] block = new MiniBlock[4][4];
	
	Block(){
		initial(block);
	}
	
	public static void initial(MiniBlock[][] b){
		for(int i = 0; i<b.length; i++)
			for(int j = 0; j<b[i].length; j++){
				b[i][j].setBlock_value(0);
			}
	}
}
