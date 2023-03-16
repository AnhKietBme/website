package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// dang ky mySQL driver voi DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//Cac thong so
			String url ="jdbc:mySQL://localhost:3306/websitetinhluong";
			String username = "root";
			String password = "";
			// Tao Ket noi
			c = DriverManager.getConnection(url, username, password);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	public static void closeConnection(Connection c) {
		try {if(c!=null) {
			c.close();
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = (DatabaseMetaData) c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
