package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	public int EditMember(String memberId, String memberPw, String newPw) {
		int result  = new MemberDao().EditMember(memberId, memberPw , newPw);
		return result;
	}
	
	public int deleteMember(String memberId, String memberPw) {
		
		int result = new MemberDao().deleteMember(memberId, memberPw);
		return result;
		
	}
	
	public List<Member> searchKeyWord(String memberName) {
		Member m = new Member();
		List<Member> list = new MemberDao().searchKeyWord(memberName);
		return list;
	}
	
	
	public Member searchId(String memderId) {
		Member m = new Member();
		Member result = new MemberDao().searchId(memderId);
		return result;
		
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
