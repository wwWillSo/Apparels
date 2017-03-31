package dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionA {
	private static final String DBURL = "jdbc:mysql://localhost:3306/apparelsms";
	private static final String DBUSER = "root";
	private static final String DBPASS = "19941224"; 
	private Connection conn = null;
	public 	DatabaseConnectionA()throws Exception{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		}catch (Exception e){
			throw e;
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close() throws Exception{
		if(this.conn != null){
			try{
				this.conn.close();
			}catch (Exception e){
				throw e;
			}
		}
	}
}
