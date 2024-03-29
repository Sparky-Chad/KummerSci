package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import topten.*;
import java.io.*;

public class Rule extends JPanel implements JavaMap {
	
	private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private boolean inGame = true;
    private TopTen topten;
    private int points;
    
    public Rule() {

        initRule();
    }

    private void initRule() {

		String path = "/home/cjlonghorn/workspace/Pong/src/dat.txt";
		topten = new TopTen();
		try {
		topten.iFile(path);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
    	//initialize player
		points = 0;
		//initialize points
        addKeyListener(new TAdapter());
        setFocusable(true);

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);
    }
    
    @Override
    public void addNotify() {
    	
    	super.addNotify();
    	gameInit();
    }
    
    public void gameInit() {
    	ball = new Ball();
    	paddle = new Paddle();
    }
    
    //component painting and creation
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
    	if(inGame) {
    		drawObjects(g2d);
    	} else {
    		gameFinished(g2d);    	
    	}
    }
    public void drawObjects(Graphics2D g) {
    	g.drawImage(ball.getImage(), ball.getX(), ball.getY(), 
    			ball.width, ball.height, this);
    	//draws the ball on screen
    	g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.width, 
    				paddle.height, this);
		
    }
    public void gameFinished(Graphics2D g) {
    	g.setColor(Color.black);
    	g.drawString("Game Over", Width/2 - 6, Height/2);
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

        	points++;
            ball.move();
            paddle.move();
            checkCollision();
            repaint();
        }
    }
    private void stopGame() {
    	
    	inGame = false;
    	timer.cancel();
    }
    private void checkCollision() {
    	if(ball.getY() > Bottom) {
        	String name = JOptionPane.showInputDialog("Your Name", "John");
        	int temp = (int) System.nanoTime();
        	Player endPlay = new Player(points, name);
        	topten.add(endPlay);
        	topten.oFile("/home/cjlonghorn/workspace/Pong/src/dat.txt");
        	JOptionPane.showMessageDialog(null, "Your Score: " + points + "\n" + topten.toString());
    		
        	stopGame();
    	}
    	
        if ((ball.getRect()).intersects(paddle.getRect())) {

        	ball.setXDir((int)(Math.random() * 3) + 1);
        	if(Math.random() > .5) {
        		ball.setXDir(ball.getXDir() * -1);
        	}
        	ball.setYDir(-1);
            
        }
    }

}
