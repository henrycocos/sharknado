package fh.prog.lab.it.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fh.prog.lab.it.samples.dbServices.newselect;

public class produktpanel extends JPanel{
	Point klick;
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane pane;
	ImageIcon iconback = new ImageIcon("./lib/back-button.png");
	JButton back = new JButton(iconback);
	newselect select = new newselect();
	String name = null;
	search searchpanel;
	TableRowSorter<TableModel> sorter; 
	
	public produktpanel(ActionListener listener) throws SQLException{
		System.out.println("Produktpanel wurde gestartet");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setSize((int)(width/2), (int)(height/100)*70);
		setLayout(new GridLayout(4,2));
		searchpanel = new search(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == searchpanel.sbutton) {
					String name = searchpanel.tname.getText();
					String id = searchpanel.tid.getText();
					System.out.println("ID: " + id + "NAME: " + name);
					newFilter(id, name);
				}
				
			}
		});
		table = new JTable(new table("Produkt",null));
		table.setPreferredScrollableViewportSize(new Dimension((int)(width/2),HEIGHT-100));
		pane = new JScrollPane(table);
		add(searchpanel);
		add(pane);
		table.setAutoCreateRowSorter(true);
	    sorter  = new TableRowSorter<TableModel>(table.getModel());
	    table.setRowSorter(sorter);
		back.setActionCommand("proback");
		back.addActionListener(listener);
		add(back);
	}
	private void newFilter(String id,String name){
		RowFilter<? super TableModel, ? super Integer> rf = null;
	    //If current expression doesn't parse, don't update.
	    try {
	        rf = RowFilter.regexFilter(".*"+id+".*", 0);
	        rf = RowFilter.regexFilter(name, 1);
	    } catch (java.util.regex.PatternSyntaxException e) {
	    	e.printStackTrace();
	        return;
	    }
	    sorter.setRowFilter(rf);
	}
}
