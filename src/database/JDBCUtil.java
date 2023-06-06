package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

//import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// Đăng ký MySQL Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// deprecated
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
			String url = "jdbc:mySQL://localhost:3306/ontap";
			String username = "root";
			String password = "";

			// Tao ket noi
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		if (c != null) {
			try {
				DatabaseMetaData metadata = (DatabaseMetaData) c.getMetaData();
				System.out.println(metadata.getDatabaseProductName());
				System.out.println(metadata.getDatabaseProductVersion());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
