/**
 * 
 */
package fh.prog.lab.it.samples.dbServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author NET
 *
 */
public class Insert {

	/**
	 * 
	 */
	Statement stmt = null;
	Connection conn = null;
	
	public Insert(Connection conn) {
		
		this.conn = conn;
	}

	public void doInsert(String table) throws SQLException{
		
		boolean success = false;
		
		String query = "INSERT INTO " + table + "(name,surname,id) VALUES('alex','blabla','')";
		
		this.stmt = this.conn.createStatement();
		this.stmt.executeUpdate(query);
		
	}
	public boolean closeDB(){
		
		boolean success = false;
		
		try {
			
			this.stmt.close();
			this.conn.close();
			success = true;
		} catch (SQLException e) {

			System.out.println("SQL Error : " + e.getMessage());
		}
		
		return success;
		
	}

}
