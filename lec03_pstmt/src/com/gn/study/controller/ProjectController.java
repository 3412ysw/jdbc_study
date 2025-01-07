package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {

	private ProjectDao pd = new ProjectDao();
	
	public int deleteProject(int projectNo) {
		int result = pd.deleteProject(projectNo);
		return result;
	}
	
	public int editProject(int projectNo, String projectName) {
		int result = pd.editProject(projectNo, projectName);
		return result;
	}
	
	public List<ProjectVo> searchProjectManager(String managerName){
		List<ProjectVo> list = pd.searchProjectManager(managerName);
		return list;
	}
	
	public int insertProjectOne(String projectName, String managerName) {
		int result = pd.insertProjectOne(projectName,managerName);
		return result;
	}
	
	public List<ProjectVo> selectProjectAll(){
		List<ProjectVo> list = pd.selectProjectAll();
		return list;
	}
	
	public List<ProjectVo> searchProjectName(String projectName){
		List<ProjectVo> list = pd.searchProjectName(projectName);
		return list;
	}
	
	
	
}
