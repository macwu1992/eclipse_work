package com.javalearn.tankwar;
import java.awt.*;
import java.util.ArrayList;

public class Wall {
	
	private int x = 100,y = 200;
	private int WALLWIDTH = 50;
	private int WALLHEIGHT = 30;
	private Rectangle rc;
	private boolean wallLive = true;
	private int wallHits = 15;
	
	public int getWallHits() {
		return wallHits;
	}

	public void setWallHits() {
		this.wallHits--;
	}

	public Wall(){
		buildWall(x,y);
	}
	
	public Wall(int x, int y){
		this.x = x;
		this.y = y;
		buildWall(x,y);
	}
	
	public void draw(Graphics g, int x, int y){
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, WALLWIDTH, WALLHEIGHT);
		g.setColor(c);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void buildWall(int wallX, int wallY){
		rc = new Rectangle(wallX, wallY, WALLWIDTH, WALLHEIGHT);
	}
	
	public Rectangle getWall(){
		return rc;
	}
	
	
}
