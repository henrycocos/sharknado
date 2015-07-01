package fh.prog.lab.it.samples.dbServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class newselect {
	
	private String urlPrefix = "jdbc:mysql://10.18.2.44";
	private String dbName = "sharknado";
	private String userName = "user";
	private String password ="programmingLab";
	private String port = "3306";
	
	Select sel = new Select(new DBServicesInvoker().conn);
	ResultSet res = null;
	int colCounter = 0;
	
	/*
	 * Speichert die Spaltennamen als Vector und liefert Sie zurück
	 * @param String table name
	 * Furkan Yücel
	 */
	public Vector<String> getColumnNames(String table) throws SQLException{
		Vector<String> name = new Vector<String>();

		try {

			String url = urlPrefix + ":" + port + "/";
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			Statement stmt = conn.createStatement();
			res = stmt.executeQuery("select * from " + table);
			ResultSetMetaData data = res.getMetaData();
			colCounter = data.getColumnCount();
			for (int i = 0; i < colCounter; i++) {
				name.add(data.getColumnName(i+1));
			}
			
		} catch (Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		}
		return name; 
	}
	
	public Vector<Vector<String>> getData(String table) throws SQLException{
		Vector<String> spalte = new Vector<String>();
		Vector<Vector<String>> gesamt = new Vector<Vector<String>>();


		String url = urlPrefix + ":" + port + "/";
		Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from " + table);
			try {
				ResultSetMetaData data = rs.getMetaData();
				colCounter = data.getColumnCount();
				int i = 1;
				while(rs.next()){
				spalte = new Vector<String>();
					for (int j = 1; j <= colCounter; j++) {
						spalte.add(rs.getString(j));	
					}
					gesamt.add(spalte);
					i++;
				}
			} catch (Exception e) {
				System.out.println("Fehler: " + e.getMessage());
			}
		
		return gesamt;
		
	}
}
