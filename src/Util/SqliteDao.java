package Util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqliteDao {

	private static Connection connection;
	
	
	public static Connection getConnection() {
		if(connection == null) {
			createConnect();
		}
		return connection;
		
	}


	private static void createConnect() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:SaveFile.db");
			System.out.println("连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
	}
}
