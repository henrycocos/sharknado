package fh.prog.lab.it.gui;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import fh.prog.lab.it.main.Main;


public class Controller implements ActionListener{
	 menubar menu;
	 mainframe main;
	 homepanel home;
	 produktpanel produkt;
	 kundenpanel kunden;
	 Personpanel person;
	 
	public Controller() throws SQLException{
		System.out.println("Controller Gestartet");
		main = new mainframe(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String trigger = e.getActionCommand();
		switch (trigger) {
		case "Start": 	System.out.println("Hallo");
			break;
		case "produkt": main.home.setVisible(false);
						main.frame.add(main.produkt,BorderLayout.CENTER);
						main.produkt.setVisible(true);
			break;
		case "exit":	System.exit(0);
			break;
		case "refresh": main.frame.setVisible(false);
						main.frame.setVisible(true);
						main.refresh();
			break;
		case "kunden": 	main.home.setVisible(false);
					   	main.frame.add(main.kunden,BorderLayout.CENTER);
					   	main.kunden.setVisible(true);
			break;
		case "proback":	main.produkt.setVisible(false);
						main.home.setVisible(true);
			break;
		case "kuback":	main.kunden.setVisible(false);
						main.home.setVisible(true);
			
			break;
		case "persback": main.person.setVisible(false);
						 main.home.setVisible(true);
						break;

		case "person":  main.home.setVisible(false);
						main.frame.add(main.person,BorderLayout.CENTER);
			 			main.person.setVisible(true);
						break;
		default:
			break;
		}
		
	}

}
