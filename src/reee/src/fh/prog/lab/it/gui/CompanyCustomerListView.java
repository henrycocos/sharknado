package fh.prog.lab.it.gui;



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;




public class CompanyCustomerListView extends JDialog
implements ActionListener, Observer
{
	private JTable table;
	private CompanyCustomerList all;
	
	
	private Vector<String> colNames;
										
	private JScrollPane scpane1;
	private JPanel pane2;
	private JButton ok;
	private JButton modify;
	private JButton insert;
	
	public CompanyCustomerListView()
	{
		colNames = new Vector<String>();
		
		colNames.add("Company Name");
		colNames.add("Company Address");
		colNames.add("Company Number");
		colNames.add("Company ZIP");
		
		all = CompanyCustomerList.Instance();
		all.addObserver(this);
		table = new JTable(all.getCompList(),colNames);
		
		
		scpane1= new JScrollPane(table);
		
		pane2 = new JPanel();
		ok = new JButton("OK");
		modify = new JButton("Modify");
		insert = new JButton("Insert");
		
		onInit();
	}
	
	public void onInit()
	{
		this.setTitle("Company Customer List");
		this.setLayout( new BorderLayout() );
		
		
		ok.setActionCommand("OK");
		ok.addActionListener(this);
		pane2.add(ok);
		
		modify.setActionCommand("MODIFY");
		modify.addActionListener(this);
		pane2.add(modify);
		
		insert.setActionCommand("INSERT");
		insert.addActionListener(this);
		pane2.add(insert);
		
		this.add(scpane1, BorderLayout.CENTER);
		this.add(pane2, BorderLayout.SOUTH);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void onOK()
	{
		
	}
	
	public void onModify()
	{
		CompanyCustomerView view = new CompanyCustomerView();
		view.update();
	}
	
	public void onInsert()
	{
		CompanyCustomerView view = new CompanyCustomerView();
		
	}
	
	public void actionPerformed(ActionEvent action)
	{
		if (action.getSource() == this.ok)
		{	
			this.onOK();
			this.setVisible(false);
			this.dispose();
			//all.testPrint();
		}	
		 if(action.getSource() == this.modify)
		 { 
			 this.onModify();
		 	 
		 }	 
		 if(action.getSource() == this.insert)
		 {
			 this.onInsert();
			
		 }
	}

	@Override
	public void update(Observable observers, Object view) {
		
		this.update(getGraphics());
	}
}
