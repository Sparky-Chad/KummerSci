package pong;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle extends Sprite implements JavaMap{
	
	private int dirx;
	
	public Paddle() {
		initPaddle();
	}
	
	private void initPaddle() {
		
		loadImage();
		getDimensions();
		
		resetState();
	}
	
	public void loadImage() {
		ImageIcon ii = new ImageIcon("/home/cjlonghorn/workspace/Pong/src/paddle.png");
		image = ii.getImage();
	}
	
	public void move() {
		x += dirx;
		
		if(x<=0) {
			x = 0;
		}
		if(x >= Width - width) {
			x = Width - width;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dirx = -1;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dirx = 1;
		}
	}
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dirx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dirx = 0;
        }
    }
    public void resetState() {
    	x = Init_X;
    	y = Init_Y;
    }

}
