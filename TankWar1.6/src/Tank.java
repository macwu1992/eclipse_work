import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
	int x,y;
	public final static int XSPEED = 5;
	public final static int YSPEED = 5;
	public final static int TKWIDTH = 30;
	public final static int TKHEIGHT = 30;
	TankClient tc;
	
	private boolean bU = false , bD = false , bL = false , bR = false; 
	enum Direction {U , D , L , R ,	LU , RU , LD , RD , STOP};
	
	private Direction dir = Direction.STOP;
	private Direction gun_dir = Direction.R;
	
	private boolean isGood;
	public boolean isLive = true;
	
	
	public Tank(int x , int y , boolean isgood) {
		this.x = x;
		this.y = y;
		this.isGood = isgood;
	}
	
	public Tank(int x, int y, boolean isgood , TankClient tc) {
		this(x, y , isgood);
		this.tc = tc;
	}
	
	public void draw(Graphics g){
		if(!this.isLive) return;
		Color c = g.getColor();
		if(this.isGood){
			g.setColor(Color.RED);}
		else{
			g.setColor(Color.DARK_GRAY);
		}
		g.fillOval(x, y, TKWIDTH, TKHEIGHT);
		g.setColor(c);
		
		switch(gun_dir){
		case U:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x+TKWIDTH/2, y);
			break;
		case D:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x+TKWIDTH/2, y+TKHEIGHT);
			break;
		case L:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x, y+TKHEIGHT/2);
			break;
		case R:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x+TKWIDTH, y+TKHEIGHT/2);
			break;
		case LU:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x, y);
			break;
		case RD:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x+TKWIDTH, y+TKHEIGHT);
			break;
		case RU:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x+TKWIDTH, y);
			break;
		case LD:
			g.drawLine(x+TKWIDTH/2, y+TKHEIGHT/2, x, y+TKHEIGHT);
			break;
		}
		
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
		
		if(this.dir != Direction.STOP){
			gun_dir = this.dir;
		}
		
		if(x < 0)	x = 0;
		if(y < 30)	y = 30;
		if(x+Tank.TKWIDTH > TankClient.GAME_WIDTH)	x = TankClient.GAME_WIDTH-Tank.TKWIDTH;
		if(y+Tank.TKHEIGHT > TankClient.GAME_HEIGHT)	y = TankClient.GAME_HEIGHT-Tank.TKHEIGHT;
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
		case KeyEvent.VK_SPACE:
			fire();
			break;
		}
	}
	
	public Rectangle getRectangle(){
		return (new Rectangle(x, y, TKWIDTH, TKHEIGHT));
	}
	
	public Missile fire(){
		Missile m = new Missile(x, y, gun_dir, this.tc);
		tc.missiles.add(m);
		
		return m;
	}
	
	public void Destroy(){
		if(!this.isLive)
		{
			try {
				this.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}



















