package fh.prog.lab.it.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class editframe extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JLabel label;
	public editframe(){
		panel = new JPanel(new GridLayout(2, 2));
		label = new JLabel("Das ist ein Test");
		add(panel);
		panel.add(label);
		setTitle("EditierFenster");
		setLocationRelativeTo(null);
		setSize(300, 500);
		setVisible(true);
	}
}
