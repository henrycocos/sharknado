package fh.prog.lab.it.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fh.prog.lab.it.samples.dbServices.newselect;

public class kundenpanel extends JPanel{

	ImageIcon iconback = new ImageIcon("./lib/back-button.png");
	JButton back = new JButton(iconback);
	JTable table = new JTable();
	newselect select = new newselect();
	
	public kundenpanel(ActionListener listener) throws SQLException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setSize((int)(width/2), (int)(height/100)*70);
		setLayout(new GridLayout(4,2));
		
		table = new JTable(select.getData("fikus"), select.getColumnNames("fikus"));
		add(new JScrollPane((table)));
		back.setActionCommand("kuback");
		back.addActionListener(listener);
		add(back);
	}
}
