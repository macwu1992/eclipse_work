import java.awt.*;

public class Missile{
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int MWIDTH = 10;
	public static final int MHEIGHT = 10;
	
	private boolean missileLive = true;
	
	public boolean isMissileLive() {
		return missileLive;
	}

	int x,y;
	Tank.Direction dir;
	private TankClient tc;
	
	public Missile(int x, int y, Tank.Direction dir) {
		this.x = x+Tank.TKWIDTH/2;
		this.y = y+Tank.TKHEIGHT/2;
		this.dir = dir;
	}
	
	public Missile(int x, int y, Tank.Direction dir, TankClient tc){
		this(x, y, dir);
		this.tc = tc;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, MWIDTH, MHEIGHT);
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
		if(x<0||y<0||x>TankClient.GAME_WIDTH||y>TankClient.GAME_HEIGHT){
			missileLive = false;
			tc.missiles.remove(this);
		}
	}
	
	public Rectangle getRectangle(){
		return (new Rectangle(x, y, MWIDTH, MHEIGHT));
	}
	
	public boolean hitTank(Tank t){
		if(this.getRectangle().intersects(t.getRectangle()) && t.isLive){
			t.isLive = false;
			t.Destroy();
			this.missileLive = false;
			return true;
		}
		return false;	
	}
}



















