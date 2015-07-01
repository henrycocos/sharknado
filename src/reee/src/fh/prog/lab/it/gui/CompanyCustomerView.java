package fh.prog.lab.it.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CompanyCustomerView extends JDialog
implements ActionListener{
	
	private CompanyCustomer subject;
	private CompanyCustomerList all;
	
	private JTextField companyName;
	private JTextField companyAddress;
	private JTextField companyNumber;
	private JTextField companyZIP;
	
	private JPanel pane1;
	private JButton ok;
	
	
	public CompanyCustomerView()
	{
		subject = new CompanyCustomer();
		CompanyCustomerList.Instance();
		
		companyName = new JTextField(20);
		companyAddress = new JTextField(20);
		companyNumber = new JTextField(20);
		companyZIP = new JTextField(20);

		pane1 = new JPanel();
		ok = new JButton("OK");
		
		onInit();	
	}
	
	public void onInit()
	{
		this.setTitle("Company Customer");
		this.setLayout( new GridLayout(0,2,8,4) );
		
		
		
		this.add( new JLabel("Company Name: ") );
		this.add( companyName);
		this.add( new JLabel("Company Address: ") );
		this.add( companyAddress);
		this.add( new JLabel("Company Number: ") );
		this.add( companyNumber);
		this.add( new JLabel("Company ZIP: ") );
		this.add( companyZIP);
		
		
		ok.setActionCommand("OK");
		ok.addActionListener(this);
		pane1.add(ok);
		
		this.add(pane1, BorderLayout.SOUTH);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void onOK()
	{
		subject.setCompanyName(companyName.getText());
		subject.setCompanyAddress(companyAddress.getText());
		subject.setCompanyNumber(companyNumber.getText());
		subject.setCompanyZIP(companyZIP.getText());
		all.insertCompany(subject);
	}
	
	public void update()
	{
		subject = all.getCompany(subject);
		companyName.setText(""+subject.getCompanyName());
		companyAddress.setText(""+subject.getCompanyAddress());
		companyNumber.setText(""+subject.getCompanyNumber());
		companyZIP.setText(""+subject.getCompanyZIP());
		
	}
	
	public void actionPerformed(ActionEvent action)
	{
		if (action.getSource() == this.ok)
			this.onOK();
			this.setVisible(false);
			this.dispose();
			//subject.testPrint();
	}

}
