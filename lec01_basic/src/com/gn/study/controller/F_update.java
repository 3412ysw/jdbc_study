package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class F_update {

	public static void main(String[] args) {
	// 1. 작업용 객체 선언
			
			Connection conn = null;
			Statement stmt = null;
			
			// 2. try~catch~finally 
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
				String id = "scott";
				String pw = "tiger";
				conn = DriverManager.getConnection(url, id, pw);
				
				stmt = conn.createStatement();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					conn.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}

}
