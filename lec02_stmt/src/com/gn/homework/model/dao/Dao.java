package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.homework.model.vo.Member;

public class Dao {

	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_user (u_id ,u_pw ,u_name)"
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()
					+"','"+m.getMemberName()+"')";
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
	
	
	public Member login(String memberId ,String memberPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	    Member m = new Member();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "SELECT *FROM wm_user "
					+ "    WHERE u_id = '"+memberId+"' AND u_pw = '"+memberPw+"' ";
			 
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				m.setMemberNo(rs.getInt("u_no"));
				m.setMemberId(rs.getNString("u_id"));
				m.setMemberPw(rs.getNString("u_pw"));
				m.setMemberName(rs.getNString("u_name"));
				m.setMemberDate(rs.getTimestamp("u_date").toLocalDateTime());
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
		
		return m;
	}
	
	public int insertMusic(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_song (s_title ,s_artist) "
					+ "VALUES ('"+m.getMusicTitle()+"','"+m.getMusicArtist()+"')";
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
	
	public List<Member> musicPlay(){
		
		List<Member> list = new ArrayList<Member>();
		// 전체 member 정보 조회 -> List<Member> 형태로 리턴
		// DB에 SQL문 요청
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM wm_song");
			
			while(rs.next()) {
				Member m = new Member();
				m.setMusicNo(rs.getInt("s_no"));
				m.setMusicTitle(rs.getNString("s_title"));
				m.setMusicArtist(rs.getNString("s_artist"));
				m.setMusicCount(rs.getInt("s_count"));
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
	
	public int musicCount(int num) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "UPDATE wm_song "
					+ "SET s_count = s_count + 1"
					+ " WHERE s_no = '"+num+"'";
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
	
	public int editUser(String newName, String memberid) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "UPDATE wm_user "
					+ "SET u_name = '"+newName+"' "
					+ "WHERE u_id = '"+memberid+"'";
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
	
	
	public int deleteUser(String memberid) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			String sql = "DELETE FROM wm_user "
					+ "WHERE u_id = '"+ memberid +"'";
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
