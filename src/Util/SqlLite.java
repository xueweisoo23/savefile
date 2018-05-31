package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Data1;



public class SqlLite {
	private String sql;

	//创建表格
	public static void createTable() {
		Connection connection = SqliteDao.getConnection();
		java.sql.Statement statement;
		
		try {
			statement = connection.createStatement();
			//删除原来的表
			statement.executeUpdate("drop table if exists Data;");
			//创建表格
			String sql = "create table Data (name varchar(255),type varchar(255),size int(20), path varchar(255),time varchar(255));";
			statement.executeUpdate(sql);

			System.out.println("创建了名为Data的表");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//插入数据
	public static void insertData(Data1 d) {
		Connection connection = SqliteDao.getConnection();
		
		try {
			String sql2 = "insert into Data values(\"" + d.getName() +"\",\"" + d.getType() + "\"," + d.getSize() + ",\"" + d.getPath() + "\",\"" + d.getTime() +"\");";
			Statement statement1 = connection.createStatement();
			statement1.executeUpdate(sql2);
			System.out.println("插入数据成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//查询数据库中所有信息的方法
	public static ArrayList<Data1> query(){
		ArrayList<Data1> al=new ArrayList<Data1>();
		String sql= "select * from Data";
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

//	//查询数据库中单条信息的方法
//	public static ArrayList<Data1> singleQuery(String name){
//		ArrayList<Data1> al=new ArrayList<Data1>();
//		String sql= "select * from Data where name = \"" + name +"\";";
//		Connection conn=SqliteDao.getConnection();
//		Statement stat=null;
//		ResultSet rs=null;
//
//		try {
//			stat=conn.createStatement();
//			rs=stat.executeQuery(sql);
//			while(rs.next()){
//				String name=rs.getString("Name");
//				String type=rs.getString("Type");
//				int size=rs.getInt("Size");
//				String path=rs.getString("Path");
//				String time=rs.getString("Time");
//
//				Data1 d=new Data1(name, type, size, path, time);
//				al.add(d);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return al;
//	}

	//查重的方法
	
	public static void Check() {
		Statement stat=null;
		ResultSet rs=null;
		Connection connection = SqliteDao.getConnection();
		String sql="select * from Data where (Name,Type,Size,Psth,Time)in(select Name,Type,Size,Psth,Time from user group by Name,Type,Size,Psth,Time where having count(Name,Type,Size,Psth,Time)>1);";
		try {
			stat=connection.createStatement();
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}
}
