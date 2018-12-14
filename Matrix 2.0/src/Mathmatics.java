import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mathmatics extends JPanel implements ActionListener{
	private JComboBox<String> eval;
	//combo box to chose all of the different things
	public Mathmatics() {
		String names[] = new String[] { "+", "-", "/", "*" };
		eval = new JComboBox<String>(names);
		eval.addActionListener(this);
	}
	
	public String output(String out) {
		return out;
	}
	//listen for actions to put out
	public void actionPerformed(ActionEvent e) {
		output((String)eval.getSelectedItem());
		//outputs the selected object
	}
}
