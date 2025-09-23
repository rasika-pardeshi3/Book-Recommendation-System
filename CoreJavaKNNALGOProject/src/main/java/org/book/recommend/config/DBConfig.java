package org.book.recommend.config;

import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBConfig {
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	static {
		try {
		   Properties p=new Properties();
	       p.load(new FileInputStream(new File("").getAbsolutePath()+ "\\src\\main\\resources\\db.properties"));
	       Class.forName(p.getProperty("driver"));
	       conn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"), p.getProperty("password"));
	       if(conn!=null) {
	    	   System.out.println("Database is connected");
	       }else {
	    	   System.out.println("Database is not connected");
	       }
//	       System.out.println("Property files read Sucessfully.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
