package com.chainsys.libraryapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import com.chainsys.libraryapp.exception.DbException;

public class Connectionutil {
	public static Connection getConnection() throws DbException {
		Connection connection = null; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE","ajmal","ajmal");
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}
		 
		 catch (SQLException e) {
			e.printStackTrace();
		}
			
			return connection;
		
	}
	public static Jdbi getJdbi() {
		Jdbi jdbi = null;
		try {
			Connection connection = getConnection();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jdbi;
	}

}
