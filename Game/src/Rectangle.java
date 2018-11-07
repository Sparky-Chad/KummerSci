import java.awt.*;

public class Rectangle {

	public Color color;
	private int x, y, h, w;
	
	public Rectangle(int xi, int yi) {
		x = xi;
		y = yi;
		h = 300;
		w = 300;
	}
	
	public void fill(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, w, h);
	}
}
