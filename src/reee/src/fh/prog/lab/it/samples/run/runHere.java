package fh.prog.lab.it.samples.run;


import java.sql.SQLException;

import fh.prog.lab.it.gui.Controller;
import fh.prog.lab.it.gui.mainframe;
import fh.prog.lab.it.gui.menubar;
import fh.prog.lab.it.samples.dbServices.DBServicesInvoker;

public class runHere {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		new Controller();
		DBServicesInvoker dbService = new DBServicesInvoker();
		try {
			
			dbService.getDB();
		}catch (SQLException sqlex) {
			
			System.out.println("SQL Error : " + sqlex.getMessage());
		}  catch (Exception e) {
			
			System.out.println("SQL Error : " + e.getMessage());
		}
	}

}
