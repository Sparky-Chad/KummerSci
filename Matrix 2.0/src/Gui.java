import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JPanel implements ActionListener{

	private MatPane matrixPane[];
	//matrix panels for the rest of this
	private Mathmatics control;
	private JButton run;
	public Gui() {
		matrixPane[0] = new MatPane();
		matrixPane[1] = new MatPane();
		control = new Mathmatics();
		run = new JButton("Solve");
		run.addActionListener(this);
		run.setActionCommand("solve");
		super.add(matrixPane[0]);
		super.add(control);
		super.add(matrixPane[1]);
		super.add(run);
	}
	
	//Listen for the button to be hit
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "solve") {
			int i = 2;
		}
	}

	public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		Gui gui = new Gui();
        		JFrame jf = new JFrame();
        		jf.add(gui);
            }
        });

	}
}
