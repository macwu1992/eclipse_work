import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
	int x,y;
	public final static int XSPEED = 5;
	public final static int YSPEED = 5;
	
	private boolean bU = false , bD = false , bL = false , bR = false; 
	enum Direction {U , D , L , R ,	LU , RU , LD , RD , STOP};
	
	private Direction dir = Direction.STOP;
	
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		
		move();
	}
	
	public void move(){
		switch(dir){
		case U:
			y -= this.YSPEED;
			break;
		case D:
			y += this.YSPEED;
			break;
		case L:
			x -= this.XSPEED;
			break;
		case R:
			x += this.XSPEED;
			break;
		case LU:
			x -= this.XSPEED;
			y -= this.YSPEED;
			break;
		case LD:
			x -= this.XSPEED;
			y += this.YSPEED;
			break;
		case RU:
			x += this.XSPEED;
			y -= this.YSPEED;
			break;
		case RD:
			x += this.XSPEED;
			y += this.YSPEED;
			break;
		case STOP:
			break;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			}
		
		director();
	}
	
	public void director(){
		if(bL && !bR && !bU && !bD) dir = Direction.L;
		else if(!bL && bR && !bU && !bD) dir = Direction.R;
		else if(!bL && !bR && bU && !bD) dir = Direction.U;
		else if(!bL && !bR && !bU && bD) dir = Direction.D;
		else if(bL && !bR && bU && !bD) dir = Direction.LU;
		else if(bL && !bR && !bU && bD) dir = Direction.LD;
		else if(!bL && bR && bU && !bD) dir = Direction.RU;
		else if(!bL && bR && !bU && bD) dir = Direction.RD;
		else if(!bL && !bR && !bU && !bD) dir = Direction.STOP;
	}

	public void keyReleased(KeyEvent e) {
		int key  = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		}
	}
}

















