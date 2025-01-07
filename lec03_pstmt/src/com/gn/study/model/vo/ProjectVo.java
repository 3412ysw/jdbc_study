package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectVo {

	private int projectId; //PK(번호)
	private String projectName; // 프로젝트명
	private int projectManager; // FK(employee의 emp_id) -> 관리자 사번
	private LocalDateTime regDate; //등록일
	private LocalDateTime modDate; //수정일
	private String managerName;
	
	public ProjectVo() {}

	public ProjectVo(int projectId, String projectName, int projectManeger) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManeger;
	}
	
	public ProjectVo(int projectId, String projectName, int projectManeger, LocalDateTime regDate,
			LocalDateTime modDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManeger;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public ProjectVo(int projectId, String projectName, int projectManager, LocalDateTime regDate,
			LocalDateTime modDate, String managerName) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.regDate = regDate;
		this.modDate = modDate;
		this.managerName = managerName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(int projectManeger) {
		this.projectManager = projectManeger;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
	
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yy-MM-dd(E)");
		
		return "[번호 : " + projectId 
				+ ", 이름 : " + projectName 
//				+ ", 관리자 : "+ managerName+ "("+projectManager+")"
				+ ", 관리자 : "+ managerName
				+ ", 등록일 : " + regDate.format(date) 
				+ ", 수정일 : " + modDate.format(date) + "]";
	}
	
	
	
}