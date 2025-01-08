package com.gn.study.model.service;

import java.sql.Connection;
import java.sql.DriverManager;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;
import static com.gn.study.common.JDBCTemplate.getConnection;
import static com.gn.study.common.JDBCTemplate.close;

// DB에 접속 -> Connection 객체 생성
public class Service {
	private Dao dao = new Dao();
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.inertCarOne(car, conn);
		close(conn);
		return result;
		
		
//		Connection conn = null;
//		int result = 0;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String user = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url,user,pw);
//			result = dao.inertCarOne(car,conn);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null)conn.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	
	
}