package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	
	
	public String searchId(String memderId) {
		Member m = new Member();
		//String result = new MemberDao();
		return null;
		
	}
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}

	public int insertMember(String memberId ,String memberPw,String memberName
			,String memberEmail ,String memberPhone, String memberGender) {
		Member m = new Member(memberId, memberPw,memberName,memberEmail,memberPhone,memberGender);
		
		int result = new MemberDao().insertMember(m);
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
}
