package fh.prog.lab.it.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fh.prog.lab.it.samples.dbServices.DBServicesInvoker;
import fh.prog.lab.it.samples.dbServices.newselect;

public class produktpanel extends JPanel{
	/**
	 * 
	 */
	Point klick;
	private static final long serialVersionUID = 1L;
	table table;
	JTable jtable;
	JScrollPane pane;
	search searchpanel;
	ImageIcon iconback = new ImageIcon("./lib/back-button.png");
	JButton back = new JButton(iconback);
	newselect select = new newselect();
	TableRowSorter<TableModel> sorter;
	ActionListener al;
	String id,name;
	RowFilter<TableModel, Object> rf;
	
	public produktpanel(ActionListener listener) throws SQLException{
		System.out.println("Produktpanel wurde gestartet");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setSize((int)(width/2), (int)(height/100)*70);
		setLayout(new GridLayout(4,2));
		jtable = new JTable(table);
		table = new table("Produkt",name);
		table.setPreferredScrollableViewportSize(new Dimension((int)(width/2),HEIGHT-100));
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pane = new JScrollPane(jtable);
		table.setAutoCreateRowSorter(true);
		
		
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) throws NullPointerException {
				name = searchpanel.tname.getText();
				System.out.println(name);
					if (name.length() == 0) {
						System.out.println("Leer:" + name);
					} else {
						try{
							System.out.println("Sortiert nach: " + name);
							table = new table("Produkt", name);
							table.fireTableDataChanged();
							table.repaint();
							
							
							
				} 	catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, e2);;
					} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
						sorter.setRowFilter(RowFilter.regexFilter(name, 1));
						System.out.println(sorter.getRowFilter().toString());
				}
				}
		};
		searchpanel = new search(al);
		add(searchpanel);
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
