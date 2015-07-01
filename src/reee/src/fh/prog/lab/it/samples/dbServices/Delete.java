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
public class Delete {

	/**
	 * 
	 */
	Statement stmt = null;
	Connection conn = null;
	
	public Delete(Connection conn) {
		
		this.conn = conn;
	}

	public void doDelete(String table, String value) throws SQLException{
		
		String query = "DELETE FROM " + table + " WHERE name = '" + value + "'";
		
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
