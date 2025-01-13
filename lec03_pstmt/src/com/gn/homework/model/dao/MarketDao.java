package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gn.homework.model.vo.MarkerVo;


public class MarketDao {
	
	
	public MarkerVo checkId(String userId) {
		MarkerVo mv = new MarkerVo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			
			String sql = "SELECT * FROM sm_user "
						+"WHERE u_id= ?  ";
			 
			pstmt =  conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
				mv.setUserNo(rs.getInt("u_no"));
				mv.setUserId(rs.getString("u_id"));
				mv.setUserPw(rs.getString("u_pw"));
				mv.setUserName(rs.getString("u_name"));
				mv.setUserRegdate(rs.getTimestamp(userId).toLocalDateTime());
				
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	public int insertUser(String userId, String userPw ,String userName) {
		int result = 0;
		return result;
	}
	
	
}
