/**
 * 
 */
package fh.prog.lab.it.samples.dbServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author NET
 *
 */
public class Select {

	/**
	 * 
	 */
	
	Statement stmt = null;
	ResultSet rs = null;
	Connection conn = null;
	String query = null;
	
	public Select(Connection conn) {
		
		this.conn = conn;
	}

	public ResultSet doSelect(String table) throws SQLException{
		
		int colCounter = 0;
		query = "select * from " + table;
		
		this.stmt = conn.createStatement();
		this.rs = stmt.executeQuery(query);
		   
		ResultSetMetaData colInfo = rs.getMetaData();
		   
		colCounter = colInfo.getColumnCount();
		System.out.println("We Have " + colCounter + " columns in the DB.");
		System.out.println("--------------------------");
		
		while(this.rs.next()){
			System.out.println(colInfo.getColumnName(1));
			System.out.println("ID		: " + rs.getString(1));
			System.out.println("Product Name	: " + rs.getString(2));
			System.out.println("Version#	: " + rs.getString(3));
			System.out.println("Preis		: " + rs.getString(4));
			if(rs.getString(5) != "N/A"){
			System.out.println("SysAnforderung	: " + rs.getString(5));
			} else continue;
			System.out.println("--------------------------");
		}
		
		
		
		
		return this.rs;
		
	}
	
	public boolean closeDB(){
		
		boolean success = false;
		
		try {
			
			this.stmt.close();
			this.rs.close();
			this.conn.close();
			success = true;
		} catch (SQLException e) {

			System.out.println("SQL Error : " + e.getMessage());
		}
		
		return success;
		
	}


}
