/**
 * 
 */
package fh.prog.lab.it.samples.dbServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author NET
 *
 */
public class Update {

	/**
	 * 
	 */
	Statement stmt = null;
	Connection conn = null;
	
	public Update(Connection conn) {
		
		this.conn = conn;
	}
	
	public void doUpdate(String table) throws SQLException{
		
		String query = "UPDATE " + table + " SET name = 'admin' WHERE id in (8, 9)";
		
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
