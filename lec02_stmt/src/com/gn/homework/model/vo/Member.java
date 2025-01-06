package com.gn.homework.model.vo;

import java.time.LocalDateTime;

public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private LocalDateTime memberDate;
	private int musicNo;
	private String musicTitle;
	private String musicArtist;
	private int musicCount;
	

	public Member() {}

	public Member(String memberId, String memberPw, String memberName) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}

	public Member(String musicTitle, String musicArtist) {
		this.musicTitle = musicTitle;
		this.musicArtist = musicArtist;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
	public LocalDateTime getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(LocalDateTime memberDate) {
		this.memberDate = memberDate;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicArtist() {
		return musicArtist;
	}

	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}

	public int getMusicCount() {
		return musicCount;
	}
	
	public void setMusicCount(int musicCount) {
		this.musicCount = musicCount;
	}
	
	@Override
	public String toString() {
		return "[음원 번호 :" + musicNo + ", 음원 제목 :" + musicTitle + ", 음원 아티스트 :" + musicArtist + ", 재생횟수 :"+musicCount+"]";
	}
	
	
	


}
