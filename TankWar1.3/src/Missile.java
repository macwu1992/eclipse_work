import java.awt.*;

public class Missile{
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	int x,y;
	Tank.Direction dir;
	
	public Missile(int x, int y, Tank.Direction dir) {
		this.x = x+Tank.TKWIDTH/2;
		this.y = y+Tank.TKHEIGHT/2;
		this.dir = dir;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 10, 10);
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
		}
	}
}
