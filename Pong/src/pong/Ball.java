package pong;

import javax.swing.ImageIcon;

public class Ball extends Sprite implements JavaMap {
	
	private int xdir;
	//direction along the x axis
	private int ydir;
	//direction along the y axis
	
	public Ball() {
		
		initBall();
	}

	public void initBall() {
		
		xdir = -1;
		ydir = -1;
		
		loadImage();
		getDimensions();
		resetState();
	}
	
	public void loadImage() {
		ImageIcon ii = new ImageIcon("/home/cjlonghorn/workspace/Pong/src/ball.png");
		image = ii.getImage();
	}
	public void move() {
		
		x += xdir;
		y += ydir;
		
		if(x <= 0) {
			setXDir(xdir * -1);
		}
		if(x >= Width - width) {
			setXDir(xdir * -1);
		}
		if(y <= 0) {
			setYDir(1);
		}
	}//end move
	
	public void resetState() {
		x = Init_X;
		y = Init_Y - 100;;
	}
	
	public void setXDir(int x) {
		xdir = x;
	}
	public int getXDir() {
		return xdir;
	}
	public void setYDir(int y) {
		ydir = y;
	}
	public int getYDir() {
		return ydir;
	}
	
}
