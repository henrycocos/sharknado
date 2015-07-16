package fh.prog.lab.it.gui;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fh.prog.lab.it.samples.dbServices.newselect;

public class table extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2734880659491470068L;
	newselect select = new newselect();
	private Vector<String> columnNames;
	private Vector<Vector<String>> data;
	public table(String table, String name) throws SQLException{
		this.columnNames = select.getColumnNames(table);
		this.data = select.getData(table,name);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	public String getColumnName(int col){
		return columnNames.get(col);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

	public void setPreferredScrollableViewportSize(Dimension dimension) {
		setPreferredScrollableViewportSize(dimension);
	}

	public void setSelectionMode(int singleSelection) {
		setSelectionMode(singleSelection);
		
	}

	public void setAutoCreateRowSorter(boolean b) {
		setAutoCreateRowSorter(b);
		
	}

}
