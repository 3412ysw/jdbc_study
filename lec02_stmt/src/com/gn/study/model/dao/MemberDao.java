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
	
	public Member checkmember(String memberId ,String memberPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	    Member m1 = new Member();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "SELECT *FROM `member` "
					+ "    WHERE m_id = '"+memberId+"' AND m_pw = '"+memberPw+"' ";
			 
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				m1.setMemberNo(rs.getInt("m_no"));
				m1.setMemberId(rs.getNString("m_id"));
				m1.setMemberPw(rs.getNString("m_pw"));
				m1.setMemberName(rs.getNString("m_name"));
				m1.setMemberEmail(rs.getNString("m_email"));
				m1.setMemberGender(rs.getNString("m_gender"));
				m1.setMemberPhone(rs.getNString("m_phone"));
				m1.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m1.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
			}else {
				return null;
			}
			
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
		return m1;
	}
	
	public int EditMember(String newName ,String newPhone, String newMail,String memberId) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "UPDATE `member`"
					+ "    SET m_name = '"+newName+"'"
					+ "	 , m_phone = '"+newPhone+"'"
					+ "	 ,m_email = '"+newMail+"'"
					+ "    WHERE m_id = '"+memberId+"'";
			 
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
	
	public int deleteMember(String memberId ,String memberPw) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM `member` "
					+ "WHERE m_id = '"+ memberId +"' AND m_pw = '"+memberPw+"'";
			 
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
	
	public List<Member> searchKeyWord(String memberName) {
		List<Member> list = new ArrayList<Member>();
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
			
			String sql = "SELECT * FROM `member`"
					+ "WHERE m_name LIKE '%" +memberName+"%'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Member m1 = new Member();
				m1.setMemberNo(rs.getInt("m_no"));
				m1.setMemberId(rs.getNString("m_id"));
				m1.setMemberPw(rs.getNString("m_pw"));
				m1.setMemberName(rs.getNString("m_name"));
				m1.setMemberEmail(rs.getNString("m_email"));
				m1.setMemberGender(rs.getNString("m_gender"));
				m1.setMemberPhone(rs.getNString("m_phone"));
				m1.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m1.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m1);
			}
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
		return list;
	}
	
	public Member searchId(String memberId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	    Member m1 = new Member();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw ="tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			
			String sql =  "SELECT *"
					+ " FROM `member`"
					+ " WHERE m_id = '" + memberId+"'";
			rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				m1.setMemberNo(rs.getInt("m_no"));
				m1.setMemberId(rs.getNString("m_id"));
				m1.setMemberPw(rs.getNString("m_pw"));
				m1.setMemberName(rs.getNString("m_name"));
				m1.setMemberEmail(rs.getNString("m_email"));
				m1.setMemberGender(rs.getNString("m_gender"));
				m1.setMemberPhone(rs.getNString("m_phone"));
				m1.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				m1.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return m1;
	
	
	}
	
	
	
	
	
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
