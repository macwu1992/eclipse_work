import java.awt.Color;
import java.awt.Graphics;

public class MiniBlock {
	private final int mini_block_width = 30;
	private final int mini_block_height = 30;
	private int block_value = 0;
	private int x,y = 0;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBlock_value() {
		return block_value;
	}

	public void setBlock_value(int block_value) {
		this.block_value = block_value;
	}

	public int getMiniBlockWidth(){
		return mini_block_width;
	}
	
	public int getMiniBlockHeight(){
		return mini_block_height;
	}
	
}
