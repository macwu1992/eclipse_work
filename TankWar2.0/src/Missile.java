import java.awt.*;
import java.util.List;

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
		if(!this.missileLive) return;
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
			tc.enemyMissiles.remove(this);
		}
	}
	
	public Rectangle getRectangle(){
		return (new Rectangle(x, y, MWIDTH, MHEIGHT));
	}
	
	public boolean hitTank(Tank t){
		if(this.missileLive && this.getRectangle().intersects(t.getRectangle()) && t.isLive){
			if(t.getHits() == 0){
				t.isLive = false;
			}
			this.missileLive = false;
			tc.missiles.remove(this);
			return true;
		}
		return false;	
	}
	
	public boolean enemyHitTank(Tank t){
		if(this.missileLive && this.getRectangle().intersects(t.getRectangle()) && t.isLive){
			this.missileLive = false;
			if(t.getHits() == 0){
					t.isLive = false;
					tc.enemyMissiles.remove(this);
				}
			t.setHits();
			return true;
		}
		return false;	
	}

	
	public void hitTanks(List<Tank> t){
		for(int i = 0; i<t.size(); i++){
			if(this.hitTank(t.get(i))){
				if(t.get(i).getHits() == 0){
					t.get(i).isLive = false;
					tc.tanks.remove(t.get(i));
				}
			t.get(i).setHits();
			}
		}
	}
	
	public void hitWall(List<Wall> w){
		for(int i = 0; i<w.size(); i++){
			Wall theWall = w.get(i);
			if(this.missileLive && this.getRectangle().intersects(theWall.getWall())){
				this.missileLive = false;
				if(theWall.getWallHits() == 0){
						tc.walls.remove(theWall);
					}
				theWall.setWallHits();
				tc.missiles.remove(this);
			}
		}
	}
}



















