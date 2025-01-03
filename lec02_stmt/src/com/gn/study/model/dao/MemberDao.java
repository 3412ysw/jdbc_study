package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;


public class MemberDao {
	
	public List<Member> selectMemberAll() {
		List<Member> list = new ArrayList<Member>();
		// 전체 member 정보 조회 -> List<Member> 형태로 리턴
		// DB에 SQL문 요청
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `member`");
			
			while(rs.next()) {
				Member m = new Member();
				m.setMemberNo(rs.getInt("m_no"));
				m.setMemberId(rs.getNString("m_id"));
				m.setMemberPw(rs.getNString("m_pw"));
				m.setMemberName(rs.getNString("m_name"));
				m.setMemberEmail(rs.getNString("m_email"));
				m.setMemberGender(rs.getNString("m_gender"));
				m.setMemberPhone(rs.getNString("m_phone"));
				m.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
			}
				
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO `member` (m_id ,m_pw ,m_name ,m_email ,m_gender ,m_phone)"
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()
					+"','"+m.getMemberName()+"','"+m.getMemberEmail()
					+"','"+m.getMemberGender()+"','"+m.getMemberPhone()+"')";
			result = stmt.executeUpdate(sql);
			
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
		 
		return result;
		
		
		
		
	}
}
