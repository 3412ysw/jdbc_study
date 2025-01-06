package com.gn.homework.controller;

import java.util.List;

import com.gn.homework.model.dao.Dao;
import com.gn.homework.model.vo.Member;

public class Controller {

	public int insertMember(String memberId, String memberPw , String memberName) {
		Member m = new Member(memberId,memberPw,memberName);
		int result = new Dao().insertMember(m);
		return result;
	}
	
	
	public Member login(String memberId, String memberPw) {
		Member result = new Dao().login(memberId, memberPw);
		return result;
	}
	
	public int insertMusic(String musicTitle ,String musicArtist) {
		Member m = new Member(musicTitle ,musicArtist);
		int result = new Dao().insertMusic(m);
		return result;
	}
	
	public List<Member> musicPlay(){
		List<Member> list = new Dao().musicPlay();
		return list;
	}
	
	public int musicCount(int num) {
		int result = new Dao().musicCount(num);
		return result;
	}
	
	public int editUser(String newName,String memberid) {
		int result = new Dao().editUser(newName,memberid);
		return result;
	}
	
	
	public int deleteUser(String memberid) {
		int result = new Dao().deleteUser(memberid);
		return result;
	}
	
	
}
