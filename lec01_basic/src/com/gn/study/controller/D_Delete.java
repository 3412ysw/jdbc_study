package com.gn.study.controller;

import java.sql.Connection;
import java.sql.Statement;

public class D_Delete {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		// 2. try~catch~finally 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
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
