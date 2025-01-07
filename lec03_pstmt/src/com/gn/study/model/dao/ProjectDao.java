package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.gn.study.model.vo.ProjectVo;

public class ProjectDao {
	
	
	public int deleteProject(int projectNo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "DELETE FROM project "
					    + "WHERE project_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectNo);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int editProject(int projectNo, String projectName) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "UPDATE project SET project_name = ? WHERE project_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectName);
			pstmt.setInt(2, projectNo);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<ProjectVo> searchProjectManager(String managerName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
		
			String sql = "SELECT p.project_id "
					+ "		,p.project_name	"
					+ "		,IFNULL(concat(e.emp_name,'(',p.project_manager,')'),'미정') AS 'emp_name' "
					+ "		,p.reg_date "
					+ "		,p.mod_date "
					+ "FROM project p "
					+ "LEFT JOIN employee e "
					+ "ON p.project_manager = e.manager_id "
					+ "WHERE e.emp_name = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
				vo.setManagerName(rs.getString("emp_name"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<ProjectVo> searchProjectName(String projectName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT p.project_id "
					+ "		,p.project_name	"
					+ "		,IFNULL(concat(e.emp_name,'(',p.project_manager,')'),'미정') AS 'emp_name' "
					+ "		,p.reg_date "
					+ "		,p.mod_date "
					+ "FROM project p "
					+ "LEFT JOIN employee e "
					+ "ON p.project_manager = e.manager_id "
					+ "WHERE p.project_name LIKE CONCAT('%',?,'%')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
				vo.setManagerName(rs.getString("emp_name"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	
	
	
	
	public List<ProjectVo> selectProjectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
		
			String sql = "SELECT p.project_id "
					+ "		,p.project_name	"
					+ "		,IFNULL(concat(e.emp_name,'(',p.project_manager,')'),'미정') AS 'emp_name' "
//					+ "		,IFNULL(p.project_manager,0) AS 'project_manager' "
					+ "		,p.reg_date "
					+ "		,p.mod_date "
					+ "FROM project p "
					+ "LEFT JOIN employee e "
					+ "ON p.project_manager = e.manager_id ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
//				vo.setProjectManager(rs.getInt("project_manager"));
				vo.setManagerName(rs.getString("emp_name"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertProjectOne(String projectName, String managerName) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "INSERT INTO project(project_name ,project_manager) "
					+ "VALUES ( ? ,(SELECT emp_id "
					+ "						FROM employee "
					+ "						WHERE emp_name = ? ))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectName);
			pstmt.setString(2, managerName);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
}
