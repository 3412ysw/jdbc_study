package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;


public class MemberMenu {
	private Scanner sc = new Scanner (System.in);
	private MemberController mc = new MemberController();

	// View : 사용자와의 상호작용
	public void mainMenu() {
		System.out.println("환영합니당!");
		// 사용자에게 정보 입력 받아서 Controller에 전달
		while(true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 0 : System.out.println("잘가요 안뇽"); return;
			case 1 : createMember(); break;
			case 2 : selectMemberAll(); break;
			case 3 : searchId(); break;
			case 4 : searchKeyWord(); break;
			case 5 : EditMember(); break;
			case 6 : deleteMember(); break;
			default : System.out.println("잘못된 번호에욤!");	
			}
		}
	}
	
	// 회원 탈퇴
	public void deleteMember() {
		System.out.println("=== 회원 탈퇴 ===");
		System.out.print("회원 아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.print("회원 비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		Member result1 = mc.checkmember(memberId, memberPw);
		 if(result1 != null) {
			 	int result2 = mc.deleteMember(memberId, memberPw);
			 	if(result2 >0) {
			 		System.out.println("회원탈퇴에 성공하셨습니다.");
			 	}else {
			 		System.out.println("실패 ,,");
			 	}
		    	
		    }else {
		    	System.out.println("존재하지 않는 아이디입니다.");
		    }
	
		
	}
	
	// 회원 정보 수정
    public void EditMember() {
    	System.out.println("=== 회원 정보 수정 ===");
    	System.out.print("회원 아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.print("회원 비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		Member result1 = mc.checkmember(memberId, memberPw);
		 if(result1 != null) {
			 	System.out.print("수정할 이름 입력 : ");
			 	String newName = sc.nextLine();
			 	System.out.print("수정할 전화번호 입력 : ");
			 	String newPhone = sc.nextLine();
			 	System.out.print("수정할 이메일 입력 : ");
			 	String newMail = sc.nextLine();
			 	int result2 = mc.EditMember(newName, newPhone, newMail, memberId);
			 	if(result2 >0) {
			 		System.out.println("회원정보가 변경되었습니다.");
			 	}else {
			 		System.out.println("실패 ,,");
			 	}
		    	
		    }else {
		    	System.out.println("존재하지 않는 아이디입니다.");
		    }
	

		
    }
	
	
	// 회원 이름으로 키워드 검색
	public void searchKeyWord() {
		System.out.println("=== 회원 이름으로 키워드 검색 ===");
		System.out.print("회원 이름 키워드 :");
		String membername = sc.nextLine();
		List<Member> list = mc.searchKeyWord(membername);
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
		
	}
	
	
	
	// 아이디 검색
	public void searchId() {
		System.out.println("=== 회원 아이디 검색 ===");
	    System.out.print("조회할 아이디 입력:");
	    String memderId = sc.nextLine();
	    Member m1 = mc.searchId(memderId);
	    if(m1 != null) {
	    	System.out.println(m1);
	    }else {
	    	System.out.println("존재하지 않는 아이디입니다.");
	    }
	    
	}
	
	
	
	
	// 전체회원 조회
	public void selectMemberAll() {
		System.out.println("=== 회원 전체 조회 ===");
		List<Member> list = mc.selectMemberAll();
		// (1) 만약에 list가 비어있다면 -> 조회된 결과가 없습니다.
		// (2) Member 목록 출력 
		
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
	}
	
	
	// 회원 추가 화면
	public void createMember() {
		System.out.println("=== 회원 정보 추가 ===");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		System.out.print("성별 : ");
		String memberGender = sc.nextLine();
		
		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		if(result > 0) {
			System.out.println("성공ㅎ");
		}else {
			System.out.println("실패ㅜ");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
