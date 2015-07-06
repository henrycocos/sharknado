package fh.prog.lab.it.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fh.prog.lab.it.samples.dbServices.newselect;

public class produktpanel extends JPanel{
	/**
	 * 
	 */
	Point klick;
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane pane;
	ImageIcon iconback = new ImageIcon("./lib/back-button.png");
	JButton back = new JButton(iconback);
	newselect select = new newselect();
	RowFilter<Vector, String> filter;
	TableRowSorter<TableModel> sorter ;
	public produktpanel(ActionListener listener) throws SQLException{
		System.out.println("Produktpanel wurde gestartet");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setSize((int)(width/2), (int)(height/100)*70);
		setLayout(new GridLayout(4,2));
		table = new JTable(new table("Produkt"));
		table.setPreferredScrollableViewportSize(new Dimension((int)(width/2),HEIGHT-100));
		pane = new JScrollPane(table);
		add(pane);

		table.setAutoCreateRowSorter(true);
		back.setActionCommand("proback");
		back.addActionListener(listener);
		add(back);
		
		
	}
	
	public boolean isCellEditable(int row, int col){
		return false;
	}

}
