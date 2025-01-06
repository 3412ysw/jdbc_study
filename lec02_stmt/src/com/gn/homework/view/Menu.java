package com.gn.homework.view;

import java.util.List;
import java.util.Scanner;

import com.gn.homework.controller.Controller;
import com.gn.homework.model.vo.Member;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	private Controller c = new Controller();
	Member m = new Member();
	
	public void mainmenu() {
		
		while(true) {
			System.out.println("=== 초기메뉴 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : signUp(); break;
				case 2 : login(); break;
				default : System.out.println("잘못된 번호입니다.");
			}
		}	
	}
	
	public void signUp() {
		System.out.println("=== 회원가입 ===");
		System.out.print("아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 입력 : ");
		String memberName = sc.nextLine();
		int result = c.insertMember(memberId, memberPw, memberName);
		if(result>0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
	
	public void login() {
		System.out.println("=== 로그인 ===");
		System.out.print("아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		Member result = c.login(memberId, memberPw);
	    if(result != null) {
	    	System.out.println(result.getMemberName()+"님 환영합니다!");
	    	if(result.getMemberId().equals("admin")) {
	    		managerMenu();
	    	}else {
	    		userMenu();
	    	}
	    }else {
	    	System.out.println("로그인 실패");
	    }
	}
	
	public void managerMenu() {
		System.out.println("=== 관리자 메뉴 ===");
		System.out.println("1. 음악 추가");
		System.out.println("2. 음악 인기 순위 조회");
		System.out.print("메뉴 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {   
			case 1 : insertMusic(); break;
			case 2 : selectTopten(); break;
			default : System.out.println("잘못된 번호 입니다.");	
		}
		
		
	}
	
	public void userMenu() {
		System.out.println("=== 사용자 메뉴 ===");
		System.out.println("1. 음악 재생");
		System.out.println("2. 개인 정보 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.print("메뉴 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch(menu) {   
			case 1 : musicPlay(); break;
			case 2 : editUser(); break;
			case 3 : deleteUser(); break;
			default : System.out.println("잘못된 번호 입니다.");	
		}
	}
	
	public void insertMusic() {
		System.out.println("=== 음악 추가 ===");
		System.out.print("음원 제목 : ");
		String title = sc.nextLine();
		System.out.print("음원 아티스트 : ");
		String artist = sc.nextLine();
		int result = c.insertMusic(title, artist);
	    if(result > 0) {
	    	System.out.println("음원이 성공적을 추가되었습니다.");
	    }else {
	    	System.out.println("음원 추가에 실패하였습니다.");
	    }
		
	}
	
	public void selectTopten() {
		System.out.println("=== 인기 차트 ~!! ===");
		
	}
	
	public void musicPlay() {
		System.out.println("=== 음악 재생 ===");
		System.out.println("=== 전체 음악 목록 ===");
		List<Member> list = c.musicPlay();
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
			System.out.print("재생할 음악의 번호를 선택하세요 :");
			int num = sc.nextInt();
			int result = c.musicCount(num);
			if(result > 0) {
				System.out.println("노래 듣는 듕"); 
			}else {
				System.out.println("실패염");
			}
			
		}
	}
	
	public void editUser() {
		System.out.println("=== 회원 이름 변경 ===");
		System.out.print("아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		Member result = c.login(memberId, memberPw);
	    if(result != null) {
	    	System.out.print("변경할 이름 입력 : ");
	    	String newName = sc.nextLine();
	    	int result2 = c.editUser(newName, memberId);
	    	if(result2>0) {
	    		System.out.println("이름 변경 완료");
	    	}else {
	    		System.out.println("이름 변경 실패");
	    	}
	    }else {
	    	System.out.println("로그인 실패");
	    }
	}
	
	public void deleteUser() {
		System.out.println("=== 회원 탈퇴 ===");
		System.out.print("아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		Member result = c.login(memberId, memberPw);
	    if(result != null) {
	    	int result2 = c.deleteUser(memberId);
	    	if(result2>0) {
	    		System.out.println("탈퇴 성공");
	    	}else {
	    		System.out.println("탈퇴 실패");
	    	}
	    }else {
	    	System.out.println("로그인 실패");
	    }
	}
	
	
}
