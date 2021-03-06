package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Data1;



public class SqlLite {
	private String sql;

	//鍒涘缓琛ㄦ牸
	public static void createTable() {
		Connection connection = SqliteDao.getConnection();
		java.sql.Statement statement;
		
		try {
			statement = connection.createStatement();
			//鍒犻櫎鍘熸潵鐨勮〃
			statement.executeUpdate("drop table if exists Data;");
			//鍒涘缓琛ㄦ牸
			String sql = "create table Data (name varchar(255),type varchar(255),size int(20), path varchar(255),time varchar(255));";
			statement.executeUpdate(sql);

			System.out.println("鍒涘缓浜嗗悕涓篋ata鐨勮〃");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//鎻掑叆鏁版嵁
	public static void insertData(Data1 d) {
		Connection connection = SqliteDao.getConnection();
		
		try {
			String sql2 = "insert into Data values(\"" + d.getName() +"\",\"" + d.getType() + "\"," + d.getSize() + ",\"" + d.getPath() + "\",\"" + d.getTime() +"\");";
			Statement statement1 = connection.createStatement();
			statement1.executeUpdate(sql2);
			System.out.println("鎻掑叆鏁版嵁鎴愬姛");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//鏌ヨ鏁版嵁搴撲腑鎵�鏈変俊鎭殑鏂规硶
	public static ArrayList<Data1> query(){
		ArrayList<Data1> al=new ArrayList<Data1>();
		String sql= "select * from Data ORDER BY name;";
		Connection conn=SqliteDao.getConnection();
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				String name=rs.getString("Name");
				String type=rs.getString("Type");
				int size=rs.getInt("Size");
				String path=rs.getString("Path");
				String time=rs.getString("Time");
				
				Data1 d=new Data1(name, type, size, path, time);
				al.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	//鏌ヨ鏁版嵁搴撲腑鍗曟潯淇℃伅鐨勬柟娉�
	public static ArrayList<Data1> singleQuery(String nameStr){
		ArrayList<Data1> al=new ArrayList<Data1>();
		String sql= "select * from Data where name = \"" + nameStr +"\";";
		Connection conn=SqliteDao.getConnection();
		Statement stat=null;
		ResultSet rs=null;

		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				String name=rs.getString("Name");
				String type=rs.getString("Type");
				int size=rs.getInt("Size");
				String path=rs.getString("Path");
				String time=rs.getString("Time");

				Data1 d=new Data1(name, type, size, path, time);
				al.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	//鏌ラ噸鐨勬柟娉�
	
	public static ArrayList<Data1> Check() {
		ArrayList<Data1> al=new ArrayList<Data1>();
		String sql= "SELECT * FROM Data tempTable WHERE (tempTable.time) IN (SELECT time FROM Data GROUP BY time HAVING count(*) >= 2 ORDER BY name) AND (tempTable.size) IN (SELECT size FROM Data GROUP BY size HAVING count(*) >= 2 ORDER BY size) OR (tempTable.name) IN (SELECT name FROM Data GROUP BY name HAVING count(*) >= 2 ORDER BY name);";
		Connection connection=SqliteDao.getConnection();
		Statement stat=null;
		ResultSet rs=null;
		try {
			stat=connection.createStatement();
			rs=stat.executeQuery(sql);

			while(rs.next()){
				String name=rs.getString("Name");
				String type=rs.getString("Type");
				int size=rs.getInt("Size");
				String path=rs.getString("Path");
				String time=rs.getString("Time");

				Data1 d=new Data1(name, type, size, path, time);
				al.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return al;
	
	}
}
