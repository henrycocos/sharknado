/**
 * 
 */
package fh.prog.lab.it.samples.dbServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author NET
 *
 */
public class DBServicesInvoker {

	/**
	 * 
	 */
	//Credentials will be taken from here
	//******************************************
	private String urlPrefix = "jdbc:mysql://10.18.2.44";
	private String dbName = "sharknado";
	private String dbTableName = "Produkt";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "user";
	private String password ="programmingLab";
	private String port = "3306";
//	private String host = "127.0.0.1";
	//*******************************************
	public Connection conn = null;
	private String query = "select * from info";
	Statement stmt = null;
	ResultSet rs = null;
	public DBServicesInvoker() {

		try {
			
			openConnection();
		}catch (Exception e) {
			
			System.out.println("Error : " + e.getMessage());
		}
		
		
	}

	public void openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//Structure of this statement="jdbc:mysql://127.0.0.1:3306/"
		String url = urlPrefix + ":" + port + "/";
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);
	}
	public void getDB() throws SQLException{
		
		try {
			
			if(this.conn==null || this.conn.isClosed())
				openConnection();
			
			Select select = new Select(this.conn);
			select.doSelect("fikus");
			
			select.closeDB();
			
		} catch (Exception e) {
			
			System.out.println("IOError : " + e.getMessage());
		}
		
	}
	
	
	}
