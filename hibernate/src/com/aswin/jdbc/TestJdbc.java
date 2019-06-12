package com.aswin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting " + jdbcUrl);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
