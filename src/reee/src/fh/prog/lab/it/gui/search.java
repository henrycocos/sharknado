package fh.prog.lab.it.gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class search extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel name,id;
	JTextField tname,tid;
	JButton sbutton;
	public search(ActionListener listener){
		setLayout(new GridLayout(2,4));
		name = new JLabel("Name:");
		tname = new JTextField();
		id = new JLabel("ID:");
		tid = new JTextField();
		sbutton = new JButton("Search");
		add(name);
		add(tname);
		add(id);
		add(tid);
		add(sbutton);
		sbutton.setActionCommand("search");
		sbutton.addActionListener(listener);
		
		
	}
}
